package com.newmonopoly.newmonopoly.model.tabellone.casella;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.newmonopoly.newmonopoly.state.square.ProbabilitaState;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Probabilita extends Casella {
    protected Probabilita() {
        stato = ProbabilitaState.builder().probabilita(this).build();
    }
}
