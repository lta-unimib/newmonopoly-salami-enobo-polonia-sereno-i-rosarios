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
public class UnsoldStreetState extends StreetState {
    protected UnsoldStreetState() {}

    @Override
    public EventoCasella arrivo() {
        return RequestPurchase.builder().proprieta(strada).build();
    }

    @Override
    public void handleEvent(AcquistaProprieta acquistaProprieta){
        acquistaProprieta.getGiocatore().aggiungiProprieta(strada);
        strada.setStato(PurchasedStreetState.builder().strada(strada).build());
    }

}
