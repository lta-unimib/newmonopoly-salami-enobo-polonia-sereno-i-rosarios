package com.newmonopoly.newmonopoly.model.tabellone.carte;

import com.newmonopoly.newmonopoly.model.gamer.Token;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Casella;

import lombok.Data;
import lombok.experimental.SuperBuilder;

// porta il giocatore in una specifica casella

@Data
@SuperBuilder
public class CartaPosizione extends Carta{

    private Casella casella;

    protected CartaPosizione(){}

    @Override
    public boolean effettoCarta(Token token) {
        token.setCasella(casella);
        return true;
    }

}
