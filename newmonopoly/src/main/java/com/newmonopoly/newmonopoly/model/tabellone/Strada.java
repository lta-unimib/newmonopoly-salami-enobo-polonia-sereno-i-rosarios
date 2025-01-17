package com.newmonopoly.newmonopoly.model.tabellone;

import java.util.ArrayList;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

public class Strada extends Proprieta {
    
    private int numCase;
    private boolean albergo;
    private ArrayList<Integer> affitti;
    private int costoCasa;
    private int costoAlbergo;

    public Strada (String nome, Giocatore proprietario, int costo, int ipoteca, int affitto, ArrayList<Integer> affitti, int costoCasa, int costoAlbergo) {
        super(nome, proprietario, costo, ipoteca, affitto);
        setNumCase(0);
        setAlbergo(false);
        setAffitti(affitti);
        setCostoCasa(costoCasa);
        setCostoAlbergo(costoAlbergo);
    }

    public void setNumCase(int numCase) {
        this.numCase = numCase;
    }

    public void setAlbergo(boolean albergo) {
        this.albergo = albergo;
    }

    public void setAffitti(ArrayList<Integer> affitti) {
        this.affitti = affitti;
    }

    public void setCostoCasa(int costoCasa) {
        this.costoCasa = costoCasa;
    }

    public void setCostoAlbergo(int costoAlbergo) {
        this.costoAlbergo = costoAlbergo;
    }
    
    public int getNumCase() {
        return numCase;
    }

    public boolean getAlbergo() {
        return albergo;
    }

    public ArrayList<Integer> getAffitti() {
        return affitti;
    }


    public int getCostoCasa() {
        return costoCasa;
    }

    public int getCostoAlbergo() {
        return costoAlbergo;
    }
}
