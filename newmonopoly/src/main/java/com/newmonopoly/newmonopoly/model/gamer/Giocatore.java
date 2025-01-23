package com.newmonopoly.newmonopoly.model.gamer;

import com.newmonopoly.newmonopoly.model.AbstractGame;
import com.newmonopoly.newmonopoly.model.tabellone.carte.Carta;
import com.newmonopoly.newmonopoly.model.transazioni.IPagamenti;
import com.newmonopoly.newmonopoly.model.transazioni.PagamentiGiocatore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Stazione;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Societa;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada.Colore;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Giocatore implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;

    @JsonIgnore
    private AbstractGame game;

    @JsonIgnore
    private String idSessione;
    private String nome;
    private Map<Integer, Banconota> banconote;
    private int puntiFedelta;
    private Token token;

    @Builder.Default
    private ArrayList<Proprieta> proprieta = new ArrayList<Proprieta>();

    @Builder.Default
    private Queue<Carta> cartePossedute = new LinkedList<>(); // carte x uscire di prigione

    @JsonIgnore
    @Builder.Default
    private transient IPagamenti strategiaCalcoloAffitto = new PagamentiGiocatore();

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
        if (getSaldo() < quantita && convertiPuntiInDenaro(puntiFedelta) < quantita) {
            throw new IllegalArgumentException("Saldo e punti insufficienti per effettuare il pagamento.");
        }
        if(puntiFedelta > 0 || getSaldo() > quantita) {
            int resto= quantita - convertiPuntiInDenaro(puntiFedelta);

            if(resto > 0) {
                if (utilizzaBanconotaEsatta(resto)) {
                    return;
             }

                if (utilizzaBanconotaMaggiore(resto)) {
                return;
            }
            combinaBanconote(resto);
            if (quantita > 0) {
                throw new IllegalArgumentException("Impossibile completare il pagamento con le banconote disponibili.");
            }
        }
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

    public void aggiungiPuntiFedelta(int importo){
        puntiFedelta += (int) (importo / 50);
    }

    public int convertiPuntiInDenaro(int punti){
        return punti * 50;
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
        proprieta.setProprietario(this);
    }

    public void acquistaProprieta(Proprieta proprieta, Giocatore venditore, int importo){
        if (venditore != null){
            venditore.ricevi(importo);
        }
        this.pay(importo);
        aggiungiProprieta(proprieta);
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
