package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.eventi.casella.PescaImprevisto;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Imprevisti;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data@Builder
public class ImprevistoState implements SquareState{

    @JsonIgnore
    private Imprevisti imprevisto;

    protected ImprevistoState(){}

    @Override
    public EventoCasella arrivo(){
        return PescaImprevisto.builder().build();
    }

}
