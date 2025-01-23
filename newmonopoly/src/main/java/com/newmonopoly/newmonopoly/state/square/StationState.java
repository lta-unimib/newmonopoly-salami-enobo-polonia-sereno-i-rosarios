package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.eventi.gamer.EventoTerminaAsta;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Stazione;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class StationState implements SquareState {

    @JsonIgnore
    protected Stazione stazione;

    protected StationState() {}

    @Override
    public void handleEvent(EventoTerminaAsta eventoTerminaAsta){
        stazione.setState(PurchasedStation.builder().build());
        eventoTerminaAsta.getGiocatore().acquistaProprieta(stazione, stazione.getProprietario(), eventoTerminaAsta.getAsta().getOffertaAttuale());
    }
    
}
