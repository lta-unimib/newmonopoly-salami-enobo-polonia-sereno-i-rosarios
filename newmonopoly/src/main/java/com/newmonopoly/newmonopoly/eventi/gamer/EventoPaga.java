package com.newmonopoly.newmonopoly.eventi.gamer;

import com.newmonopoly.newmonopoly.state.game.GameState;
import com.newmonopoly.newmonopoly.state.square.SquareState;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@SuperBuilder
public class EventoPaga extends EventoGiocatore {

    @Override
    public void accept(SquareState squareState) {
        squareState.handleEvent(this);
    }

    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
