package com.newmonopoly.newmonopoly.eventi.gamer;

import com.newmonopoly.newmonopoly.model.tabellone.Asta;
import com.newmonopoly.newmonopoly.state.game.GameState;
import com.newmonopoly.newmonopoly.state.square.SquareState;

public class EventoTerminaAsta extends EventoGiocatore{
    protected Asta asta;

    @Override
    public void accept(SquareState squareState) {
        squareState.handleEvent(this);
    }

    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
