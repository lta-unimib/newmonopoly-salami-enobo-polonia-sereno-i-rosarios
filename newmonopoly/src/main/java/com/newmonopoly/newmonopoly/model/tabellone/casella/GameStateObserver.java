package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.model.GameObserver;

public interface GameStateObserver {

    void notifyGameState(EventoCasella eventoCasella);

    void add(GameObserver gameObserver);

    void remove(GameObserver gameObserver);

}
