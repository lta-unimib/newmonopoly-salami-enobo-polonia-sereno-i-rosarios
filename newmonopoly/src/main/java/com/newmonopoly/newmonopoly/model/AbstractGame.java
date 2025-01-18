package com.newmonopoly.newmonopoly.model;

import com.newmonopoly.newmonopoly.interfacce.ITabellone;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@SuperBuilder
public abstract class AbstractGame {

    @Builder.Default
    protected ArrayList<Giocatore> players = new ArrayList<>();
    protected ITabellone tabellone;
    protected Config config;

    public abstract void addPlayer(Giocatore giocatore);
}
