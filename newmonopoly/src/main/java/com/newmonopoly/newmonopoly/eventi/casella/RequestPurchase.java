package com.newmonopoly.newmonopoly.eventi.casella;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import com.newmonopoly.newmonopoly.state.game.GameState;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestPurchase implements EventoCasella{

    @JsonIgnore
    private Proprieta proprieta;

    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
