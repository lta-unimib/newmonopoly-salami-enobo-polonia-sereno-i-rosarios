package com.newmonopoly.newmonopoly.eventi.gamer;

import com.newmonopoly.newmonopoly.model.tabellone.Asta;
import com.newmonopoly.newmonopoly.state.game.GameState;
import com.newmonopoly.newmonopoly.state.square.SquareState;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventoTerminaAsta extends EventoGiocatore{
    protected Asta asta;

    @Override
    public void accept(SquareState squareState) {
        squareState.handleEvent(this);
    }

    @Override
    public void accept(GameState gameState) {
        gameState.handleEvent(this);
    }
}
