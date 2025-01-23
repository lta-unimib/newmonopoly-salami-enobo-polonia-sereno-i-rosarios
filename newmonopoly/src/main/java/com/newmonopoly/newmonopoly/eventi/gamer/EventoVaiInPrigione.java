package com.newmonopoly.newmonopoly.eventi.gamer;

import com.newmonopoly.newmonopoly.state.game.GameState;
import com.newmonopoly.newmonopoly.state.square.SquareState;

public class EventoVaiInPrigione extends EventoGiocatore {

    @Override
    public void accept(SquareState squareState) {
        squareState.handleEvent(this);
    }

    @Override
    public void accept(GameState gameState) {
        gameState.handleEvent(this);
    }
}
