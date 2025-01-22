package com.newmonopoly.newmonopoly.eventi.gamer;

import com.newmonopoly.newmonopoly.state.game.GameState;
import com.newmonopoly.newmonopoly.state.square.SquareState;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class EntraInPartita extends EventoGiocatore {


    @Override
    public void accept(SquareState squareState) {
        squareState.handleEvent(this);
    }

    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
