package com.newmonopoly.newmonopoly.state.square;

import com.newmonopoly.newmonopoly.eventi.gamer.AcquistaProprieta;

public class UnsoldStreetState extends StreetState {
    protected UnsoldStreetState() {}

    //DA CONTINUARE
    public void handlePlayerEvent(AcquistaProprieta acquistaProprieta){
        acquistaProprieta.getGiocatore().aggiungiProprieta(strada);
    }

}
