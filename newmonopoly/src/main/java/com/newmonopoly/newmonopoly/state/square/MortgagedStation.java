package com.newmonopoly.newmonopoly.state.square;

import com.newmonopoly.newmonopoly.eventi.gamer.EventoIpoteca;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class MortgagedStation extends StationState{

    protected MortgagedStation(){}

    @Override
    public void handleEvent(EventoIpoteca fineIpoteca){
        try{
            stazione.getProprietario().pay(stazione.getIpoteca());
            stazione.setState(PurchasedStation.builder().stazione(stazione).build());
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
