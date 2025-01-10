package com.newmonopoly.newmonopoly.model.tabellone;

import com.newmonopoly.newmonopoly.model.gamer.Token;

import static com.newmonopoly.newmonopoly.model.tabellone.Prigione.getPrigione;

public class VaiInPrigione extends Casella{

    public VaiInPrigione(String nome){
        super(nome);
    }

    public void arresto(Token pedina){
        getPrigione("Prigione").nuovoPrigioniero(pedina);
    }
}
