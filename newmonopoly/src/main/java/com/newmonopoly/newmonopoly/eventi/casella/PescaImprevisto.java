package com.newmonopoly.newmonopoly.eventi.casella;

import com.newmonopoly.newmonopoly.state.game.GameState;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data@SuperBuilder
public class PescaImprevisto implements EventoCasella {
    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
