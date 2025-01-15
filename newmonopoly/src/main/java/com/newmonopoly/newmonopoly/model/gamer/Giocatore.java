package com.newmonopoly.newmonopoly.model.gamer;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

@Getter
@Setter
public class Giocatore implements Serializable {

    private String nome;
    private Map<Integer, Banconota> banconote;
    private int puntiFedelta;

    public Giocatore(String nome) {
        this.nome = nome;
        this.banconote = new HashMap<>();
        this.puntiFedelta = 0;
        inizializzaBanconote();
    }

    private void inizializzaBanconote() {
        banconote.put(500, new Banconota(500, 2));  // 2 banconote da 500
        banconote.put(100, new Banconota(100, 4));  // 4 banconote da 100
        banconote.put(50, new Banconota(50, 1));    // 1 banconota da 50
        banconote.put(20, new Banconota(20, 1));    // 1 banconota da 20
        banconote.put(10, new Banconota(10, 1));    // 1 banconota da 10
        banconote.put(5, new Banconota(5, 1));      // 1 banconota da 5
        banconote.put(1, new Banconota(1, 5));      // 5 banconote da 1
    }

    public void ricevi(int quantita) {
    
        for (Integer valoreBanconota : new TreeSet<>(banconote.keySet()).descendingSet()) {
            Banconota banconota = banconote.get(valoreBanconota);
            int quantitaDaAggiungere = quantita / valoreBanconota;
            if (quantitaDaAggiungere > 0) {
                banconota.modificaQuantita(quantitaDaAggiungere); 
                quantita -= quantitaDaAggiungere * valoreBanconota; 
            }
            if (quantita == 0) {
                break;
            }
        }
    }
    

    public void pay(int quantita) {
        if (getSaldo() < quantita) {
            throw new IllegalArgumentException("Saldo insufficiente per effettuare il pagamento.");
        }
    
        for (Integer valoreBanconota : new TreeSet<>(banconote.keySet()).descendingSet()) {
    Banconota banconota = banconote.get(valoreBanconota);
    while (quantita >= valoreBanconota && banconota.getQuantita() > 0) {
        banconota.modificaQuantita(-1);
        quantita -= valoreBanconota;
    }
}

    
        if (quantita > 0) {
            throw new IllegalStateException("Errore: pagamento non completato nonostante saldo sufficiente.");
        }
    }
    

    public int getSaldo(){
        int totale = 0;
        for (Banconota banconota : banconote.values()) {
            totale += banconota.getValore() * banconota.getQuantita();
        }
        return totale;
    }


    // Metodi per ottenere la quantità di banconote in un dato momento
    public int getBanconoteDaCinquecento() {
        int quantita = banconote.get(500).getQuantita();
        return quantita;
    }

    public int getBanconoteDaCento() {
        int quantita = banconote.get(100).getQuantita();
        return quantita;
    }

    public int getBanconoteDaCinquanta() {
        int quantita = banconote.get(50).getQuantita();
        return quantita;
    }

    public int getBanconoteDaVenti() {
        int quantita = banconote.get(20).getQuantita();
        return quantita;
    }

    public int getBanconoteDaDieci() {
        int quantita = banconote.get(10).getQuantita();
        return quantita;
    }

    public int getBanconoteDaCinque() {
        int quantita = banconote.get(5).getQuantita();
        return quantita;
    }

    public int getBanconoteDaUno() {
        int quantita = banconote.get(1).getQuantita();
        return quantita;
    }

    /* classe funzionante creata per controllare che le banconote venissero aggiunte o detratte correttamente
        public String mostraBanconote() {
            StringBuilder sb = new StringBuilder();
            sb.append("Banconote di ").append(nome).append(":\n");
            
            // Itera attraverso le chiavi (valori delle banconote) in ordine decrescente
            for (Integer valoreBanconota : new TreeSet<>(banconote.keySet()).descendingSet()) {
                Banconota banconota = banconote.get(valoreBanconota);
                sb.append(valoreBanconota).append("$: ").append(banconota.getQuantita()).append(" banconote\n");
            }
            return sb.toString();
        }
    */
    

}
