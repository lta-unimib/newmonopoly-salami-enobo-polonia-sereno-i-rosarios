package com.newmonopoly.newmonopoly.model.tabellone;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

public class Societa extends Proprieta {
    
    public Societa(String nome, Giocatore proprietario, int costo, int ipoteca, int affitto) {
        super(nome, proprietario, costo, ipoteca);
        setAffitto(affitto);
    }
}
