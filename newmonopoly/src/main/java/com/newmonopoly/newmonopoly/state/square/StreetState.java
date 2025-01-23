package com.newmonopoly.newmonopoly.state.square;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class StreetState implements SquareState {

    @JsonIgnore
    protected Strada strada;
    protected StreetState() {}
}
