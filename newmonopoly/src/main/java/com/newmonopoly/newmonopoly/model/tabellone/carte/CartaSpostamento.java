package com.newmonopoly.newmonopoly.model.tabellone.carte;

import com.newmonopoly.newmonopoly.model.gamer.Token;

public class CartaSpostamento extends Carta{

    int spostamento;
    protected CartaSpostamento(){}

    @Override
    public boolean effettoCarta(Token token) {
        t.muoviGiocatore(token, spostamento);
        return true;
    }
}
