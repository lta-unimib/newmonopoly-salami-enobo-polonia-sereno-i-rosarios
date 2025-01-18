package com.newmonopoly.newmonopoly.model.transazioni;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.tabellone.Proprieta;
import com.newmonopoly.newmonopoly.model.tabellone.Societa;
import com.newmonopoly.newmonopoly.model.tabellone.Stazione;
import com.newmonopoly.newmonopoly.model.tabellone.Strada;
import com.newmonopoly.newmonopoly.model.tabellone.Tasse;

public class PagamentiGiocatore implements Pagamenti {

    @Override
    public int calcolaAffitto(Strada strada) {
            int numeroCase = strada.getNumCase();
            int numeroAffitti = strada.getAffitti().size();
            
            if (strada.hasAlbergo() == true) {
                return strada.getAffitti().get(numeroAffitti - 1);
            }

            if (numeroCase > 0) {
                return strada.getAffitti().get(numeroCase);
            }
    
            return strada.getAffitti().get(0);
        
    }

    @Override
    public int calcolaAffitto(Stazione stazione) {
        return stazione.getAffitto();
    }

    @Override
    public int calcolaAffitto(Societa societa) {
        return societa.getAffitto();
    }

    @Override
    public int calcolaTassa(Tasse tassa) {
       return tassa.getImporto();
    }

    public void acquistaProprieta(Proprieta proprieta, Giocatore acquirente){
        if(acquirente.getSaldo() >= proprieta.getCosto()) {
            acquirente.pay(proprieta.getCosto());
            proprieta.setProprietario(acquirente);
        }
    }
    
    public void pagaAffitto(Strada strada, Giocatore affittuario){
        int quantita = calcolaAffitto(strada);
        affittuario.pay(quantita);
        strada.getProprietario().ricevi(quantita);
    }

    public void pagaAffitto(Stazione stazione, Giocatore affittuario){
        int quantita = calcolaAffitto(stazione);
        affittuario.pay(quantita);
        stazione.getProprietario().ricevi(quantita);
    }

    public void pagaAffitto(Societa societa, Giocatore affittuario){
        int quantita = calcolaAffitto(societa);
        affittuario.pay(quantita);
        societa.getProprietario().ricevi(quantita);
    }

    public void pagaTassa(Tasse tassa, Giocatore contribuente){
        int quantita = calcolaTassa(tassa);
        contribuente.pay(quantita);
    }


    //gestire vendita e  ipoteca in caso di presenza di edifici (case e alberghi)
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

   
