package com.newmonopoly.newmonopoly.model.tabellone;

import com.newmonopoly.newmonopoly.model.gamer.Token;

public class TassaOrdinaria extends Tasse{

    public TassaOrdinaria(){
        super("Tassa di Ordinaria", 100);
    }

    @Override
    public void applicaTassa(Token token) {
        token.getGiocatore().pagaTassa(importo);
    }

}
