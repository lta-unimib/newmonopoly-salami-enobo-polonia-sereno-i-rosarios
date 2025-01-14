package com.newmonopoly.newmonopoly.model.transazioni;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.gamer.Token;
import com.newmonopoly.newmonopoly.model.tabellone.Prigione;
import com.newmonopoly.newmonopoly.model.tabellone.Proprieta;

import java.util.ArrayList;

public class Banca {

    private static Banca banca = null;

    //Singleton
    public static synchronized Banca getBanca() {
        if (banca == null) {
            banca = new Banca();
        }
        return banca;
    }

    //metodi potenzialmente chiamati da un controller dedicato al lancio di dadi.
    //una volta lanciati i dadi si verificherà la posizione del giocatore e si deciderà
    //che azione eseguire

    public void acquistaProprieta(Proprieta proprieta, Giocatore acquirente){
        if(acquirente.getSaldo() >= proprieta.getCosto()) {
            acquirente.pay(proprieta.getCosto());
            proprieta.setProprietario(acquirente);
        }
    }

    public void pagaAffitto(Proprieta proprieta, Giocatore affittuario){
        int quantita = proprieta.getAffitto();
        if (affittuario.getSaldo() >= quantita) {
            affittuario.pay(quantita);
            proprieta.getProprietario().ricevi(quantita);
        }
    }

    public void ipotecaProprieta(Proprieta proprieta){
        proprieta.getProprietario().ricevi(proprieta.getIpoteca());
        proprieta.setProprietario(null);
    }

    public void vendiProprieta(int prezzoConcordato, Proprieta proprieta, Giocatore acquirente){
        proprieta.getProprietario().ricevi(prezzoConcordato);
        acquirente.pay(prezzoConcordato);
        proprieta.setProprietario(acquirente);
    }

    public void pagaTassa(int tassa, Giocatore contribuente) {
        contribuente.pay(tassa);
    }
}
