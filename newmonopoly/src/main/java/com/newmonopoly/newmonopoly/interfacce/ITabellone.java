package com.newmonopoly.newmonopoly.interfacce;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.gamer.Token;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Casella;

import java.io.Serializable;

public interface ITabellone extends Serializable {

    void caselleCasuali();

    Casella getCasella(int numeroCasella);

    // void muoviAProssimaCasellaIntero(Giocatore giocatore, Predicate<Casella> predicato);

    // void muoviAProssimaCasellaSemplice(Giocatore giocatore, Predicate<Casella> predicato);

    void muoviGiocatore(Token token, int quantita);

    void visitaCasella(Token token, int casellaDaVisitare);

}
