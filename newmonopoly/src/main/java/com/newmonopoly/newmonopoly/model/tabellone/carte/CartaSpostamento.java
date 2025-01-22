package com.newmonopoly.newmonopoly.model.tabellone.carte;

import com.newmonopoly.newmonopoly.model.gamer.Token;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CartaSpostamento extends Carta{

    int spostamento;
    protected CartaSpostamento(){}

    @Override
    public boolean effettoCarta(Token token) {
        tabellone.muoviGiocatore(token, spostamento);
        return true;
    }
}
