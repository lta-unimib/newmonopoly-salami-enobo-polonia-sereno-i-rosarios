package com.newmonopoly.newmonopoly.eventi.casella;

import com.newmonopoly.newmonopoly.state.game.GameState;
import lombok.experimental.SuperBuilder;
import lombok.Data;

@Data
@SuperBuilder
public class Ricevi implements EventoCasella {

    protected int importo;

    public Ricevi() {}

    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
