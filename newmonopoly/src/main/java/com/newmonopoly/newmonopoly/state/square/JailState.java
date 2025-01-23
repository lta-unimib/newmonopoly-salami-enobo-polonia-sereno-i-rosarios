package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.newmonopoly.newmonopoly.eventi.gamer.EventoLanciaDadi;
import com.newmonopoly.newmonopoly.eventi.gamer.EventoPaga;
import com.newmonopoly.newmonopoly.eventi.gamer.EventoVaiInPrigione;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Prigione;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class JailState implements SquareState {
    @JsonIgnore
    private Prigione prigione;

    protected JailState(){

    }

    @Override
    public void handleEvent(EventoLanciaDadi lanciaDadi){
        prigione.getGiocatoriInPrigione().remove(lanciaDadi.getGiocatore());
    }


    @Override
    public void handleEvent(EventoVaiInPrigione vaiInPrigione){
        prigione.imprigionaGiocatore(vaiInPrigione.getGiocatore().getToken());
    }

    @Override
    public void handleEvent(EventoPaga paga) {
        try {
            paga.getGiocatore().pay(prigione.getCauzione());
            prigione.liberaGiocatore(paga.getGiocatore().getToken());
        } catch (Exception e){
            //Non è da gestire
        }
    }
}