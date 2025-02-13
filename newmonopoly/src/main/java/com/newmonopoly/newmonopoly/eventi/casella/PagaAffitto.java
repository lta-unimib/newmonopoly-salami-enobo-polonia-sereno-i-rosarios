package com.newmonopoly.newmonopoly.eventi.casella;

import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import com.newmonopoly.newmonopoly.state.game.GameState;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PagaAffitto implements EventoCasella {

    private PagaAffitto() {}

    protected Proprieta proprieta;

    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
