package com.newmonopoly.newmonopoly.eventi.casella;

import com.newmonopoly.newmonopoly.state.game.GameState;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ricevi implements EventoCasella {

    protected int importo;

    public Ricevi() {}

    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
