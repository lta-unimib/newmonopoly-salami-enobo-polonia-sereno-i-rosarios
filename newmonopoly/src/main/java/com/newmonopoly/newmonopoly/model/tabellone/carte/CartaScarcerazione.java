package com.newmonopoly.newmonopoly.model.tabellone.carte;

import com.newmonopoly.newmonopoly.model.gamer.Token;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CartaScarcerazione extends Carta{

    protected CartaScarcerazione(){}

    @Override
    public boolean effettoCarta(Token token) {
        // giocatore esce di prigione
        return false;
    }

}
