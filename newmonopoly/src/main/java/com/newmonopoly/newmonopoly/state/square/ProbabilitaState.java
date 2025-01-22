package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.eventi.casella.PescaImprevisto;
import com.newmonopoly.newmonopoly.eventi.casella.PescaProbabilita;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Probabilita;

public class ProbabilitaState implements SquareState{

    @JsonIgnore
    private Probabilita probabilita;

    protected ProbabilitaState(){}

    @Override
    public EventoCasella arrivo(){
        return PescaProbabilita.builder().build();
    }

}
