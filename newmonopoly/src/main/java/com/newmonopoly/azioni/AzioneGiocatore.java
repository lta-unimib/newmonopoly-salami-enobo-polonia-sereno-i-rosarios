package com.newmonopoly.azioni;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class AzioneGiocatore {
    protected Giocatore giocatore;

    protected AzioneGiocatore() {}
}
