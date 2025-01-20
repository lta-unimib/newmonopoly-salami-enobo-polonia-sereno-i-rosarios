package com.newmonopoly.newmonopoly.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.interfacce.IMazzo;
import com.newmonopoly.newmonopoly.interfacce.ITabellone;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.gamer.Token;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;

@SuperBuilder
public abstract class AbstractGame implements Serializable {

    @Builder.Default
    // protected ArrayList<Giocatore> players = new ArrayList<>();
    protected ITabellone tabellone;
    protected Config config;
    protected ArrayList<Token> players = new ArrayList<>(6);

    @JsonIgnore
    protected IMazzo mazzo;
    protected Turno attualeTurno;

    public abstract void addPlayer(Token token); // implementare eccezioni

    public abstract void removePlayer(Token token);

    public abstract Giocatore getNomeGiocatore(Token token);



}
