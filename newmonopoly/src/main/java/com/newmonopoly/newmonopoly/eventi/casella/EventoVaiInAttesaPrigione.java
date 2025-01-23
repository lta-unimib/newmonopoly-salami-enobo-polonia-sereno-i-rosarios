package com.newmonopoly.newmonopoly.eventi.casella;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.state.game.GameState;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventoVaiInAttesaPrigione implements EventoCasella {

    private Giocatore giocatore;

    @Override
    public void accettaStato(GameState gameState) {
        gameState.handleEvent(this);
    }
}
