package com.newmonopoly.newmonopoly.state.square;

import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.eventi.casella.PagaAffitto;
import com.newmonopoly.newmonopoly.eventi.gamer.EventoIpoteca;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class PurchasedStation extends StationState{

    protected PurchasedStation(){}

    @Override
    public void handleEvent(EventoIpoteca eventoIpoteca){
        s.getProprietario().ricevi(s.getIpoteca());
        s.setStato(MortgagedStation.builder().build());
    }

    @Override
    public EventoCasella arrivo(){
        return PagaAffitto.builder().proprieta(s).build();
    }

}
