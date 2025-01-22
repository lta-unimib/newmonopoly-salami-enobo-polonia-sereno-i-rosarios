package com.newmonopoly.newmonopoly.eventi.casella;

import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.state.game.GameState;
import lombok.Builder;

@Builder
public class PassaggioVuoto implements EventoCasella {

    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
