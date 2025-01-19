package com.newmonopoly.newmonopoly.config;

import com.newmonopoly.newmonopoly.model.AbstractGame;
import com.newmonopoly.newmonopoly.model.Game;
import com.newmonopoly.newmonopoly.model.Config;
import com.newmonopoly.newmonopoly.model.servizi.FactoryGame;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/partite")
public class PartitaController {

    private Game partitaCorrente; // Memorizza la partita in corso

    @PostMapping("/crea")
    public ResponseEntity<String> creaPartita(@RequestBody Config config) {
        try {
            // Crea una nuova partita usando FactoryGame
            AbstractGame nuovaPartita = FactoryGame.getInstance().creaPartita(config);

            // Imposta la partita corrente
            this.partitaCorrente = (Game) nuovaPartita;

            return ResponseEntity.ok("Partita creata con successo!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Errore durante la creazione della partita: " + e.getMessage());
        }
    }

    @GetMapping("/corrente")
    public ResponseEntity<Game> getPartitaCorrente() {
        if (partitaCorrente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Nessuna partita in corso
        } else {
            return ResponseEntity.ok(partitaCorrente); // Torna la partita corrente al client
        }
    }

    @PostMapping("/termina")
    public ResponseEntity<String> terminaPartita() {
        if (partitaCorrente == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Nessuna partita è attualmente in corso.");
        } else {
            partitaCorrente = null; // Termina (rimuove) la partita in corso
            return ResponseEntity.ok("Partita terminata con successo!");
        }
    }
}
