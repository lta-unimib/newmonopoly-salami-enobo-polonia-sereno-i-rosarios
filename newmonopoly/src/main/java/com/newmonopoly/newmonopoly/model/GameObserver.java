package com.newmonopoly.newmonopoly.model;

import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;

import java.io.Serializable;

public interface GameObserver extends Serializable {

    void handleEvent(EventoCasella eventoCasella);

}
