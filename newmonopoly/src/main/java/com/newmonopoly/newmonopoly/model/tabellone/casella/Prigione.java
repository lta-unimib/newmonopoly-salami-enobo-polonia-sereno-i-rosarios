package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.gamer.Token;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import com.newmonopoly.newmonopoly.state.square.JailState;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Prigione extends Casella implements Serializable {
    private int cauzione;
    private int turniInPrigione;
    @JsonIgnore
    private HashMap<Token, Integer> giocatoriInPrigione = new HashMap<>();

    protected Prigione() {
        state = JailState.builder().prigione(this).build();
        turniInPrigione = 1;
    }

    public Integer liberaGiocatore(Token token) {
        return giocatoriInPrigione.remove(token.getGiocatore());
    }

    public Integer imprigionaGiocatore(Token token) {
        return giocatoriInPrigione.put(token, turniInPrigione);
    }
/*
    @Override
    public void inizioTurno(Giocatore g) {
        if (giocatoriInPrigione.get(g) == null) {
            notificaTutti(AttesaLancioDadi.builder().build());
        } else if (giocatoriInPrigione.get(g) == 0) {
            this.liberaGiocatore(g);
            notificaTutti(AttesaLancioDadi.builder().build());
        } else {
            giocatoriInPrigione.put(g, giocatoriInPrigione.get(g) - 1);
            notificaTutti(VaiInAttesaPrigione.builder().giocatore(g).build());
        }
    }*/
}
