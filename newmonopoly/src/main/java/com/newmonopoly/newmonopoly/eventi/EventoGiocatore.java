package com.newmonopoly.newmonopoly.eventi;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class EventoGiocatore {

    protected Giocatore giocatore;

    protected EventoGiocatore(){}
}
