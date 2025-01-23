package com.newmonopoly.newmonopoly.interfacce;

import com.newmonopoly.newmonopoly.model.gamer.Token;
import com.newmonopoly.newmonopoly.model.tabellone.carte.Carta;

import java.io.Serializable;

public interface IMazzo extends Serializable {

    void pescaImprevisto(Token token);

    void pescaProbabilita(Token token);

    void usaCarta(Token token);

    void economiaCasuale();

    Carta nextProbabilita();

    Carta nextImprevisto();

}
