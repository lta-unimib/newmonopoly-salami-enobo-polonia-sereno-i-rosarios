package com.newmonopoly.newmonopoly.state.square;

import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.eventi.casella.PagaAffitto;
import com.newmonopoly.newmonopoly.eventi.gamer.EventoIpoteca;
import jdk.jfr.Event;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PurchasedSociety extends SocietyState{

    protected PurchasedSociety(){}

    @Override
    public void handleEvent(EventoIpoteca ipoteca){
        ipoteca.getGiocatore().ricevi(societa.getIpoteca());
        societa.setStato(PurchasedSociety.builder().societa(societa).build());
    }

    @Override
    public EventoCasella arrivo(){
        return PagaAffitto.builder().proprieta(societa).build();
    }

}
