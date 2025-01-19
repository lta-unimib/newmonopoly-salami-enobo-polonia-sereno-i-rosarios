package com.newmonopoly.newmonopoly.model.tabellone.carte;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Casella;

// porta il giocatore in una specifica casella

public class CartaPosizione extends Carta{

    private Casella casella;

    protected CartaPosizione(){}

    @Override
    public boolean effettoCarta(Giocatore giocatore) {
        // porta giocatore ad una specifica casella
        return true;
    }

}
