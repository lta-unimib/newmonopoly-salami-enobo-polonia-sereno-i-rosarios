package com.newmonopoly.newmonopoly.model.gamer;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Stazione;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Societa;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada.Colore;



public class Giocatore implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;

    @Getter @Setter
    private String nome;
    @Getter @Setter
    private Map<Integer, Banconota> banconote;
    @Getter @Setter
    private int puntiFedelta;
    @Getter @Setter
    private List<Proprieta> proprieta;

    public Giocatore(String nome) {
        this.nome = nome;
        this.banconote = new HashMap<>();
        this.puntiFedelta = 0;
        this.proprieta = new ArrayList<>();
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
        if (utilizzaBanconotaEsatta(quantita)) {
            return;
        }
        if (utilizzaBanconotaMaggiore(quantita)) {
            return;
        }
        combinaBanconote(quantita);
        if (quantita > 0) {
            throw new IllegalArgumentException("Impossibile completare il pagamento con le banconote disponibili.");
        }
    }

    private boolean utilizzaBanconotaEsatta(int quantita) {
        if (banconote.containsKey(quantita) && banconote.get(quantita).getQuantita() > 0) {
            banconote.get(quantita).modificaQuantita(-1); // Usa una banconota esatta
            return true;
        }
        return false;
    }

    private boolean utilizzaBanconotaMaggiore(int quantita) {
        for (Integer valoreBanconota : new TreeSet<>(banconote.keySet())) { // Ordinamento crescente
            Banconota banconota = banconote.get(valoreBanconota);
            if (valoreBanconota > quantita && banconota.getQuantita() > 0) {
                banconota.modificaQuantita(-1); // Usa la banconota
                int resto = valoreBanconota - quantita;
                ricevi(resto); // Restituisci il resto con banconote più piccole
                return true;
            }
        }
        return false;
    }

    private void combinaBanconote(int quantita) {
        for (Integer valoreBanconota : new TreeSet<>(banconote.keySet()).descendingSet()) { // Ordinamento decrescente
            Banconota banconota = banconote.get(valoreBanconota);
            while (quantita >= valoreBanconota && banconota.getQuantita() > 0) {
                banconota.modificaQuantita(-1);
                quantita -= valoreBanconota;
            }
        }
    }

    public int getSaldo(){
        int totale = 0;
        for (Banconota banconota : banconote.values()) {
            totale += banconota.getValore() * banconota.getQuantita();
        }
        return totale;
    }

    public boolean possiedeTutteLeProprietaDelColore(Colore colore) {
    for (Proprieta p : this.proprieta) {
    if (p instanceof Strada) {
        Strada strada = (Strada) p;
        if (strada.getColore() != colore) {
            return false;
        }
    }
    }
    return true;
    }

    public List<Proprieta> getStazioni(){
        List<Proprieta> stazioni = new ArrayList<>();
        for(Proprieta p : this.proprieta){
            if(p instanceof Stazione){
                stazioni.add(p);
            }
        }
    return stazioni;
    }

    public List<Proprieta> getSocieta(){
        List<Proprieta> societa = new ArrayList<>();
        for(Proprieta p : this.proprieta){
            if(p instanceof Societa){
                societa.add(p);
            }
        }
        return societa;
    }

    // Metodo per aggiungere una proprietà alla lista del giocatore
    public void aggiungiProprieta(Proprieta proprieta) {
        this.proprieta.add(proprieta);
    }

    // Metodo per rimuovere una proprietà dalla lista del giocatore
    public void rimuoviProprieta(Proprieta proprieta) {
        this.proprieta.remove(proprieta);
    }

    // Metodi per ottenere la quantità di banconote in un dato momento
    public int getBanconoteDaCinquecento() {
        return banconote.get(500).getQuantita();
    }

    public int getBanconoteDaCento() {
        return banconote.get(100).getQuantita();
    }

    public int getBanconoteDaCinquanta() {
        return banconote.get(50).getQuantita();
    }

    public int getBanconoteDaVenti() {
        return banconote.get(20).getQuantita();
    }

    public int getBanconoteDaDieci() {
        return banconote.get(10).getQuantita();
    }

    public int getBanconoteDaCinque() {
        return banconote.get(5).getQuantita();
    }

    public int getBanconoteDaUno() {
        return banconote.get(1).getQuantita();
    }
}
