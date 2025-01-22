package com.newmonopoly.newmonopoly.state.game;

import com.newmonopoly.newmonopoly.eventi.gamer.Join;

public class LobbyState extends GameState{

    @Override
    public void handleEvent(Join join) {
        try{
            abstractGame.addPlayer(join.getGiocatore());
        } catch (Exception e) {
            e.printStackTrace(); //da creare eccezione
        }
    }

    
}
