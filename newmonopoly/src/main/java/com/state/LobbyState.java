package com.state;

import com.newmonopoly.azioni.Join;

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
