package com.stati;

import com.newmonopoly.azioni.Join;

public class Lobby extends StatoPartita{

    @Override
    public void esegui(Join join) {
        try{
            abstractGame.addPlayer(join.getGiocatore());
        } catch (Exception e) {
            e.printStackTrace(); //da creare eccezione
        }
    }

    
}
