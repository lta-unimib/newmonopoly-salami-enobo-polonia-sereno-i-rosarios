package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.model.transazioni.IPagamenti;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

public class Societa extends Proprieta {
    
    public Societa(String nome, Giocatore proprietario, int costo, int ipoteca, int affitto) {
        super(nome, proprietario, costo, ipoteca, affitto);
    }

    @Override
    public int calcolaAffitto(IPagamenti strategia) {
        return 0;
    }

}
