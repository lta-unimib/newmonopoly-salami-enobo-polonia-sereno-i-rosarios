package com.newmonopoly.newmonopoly.eventi.casella;

import com.newmonopoly.newmonopoly.state.game.GameState;

public class EventoAttesaLancioDadi implements EventoCasella {

    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
