package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.model.gamer.Token;


import com.newmonopoly.newmonopoly.state.square.GoToJailState;
import com.newmonopoly.newmonopoly.state.square.JailState;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class VaiInPrigione extends Casella {

    public VaiInPrigione(){
        stato = GoToJailState.builder().vaiInPrigione(this).build();
    }
}
