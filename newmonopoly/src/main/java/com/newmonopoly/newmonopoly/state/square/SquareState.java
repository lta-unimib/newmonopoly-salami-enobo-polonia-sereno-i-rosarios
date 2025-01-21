package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.newmonopoly.newmonopoly.eventi.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public interface SquareState extends Serializable {

    @JsonProperty("type")
    default String getTipo(){
        return getClass().getSimpleName();
    }

    default void handleEvent(AcquistaProprieta acquistaProprieta) {
    }

}
