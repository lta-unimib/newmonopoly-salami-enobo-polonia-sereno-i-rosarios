package com.newmonopoly.newmonopoly.model.tabellone.carte;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

public class CartaSpostamento extends Carta{

    int spostamento;
    protected CartaSpostamento(){}


    @Override
    public boolean effettoCarta(Giocatore giocatore) {
        // t.muoviGiocatoreIntero(giocatore, spostamento);
        return true;
    }
}
