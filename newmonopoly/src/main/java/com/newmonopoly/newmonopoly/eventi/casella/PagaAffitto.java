package com.newmonopoly.newmonopoly.eventi.casella;

import com.newmonopoly.newmonopoly.state.game.GameState;

public class PagaAffitto implements EventoCasella {
    public PagaAffitto() {}

    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
