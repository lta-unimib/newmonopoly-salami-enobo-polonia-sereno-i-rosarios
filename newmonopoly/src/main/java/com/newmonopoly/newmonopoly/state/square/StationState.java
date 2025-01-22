package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Stazione;

public abstract class StationState implements SquareState {

    @JsonIgnore
    protected Stazione s;

    protected StationState() {

    }
    
}
