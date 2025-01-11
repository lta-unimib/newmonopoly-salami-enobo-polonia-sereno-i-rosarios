package com.newmonopoly.newmonopoly.model.gamer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token {

    private Giocatore giocatore;
    private int tokenId;

    public Token (Giocatore giocatore, int tokenId){
        this.giocatore=giocatore;
        this.tokenId=tokenId;
    }



}
