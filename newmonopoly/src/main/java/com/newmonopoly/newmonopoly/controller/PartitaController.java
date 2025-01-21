package com.newmonopoly.newmonopoly.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newmonopoly.newmonopoly.model.AbstractGame;
import com.newmonopoly.newmonopoly.model.Game;
import com.newmonopoly.newmonopoly.model.factory.FactoryGame;
import com.newmonopoly.newmonopoly.model.Config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/partite")
public class PartitaController {

    private Game partita; // Memorizza la partita in corso

    @RequestMapping(value = "/partita", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        // Risposta vuota per la richiesta OPTIONS
        return ResponseEntity.ok().build();
    }

    @PostMapping("/partita")
    public ResponseEntity<String> creaPartita(@RequestBody Config config) {
        try {
            if (partita != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Una partita è già in corso. Termina la partita corrente per crearne una nuova.");
            }
            // Crea una nuova partita usando FactoryGame
            AbstractGame nuovaPartita = FactoryGame.getInstance().creaPartita(config);

            // Imposta la partita corrente
            this.partita = (Game) nuovaPartita;

            scriviSuJson("admin", partita.getConfig().getAdmin().getNome());

            return ResponseEntity.ok("Partita creata con successo!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Errore durante la creazione della partita: " + e.getMessage());
        }
    }

    private void scriviSuJson(String chiave, String valore) {
    ObjectMapper mapper = new ObjectMapper(); // Oggetto Jackson per gestire il JSON
    Map<String, String> dati = new HashMap<>();

    try {
        // Leggi il file esistente (se esiste)
        File file = new File("debug.json");
        if (file.exists()) {
            dati = mapper.readValue(file, Map.class); // Converte il file JSON in una mappa
        }

        // Aggiungi o aggiorna la nuova chiave-valore
        dati.put(chiave, valore);

        // Scrivi di nuovo sul file JSON
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, dati);
    } catch (IOException e) {
        e.printStackTrace(); // In caso di errori
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
