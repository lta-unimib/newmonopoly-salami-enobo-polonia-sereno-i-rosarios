package com.newmonopoly.newmonopoly.state.square;

import com.newmonopoly.newmonopoly.eventi.gamer.EventoIpoteca;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class MortgagedStreet extends StreetState {

    protected MortgagedStreet() {}

    @Override
    public void handleEvent(EventoIpoteca rimuoviIpoteca) {
        try {
            strada.getProprietario().ricevi(strada.getIpoteca());
            strada.setStato(PurchasedStreetState.builder().strada(strada).build());
        }catch (IllegalArgumentException ignored){
        }
    }
}
