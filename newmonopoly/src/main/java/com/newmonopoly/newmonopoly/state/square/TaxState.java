package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.eventi.casella.Ricevi;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Tassa;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
public abstract class TaxState implements SquareState {

    @JsonIgnore
    private Tassa tax;

    protected TaxState(){

    }

    @Override
    public EventoCasella arrivo() {
        return Ricevi.builder().importo(tax.getImporto()).build();
    }

}
