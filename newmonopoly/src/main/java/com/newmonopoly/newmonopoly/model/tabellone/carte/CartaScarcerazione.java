package com.newmonopoly.newmonopoly.model.tabellone.carte;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.gamer.Token;

public class CartaScarcerazione extends Carta{

    protected CartaScarcerazione(){}

    @Override
    public boolean effettoCarta(Token token) {
        // giocatore esce di prigione
        return false;
    }

}
