package com.newmonopoly.newmonopoly.state.game;

import com.newmonopoly.newmonopoly.eventi.gamer.EntraInPartita;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class LobbyState extends GameState{

    @Override
    public void handleEvent(EntraInPartita entraInPartita) {
        try{
            game.addPlayer(entraInPartita.getGiocatore());
        } catch (Exception e) {
            e.printStackTrace(); //da creare eccezione
        }
    }

    
}
