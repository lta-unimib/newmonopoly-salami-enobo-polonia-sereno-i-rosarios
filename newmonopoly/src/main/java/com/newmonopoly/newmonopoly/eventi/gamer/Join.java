package com.newmonopoly.newmonopoly.eventi.gamer;

import com.newmonopoly.newmonopoly.state.game.GameState;
import com.newmonopoly.newmonopoly.state.square.SquareState;

public class Join extends EventoGiocatore {

    public void accept(SquareState squareState) {
        squareState.handleEvent(this);
    }

    public void accept(GameState gameState) {
        gameState.handleEvent(this);
    }
}

