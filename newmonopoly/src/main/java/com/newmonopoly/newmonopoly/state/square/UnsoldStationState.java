package com.newmonopoly.newmonopoly.state.square;

import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.eventi.casella.RequestPurchase;
import com.newmonopoly.newmonopoly.eventi.gamer.AcquistaProprieta;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UnsoldStationState extends StationState{

    protected UnsoldStationState(){

    }

    @Override
    public void handleEvent(AcquistaProprieta acquistaProprieta){
        acquistaProprieta.getGiocatore().aggiungiProprieta(stazione);
        stazione.setStato(PurchasedStation.builder().build());
    }

    @Override
    public EventoCasella arrivo(){
        return RequestPurchase.builder().proprieta(stazione).build();
    }

}
