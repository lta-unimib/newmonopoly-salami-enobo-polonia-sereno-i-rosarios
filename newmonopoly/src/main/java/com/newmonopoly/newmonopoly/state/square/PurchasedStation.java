package com.newmonopoly.newmonopoly.state.square;

import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.eventi.casella.PagaAffitto;
import com.newmonopoly.newmonopoly.eventi.gamer.EventoIpoteca;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class PurchasedStation extends StationState{

    protected PurchasedStation(){}

    @Override
    public void handleEvent(EventoIpoteca eventoIpoteca){
        stazione.getProprietario().ricevi(stazione.getIpoteca());
        stazione.setState(PurchasedStation.builder().stazione(stazione).build());
    }

    @Override
    public EventoCasella arrivo(){
        return PagaAffitto.builder().proprieta(stazione).build();
    }

}
