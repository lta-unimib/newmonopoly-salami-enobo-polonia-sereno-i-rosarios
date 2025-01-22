package com.newmonopoly.newmonopoly.eventi.gamer;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

import com.newmonopoly.newmonopoly.state.game.GameState;
import com.newmonopoly.newmonopoly.state.square.SquareState;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class EventoGiocatore {

    protected Giocatore giocatore;

    protected EventoGiocatore(){}

    public abstract void accept(SquareState squareState);
    public abstract void accettaStato(GameState gameState);
}
