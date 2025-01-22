package com.newmonopoly.newmonopoly.state.square;

import com.newmonopoly.newmonopoly.eventi.gamer.EventoIpoteca;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MortgagedStation extends StationState{

    protected MortgagedStation(){}

    @Override
    public void handleEvent(EventoIpoteca fineIpoteca){
        try{
            stazione.getProprietario().pay(stazione.getIpoteca());
            stazione.setStato(PurchasedStation.builder().stazione(stazione).build());
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
