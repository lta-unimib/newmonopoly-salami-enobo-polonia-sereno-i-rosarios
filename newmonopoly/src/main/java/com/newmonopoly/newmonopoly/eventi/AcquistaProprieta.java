package com.newmonopoly.newmonopoly.eventi;

import com.newmonopoly.newmonopoly.state.game.GameState;
import com.newmonopoly.newmonopoly.state.square.SquareState;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class AcquistaProprieta extends EventoGiocatore {

    @Override
    public void accept(SquareState squareState) {
        squareState.handleEvent(this);
    }

    @Override
    public void accept(GameState gameState) {
        gameState.handleEvent(this);
    }
}
