package com.newmonopoly.newmonopoly.model;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.state.game.GameState;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.Iterator;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Game extends AbstractGame{

    /*
    protected Game(AbstractGameBuilder<?, ?> builder){
        super(builder);
    }
     */

    @Override
    public synchronized void addPlayer(Giocatore giocatore) {
        if(players.size() == config.getNumeroGiocatori())
            throw new IllegalArgumentException(); // eccezione partita piena
        if(players.contains(giocatore)) throw new IllegalArgumentException(); // eccezione giocatore doppio
        giocatore.setBanconote(config.getBanconote());
        players.add(giocatore);
    }

    @Override
    public synchronized void removePlayer(Giocatore giocatore) {
        if(players.size() > 2){
            players.remove(giocatore);
        }
        else throw new IllegalArgumentException();
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
