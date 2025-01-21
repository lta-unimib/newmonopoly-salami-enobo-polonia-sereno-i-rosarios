package com.newmonopoly.newmonopoly.model;

import com.newmonopoly.newmonopoly.model.gamer.Banconota;
import lombok.Data;
import com.newmonopoly.newmonopoly.model.gamer.Admin;
import java.io.Serializable;
import java.util.Map;

@Data
public class Config implements Serializable {

    private boolean caselleCasuali;
    private boolean fluttuazioneEconomica;
    private Map<Integer, Banconota> banconote;
    private Difficolta difficolta;
    private Admin admin;
    private int numeroGiocatori;

    // Costruttore pubblico
    public Config() {
        banconote = inizializzaBanconote();    
        caselleCasuali = false;
        fluttuazioneEconomica = false;
        difficolta = Difficolta.EASY;
        numeroGiocatori = 6;
    }

    public enum Difficolta {
        EASY,
        MEDIUM,
        HARD
    }

    public Admin getAdmin() {
        return admin;
    }

    protected Map<Integer, Banconota> inizializzaBanconote() {
        banconote.put(500, new Banconota(500, 2));  // 2 banconote da 500
        banconote.put(100, new Banconota(100, 4));  // 4 banconote da 100
        banconote.put(50, new Banconota(50, 1));    // 1 banconota da 50
        banconote.put(20, new Banconota(20, 1));    // 1 banconota da 20
        banconote.put(10, new Banconota(10, 1));    // 1 banconota da 10
        banconote.put(5, new Banconota(5, 1));      // 1 banconota da 5
        banconote.put(1, new Banconota(1, 5));      // 5 banconote da 1
        return null;
    }
}
