package com.newmonopoly.newmonopoly.eventi.casella;

import com.newmonopoly.newmonopoly.state.game.GameState;

public class Ricevi implements EventoCasella {

    public Ricevi() {}

    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
