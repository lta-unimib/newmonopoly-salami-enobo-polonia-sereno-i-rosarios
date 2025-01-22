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


// @RequestMapping("/api/partita")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PartitaController {

    private Game partita; // Memorizza la partita in corso

    // @RequestMapping(value = "/partita", method = RequestMethod.OPTIONS)
    // public ResponseEntity<?> handleOptions() {
    //     // Risposta vuota per la richiesta OPTIONS
    //     return ResponseEntity.ok().build();
    // }

    @PostMapping(value = "/partita")
    public ResponseEntity<String> creaPartita(@RequestBody Config config) throws IOException {
        
        // Logica per creare una nuova partita
        AbstractGame nuovaPartita = FactoryGame.getInstance().creaPartita(config);
        this.partita = (Game) nuovaPartita;
    
        // Restituisci il nome dell'admin (può essere migliorato con una risposta più complessa se necessario)
        return ResponseEntity.ok(partita.getConfig().getAdmin().getNome());
    }


//     private void scriviSuJson(String chiave, String valore) {
//     ObjectMapper mapper = new ObjectMapper(); // Oggetto Jackson per gestire il JSON
//     Map<String, String> dati = new HashMap<>();

//     try {
//         // Leggi il file esistente (se esiste)
//         File file = new File("debug.json");
//         if (file.exists()) {
//             dati = mapper.readValue(file, Map.class); // Converte il file JSON in una mappa
//         }

//         // Aggiungi o aggiorna la nuova chiave-valore
//         dati.put(chiave, valore);

//         // Scrivi di nuovo sul file JSON
//         mapper.writerWithDefaultPrettyPrinter().writeValue(file, dati);
//     } catch (IOException e) {
//         e.printStackTrace(); // In caso di errori
//     }
// }

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
