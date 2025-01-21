package com.newmonopoly.newmonopoly.model.tabellone.carte;

import com.newmonopoly.newmonopoly.model.gamer.Token;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)

public class CartaDenaro extends Carta {

    private int denaro;
    protected CartaDenaro(){}

    @Override
    public boolean effettoCarta(Token token){
        token.getGiocatore().ricevi(denaro);
        return true;
    }

    @Override
    public void economiaCasuale(float m){
        denaro = (int) Math.floor(denaro * m);
    }

}
