package com.newmonopoly.newmonopoly.state.square;

import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.eventi.casella.RequestPurchase;
import com.newmonopoly.newmonopoly.eventi.gamer.AcquistaProprieta;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class UnsoldSocietyState extends SocietyState{

    protected UnsoldSocietyState(){}

    @Override
    public void handleEvent(AcquistaProprieta acquistaProprieta){
        acquistaProprieta.getGiocatore().aggiungiProprieta(societa);
        societa.setState(PurchasedSociety.builder().societa(societa).build());
    }

    @Override
    public EventoCasella arrivo(){
        return RequestPurchase.builder().proprieta(societa).build();
    }

}
