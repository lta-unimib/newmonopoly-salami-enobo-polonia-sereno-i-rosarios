package com.newmonopoly.newmonopoly.model;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.state.game.GameState;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Iterator;

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
        giocatore.setBanconote(config.getBanconote());
        players.add(giocatore);
    }

    @Override
    public void setStato(GameState nuovaStato) {
    }

    public synchronized Giocatore getGiocatoreByName(String name) {
        Iterator<Giocatore> iter = players.iterator();
        Giocatore g = null;
        while (iter.hasNext() && (g == null || !g.getNome().equals(name))) {
            g = iter.next();
        }
        return g;
    }

}
