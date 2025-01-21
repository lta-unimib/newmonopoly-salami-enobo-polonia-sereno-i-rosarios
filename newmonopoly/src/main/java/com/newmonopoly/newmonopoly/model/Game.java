package com.newmonopoly.newmonopoly.model;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.state.game.GameState;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Game extends AbstractGame{


    protected Game(AbstractGameBuilder<?, ?> builder){
        super(builder);
    }

    @Override
    public synchronized void addPlayer(Giocatore giocatore) {
        if(players.size() == config.getNumeroGiocatori()) {
            //partitapiena
        }
        if(players.contains(giocatore)){
            //giocatoregiàentrato
        }
        giocatore.setBanconote(config.inizializzaBanconote());
        players.add(giocatore);
    }

    @Override
    public void setStato(GameState nuovaStato) {

    }

}
