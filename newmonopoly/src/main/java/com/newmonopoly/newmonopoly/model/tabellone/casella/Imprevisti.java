package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.newmonopoly.newmonopoly.state.square.ImprevistoState;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Imprevisti extends Casella{

    protected Imprevisti() {
        state = ImprevistoState.builder().imprevisto(this).build();
    }


}
