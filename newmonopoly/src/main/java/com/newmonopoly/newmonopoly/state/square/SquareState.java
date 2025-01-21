package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.newmonopoly.newmonopoly.eventi.*;


import java.io.Serializable;


public interface SquareState extends Serializable {
    @JsonProperty("type")
    default String getTipo(){
        return getClass().getSimpleName();
    }

    default void handleEvent(AcquistaProprieta acquistaProprieta) {}

    default void handleEvent(Join join) {}

}
