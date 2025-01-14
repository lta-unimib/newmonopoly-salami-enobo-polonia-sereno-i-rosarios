package com.newmonopoly.newmonopoly.model.gamer;

import com.newmonopoly.newmonopoly.model.tabellone.Casella;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token {

    private Giocatore giocatore;
    private int tokenId;
    private Casella casella;

    public Token (Giocatore giocatore, int tokenId){
        this.giocatore=giocatore;
        this.tokenId=tokenId;
    }

    public void setCasella(Casella casella) {
        this.casella = casella;
    }

    public Casella getCasella() {
        return casella;
    }
}
