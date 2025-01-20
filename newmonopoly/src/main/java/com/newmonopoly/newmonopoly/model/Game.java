package com.newmonopoly.newmonopoly.model;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.gamer.Token;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.NoSuchElementException;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Game extends AbstractGame{


    protected Game(AbstractGameBuilder<?, ?> builder){
        super(builder);
    }

    /* @Override
    public synchronized void addPlayer(Giocatore giocatore) {
        if(players.size() == config.getNumeroGiocatori()) {
            //partitapiena
        }
        if(players.contains(giocatore)){
            //giocatoregiàentrato
        }
        giocatore.setBanconote(config.inizializzaBanconote());
        players.add(giocatore);
    } */

    public synchronized void addPlayer(Token token) {
        if (players.size() == config.getNumeroGiocatori()) {
            throw new IndexOutOfBoundsException();
        }
        if (players.contains(token)) {
            // giocatore già entrato
        }
        token.getGiocatore().setBanconote(config.inizializzaBanconote());
        players.add(token);
    }

    @Override
    public void removePlayer(Token token) {
        if(players.contains(token)){
            players.remove(token);
        }
        else {
            throw new NoSuchElementException("Impossibile rimuovere giocatore");
            // eccezione giocatore non in partita
        }
    }

    @Override
    public Giocatore getNomeGiocatore(Token token) {
        return token.getGiocatore();
    }
}
