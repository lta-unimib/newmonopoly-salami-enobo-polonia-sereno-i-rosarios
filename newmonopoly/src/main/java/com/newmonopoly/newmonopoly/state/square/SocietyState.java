package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.eventi.gamer.EventoTerminaAsta;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Societa;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class SocietyState implements SquareState {

    @JsonIgnore
    protected Societa societa;

    protected SocietyState(){}

    @Override
    public void handleEvent(EventoTerminaAsta terminaAsta){
        societa.setStato(PurchasedSociety.builder().build());
        terminaAsta.getGiocatore().acquistaProprieta(societa, societa.getProprietario(), terminaAsta.getAsta().getOffertaAttuale());
    }
}
