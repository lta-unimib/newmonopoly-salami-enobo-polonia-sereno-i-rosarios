package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.eventi.casella.PescaImprevisto;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Imprevisto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data@SuperBuilder
public class ImprevistoState implements SquareState{

    @JsonIgnore
    private Imprevisto imprevisto;

    protected ImprevistoState(){}

    @Override
    public EventoCasella arrivo(){
        return PescaImprevisto.builder().build();
    }

}
