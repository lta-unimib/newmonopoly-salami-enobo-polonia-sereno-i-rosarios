package com.newmonopoly.newmonopoly.eventi.gamer;

import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import com.newmonopoly.newmonopoly.state.game.GameState;
import com.newmonopoly.newmonopoly.state.square.SquareState;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public class EventoAvviaAsta extends EventoGiocatore{
    protected Proprieta proprieta;

    @Override
    public void accept(SquareState squareState) {
        squareState.handleEvent(this);
    }

    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
