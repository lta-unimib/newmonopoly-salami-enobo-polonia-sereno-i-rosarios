package com.newmonopoly.newmonopoly.model.tabellone;

import com.newmonopoly.newmonopoly.model.gamer.Token;

public class TassaLusso extends Tasse{

    public TassaLusso(){
        super("Tassa di Lusso", 200);
    }

    @Override
    public void applicaTassa(Token token) {
        token.getGiocatore().pagaTassa(importo);
    }
}
