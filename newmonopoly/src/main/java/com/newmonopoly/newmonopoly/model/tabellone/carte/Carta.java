package com.newmonopoly.newmonopoly.model.tabellone.carte;

import com.newmonopoly.newmonopoly.interfacce.ITabellone;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.gamer.Token;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

// implementazione con file .json

@Data
@SuperBuilder
public abstract class Carta implements Serializable {

    protected String testo;
    protected ITabellone t;

    protected Carta(){}

    public abstract boolean effettoCarta (Token token);

    public void randomizzaCarta(float m){ }

}
