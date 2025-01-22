package com.newmonopoly.newmonopoly.model;

import com.newmonopoly.newmonopoly.interfacce.IMazzo;
import com.newmonopoly.newmonopoly.interfacce.ITabellone;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.state.game.GameState;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@Data
@SuperBuilder
public abstract class AbstractGame {

    @Builder.Default
    protected ArrayList<Giocatore> players = new ArrayList<>();
    protected ITabellone tabellone;
    protected IMazzo mazzo;
    protected Config config;
    protected GameState stato;

    public abstract void addPlayer(Giocatore giocatore);
    public abstract void setStato(GameState nuovaStato);
    public abstract Giocatore getGiocatoreByName(String name);

}
