package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.eventi.casella.Ricevi;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Via;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public class ViaState implements SquareState{

    @JsonIgnore
    private Via via;

    protected ViaState(){}

    @Override
    public EventoCasella passaggio(){
        return Ricevi.builder().importo(via.getVal()).build();
    }

    @Override
    public EventoCasella arrivo(){
        return passaggio();
    }

}
