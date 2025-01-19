package com.newmonopoly.newmonopoly.model.gamer;

import com.newmonopoly.newmonopoly.model.tabellone.casella.Casella;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class Token implements Serializable {

    @Serial
    private static final long serialVersionUID = 2404872041950251807L;

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
