package com.newmonopoly.newmonopoly.eventi.casella;

import com.newmonopoly.newmonopoly.state.game.GameState;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Builder
public class PescaProbabilita implements EventoCasella {
    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
