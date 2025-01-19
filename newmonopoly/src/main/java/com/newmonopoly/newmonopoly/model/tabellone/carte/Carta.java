package com.newmonopoly.newmonopoly.model.tabellone.carte;

import com.newmonopoly.newmonopoly.interfacce.ITabellone;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

import java.io.Serializable;

// implementazione con file .json

public abstract class Carta implements Serializable {

    protected String testo;
    protected ITabellone t;

    protected Carta(){}

    public abstract boolean effettoCarta (Giocatore giocatore);

}
