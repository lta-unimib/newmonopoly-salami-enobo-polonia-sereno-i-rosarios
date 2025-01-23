package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.eventi.casella.ArrestaGiocatore;
import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.model.tabellone.casella.VaiInPrigione;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class GoToJailState implements SquareState{
    @JsonIgnore
    VaiInPrigione vaiInPrigione;

    protected GoToJailState(){

    }

    @Override
    public EventoCasella arrivo() {
        return ArrestaGiocatore.builder().build();
    }
}
