package com.newmonopoly.newmonopoly.model.gamer;

import com.newmonopoly.newmonopoly.model.tabellone.Proprieta;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

    public void ricevi(int quantita)
    {
        //da implementare
    }

    public void pay(int quantita)
    {
        if(this.getSaldo() >= quantita) {
            //da implementare
        }
    }

    public int getSaldo(){
        int totale = 0;
        for (Banconota banconota : banconote.values()) {
            totale += banconota.getValore() * banconota.getQuantita();
        }
        return totale;
    }


    /* Metodo per modificare la quantità di una banconota (aggiungere o sottrarre)
    public void modificaBanconote(int valore, int quantita) {
        Banconota banconota = banconote.get(valore);
        if (banconota != null) {
            banconota.modificaQuantita(quantita);
        }
    } */

}
