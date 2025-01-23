package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Parcheggio;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ParkingState implements SquareState{

    @JsonIgnore
    private Parcheggio parcheggio;

    protected ParkingState() {}
}
