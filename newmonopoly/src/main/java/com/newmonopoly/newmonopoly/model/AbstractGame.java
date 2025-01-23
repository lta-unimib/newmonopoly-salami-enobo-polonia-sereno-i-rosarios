package com.newmonopoly.newmonopoly.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.interfacce.IMazzo;
import com.newmonopoly.newmonopoly.interfacce.ITabellone;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.state.game.GameState;
import com.newmonopoly.newmonopoly.eventi.gamer.EventoGiocatore;
import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@SuperBuilder
public abstract class AbstractGame implements Serializable{

    @Builder.Default
    protected ArrayList<Giocatore> players = new ArrayList<>();
    protected ITabellone tabellone;
    protected Config config;

    @JsonIgnore
    protected IMazzo mazzo;
    protected GameState state;
    protected Turno turno;

    public abstract void setState(GameState newState);
    public abstract void aggiorna();
    public abstract void handleEvent(EventoGiocatore evento);
    public abstract void addPlayer(Giocatore giocatore);
    public abstract void removePlayer(Giocatore giocatore);
    public abstract Giocatore getGiocatoreByName(String name);
    public abstract void casellaHandleEvent(EventoCasella evento);
}