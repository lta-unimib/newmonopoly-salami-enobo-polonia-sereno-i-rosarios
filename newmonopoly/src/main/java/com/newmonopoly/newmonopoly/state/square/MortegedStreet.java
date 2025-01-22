package com.newmonopoly.newmonopoly.state.square;

import com.newmonopoly.newmonopoly.eventi.gamer.EventoIpoteca;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class MortegedStreet extends StreetState {

    protected MortegedStreet() {}

    @Override
    public void handleEvent(EventoIpoteca rimuoviIpoteca) {
        try {
            strada.getProprietario().ricevi(strada.getIpoteca());
            strada.setStato(SoldStreetState.builder().strada(strada).build());
        }catch (IllegalArgumentException ignored){
        }
    }
}
