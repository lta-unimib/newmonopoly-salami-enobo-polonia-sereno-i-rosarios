package com.newmonopoly.newmonopoly.eventi.gamer;

import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import com.newmonopoly.newmonopoly.state.game.GameState;
import com.newmonopoly.newmonopoly.state.square.SquareState;

public class EventoIpoteca extends EventoGiocatore {
    protected Proprieta proprieta;

    protected EventoIpoteca() {}

    @Override
    public void accept(SquareState squareState) {
        squareState.handleEvent(this);
    }

    @Override
    public void accettaStato(GameState gameState) {
        gameState.hadleEvent( this);
    }
}
