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

    @PostMapping(value = "/partita")
    public ResponseEntity<String> creaPartita(@RequestBody Config config) throws IOException {
        
        // Logica per creare una nuova partita
        AbstractGame nuovaPartita = FactoryGame.getInstance().creaPartita(config);
        this.partita = (Game) nuovaPartita;
    
        // Restituisci il nome dell'admin (può essere migliorato con una risposta più complessa se necessario)
        return ResponseEntity.ok(partita.getConfig().getAdmin().getNome());
    }


    @MessageMapping("/partita/entra")
    public void entraInPartita(
            @Payload AddPlayer body,
            SimpMessageHeaderAccessor head
    ) {
        AbstractGame partita = this.partita;
        if (partita != null) {
            // try {
                Giocatore g;

                if(Boolean.TRUE.equals(body.getIsImprenditore())) {
                    g = Imprenditore.builder().nome(body.getNickname()).idSessione(head.getSessionId()).build();
                } else {
                    g = Giocatore.builder()
                            .nome(body.getNickname())
                            .idSessione(head.getSessionId())
                            .build();
                }

                EntraInPartita azione = EntraInPartita.builder()
                        .giocatore(g)
                        .build();
                // partita.onAzioneGiocatore(azione);
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
