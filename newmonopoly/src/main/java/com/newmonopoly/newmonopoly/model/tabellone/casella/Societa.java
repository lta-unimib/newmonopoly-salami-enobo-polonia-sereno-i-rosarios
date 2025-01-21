package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.model.tabellone.Dadi;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

public class Societa extends Proprieta {
    
    public Societa(String nome, Giocatore proprietario, int costo, int ipoteca, int affitto) {
        super(nome, proprietario, costo, ipoteca, affitto);
    }

    public int calcolaAffittoSocieta() {
        // Lancia due dadi
        int risultatoDadi = Dadi.lancia() + Dadi.lancia();
        // Determina il numero di società possedute dal proprietario
        int societaPossedute = this.getProprietario().getSocieta().size();
        // Imposta il moltiplicatore in base al numero di società possedute
        int moltiplicatore = (societaPossedute == 1) ? 4 : 10;
        // Calcola l'affitto totale
        return risultatoDadi * moltiplicatore;
    }


}
