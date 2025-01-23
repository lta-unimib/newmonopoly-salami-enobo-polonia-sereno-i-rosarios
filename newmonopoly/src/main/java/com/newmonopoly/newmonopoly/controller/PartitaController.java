package com.newmonopoly.newmonopoly.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newmonopoly.newmonopoly.eventi.gamer.EntraInPartita;
import com.newmonopoly.newmonopoly.model.AbstractGame;
import com.newmonopoly.newmonopoly.model.Game;
import com.newmonopoly.newmonopoly.model.factory.FactoryGame;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.gamer.Imprenditore;
import com.newmonopoly.newmonopoly.model.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// @RequestMapping("/api/partita")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PartitaController {

    private Game partita; // Memorizza la partita in corso
    private final SimpMessagingTemplate messagingTemplate;
    private List<String> lobbyGiocatori = new ArrayList<>();
    private boolean isPartitaCreata;

    // @RequestMapping(value = "/partita", method = RequestMethod.OPTIONS)
    // public ResponseEntity<?> handleOptions() {
    //     // Risposta vuota per la richiesta OPTIONS
    //     return ResponseEntity.ok().build();
    // }

    @Autowired
    public PartitaController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/lobby/entra")
    public void entraInLobby(@Payload AddPlayer body, SimpMessageHeaderAccessor head) {
        String nuovoGiocatore = body.getNickname();

        synchronized (lobbyGiocatori) {
            if (!lobbyGiocatori.contains(nuovoGiocatore) && lobbyGiocatori.size() < 6) {
                lobbyGiocatori.add(nuovoGiocatore);
                System.out.println("Giocatore aggiunto alla lobby: " + nuovoGiocatore);
            }
        }
        // Notifica tutti i client con la lista aggiornata dei giocatori
        messagingTemplate.convertAndSend("/topic/lobby", lobbyGiocatori);
    }

    @MessageMapping("/lobby/esci")
    public void esciDallaLobby(@Payload AddPlayer body, SimpMessageHeaderAccessor head) {
        String giocatoreDaTogliere = body.getNickname();
        System.out.println(body);

        synchronized (lobbyGiocatori) {
            if (lobbyGiocatori.contains(giocatoreDaTogliere)) {
                lobbyGiocatori.remove(giocatoreDaTogliere);
                System.out.println("Giocatore rimosso dalla lobby: " + giocatoreDaTogliere);
            } 
        }
        // Notifica tutti i client con la lista aggiornata dei giocatori
        messagingTemplate.convertAndSend("/topic/lobby", lobbyGiocatori);
    }

    @MessageMapping("/lobby/svuota")
    public void svuotaLobby(SimpMessageHeaderAccessor head) {

        synchronized (lobbyGiocatori) {
                lobbyGiocatori.removeAll(lobbyGiocatori);
            } 

        // Notifica tutti i client con la lista aggiornata dei giocatori
        messagingTemplate.convertAndSend("/topic/lobby", lobbyGiocatori);
    }

    @PostMapping(value = "/partita")
    public ResponseEntity<String> creaPartita(@RequestBody Config config) throws IOException {
        
        // Logica per creare una nuova partita
        AbstractGame nuovaPartita = FactoryGame.getInstance().creaPartita(config);
        this.partita = (Game) nuovaPartita;

    
        return ResponseEntity.ok(partita.getConfig().getAdmin().getNome());
    }
    
    @MessageMapping("/partita/creata")
    public void partitaCreata(@Payload Map<String, String> payload, SimpMessageHeaderAccessor head) {
        try {
            // Leggi l'azione dal payload
            String action = payload.get("action");

            if ("start".equals(action)) {
                // Solo quando l'azione è "start", imposta la partita come creata
                isPartitaCreata = true;

                // Notifica tutti i client che la partita è stata avviata
                messagingTemplate.convertAndSend("/topic/partita/creata", isPartitaCreata);
            } else {
                System.out.println("Azione non riconosciuta: " + action);
            }
        } catch (Exception e) {
            System.err.println("Errore durante l'elaborazione del messaggio: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @MessageMapping("/partita/entra")
    public void accediPartita(@Payload List<AddPlayer> giocatori, SimpMessageHeaderAccessor head) {
        AbstractGame partita = this.partita;
        if (partita != null) {
            // try {
                for(AddPlayer a : giocatori){
                    Giocatore g = Giocatore.builder()
                        .nome(a.getNickname())
                        .idSessione(head.getSessionId())
                        .build();

                    EntraInPartita azione = EntraInPartita.builder()
                        .giocatore(g)
                        .build();
                    partita.handleEvent(azione);
                }
                // partita.registraGiocatore(head.getSessionId(), partita.getGiocatoreByName(body.getNickname()));
            // } catch (PartitaPienaException e) {
            //     Map<String, Object> headers = new HashMap<>();
            //     headers.put("nickname", body.getNickname());
            //     MessageBrokerSingleton.getInstance().getTemplate()
            //             .convertAndSend("/topic/partit/Partita piena", headers);
            // }
        }
    }

    @PostMapping("/termina")
    public ResponseEntity<String> terminaPartita() {
        if (partita == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Nessuna partita è attualmente in corso.");
        } else {
            partita = null; // Termina (rimuove) la partita in corso
            return ResponseEntity.ok("Partita terminata con successo!");
        }
    }
}
