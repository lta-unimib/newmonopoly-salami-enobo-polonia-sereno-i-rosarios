package com.newmonopoly.newmonopoly.model.tabellone;

import com.newmonopoly.newmonopoly.model.gamer.Token;
import java.util.ArrayList;

public class Prigione extends Casella{
    private static Prigione prigione = null;

    private ArrayList<Token> prigionieri;

    private Prigione (String nome) {
        super(nome);
        this.prigionieri = new ArrayList<Token>(6);
    }

    public static synchronized Prigione getPrigione(String nome) {
        if (prigione == null) {
            prigione = new Prigione(nome);
        }
        return prigione;
    }

    public void nuovoPrigioniero(Token pedina){
        if(!this.prigionieri.contains(pedina)){
            this.prigionieri.add(pedina);
        }
    }

    public void freedom(Token pedina){
        this.prigionieri.remove(pedina);
    }
}
