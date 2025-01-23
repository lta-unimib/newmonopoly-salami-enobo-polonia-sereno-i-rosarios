package com.newmonopoly.newmonopoly.eventi.gamer;

import com.newmonopoly.newmonopoly.state.game.GameState;
import com.newmonopoly.newmonopoly.state.square.SquareState;

public class EventoOfferta extends EventoGiocatore {
    int valoreOfferta;
    // metodo per controllare la validità dell'offerta

    @Override
    public void accept(SquareState squareState) {
        squareState.handleEvent(this);
    }

    @Override
    public void accept(GameState gameState) {
        gameState.handleEvent(this);
    }
}
