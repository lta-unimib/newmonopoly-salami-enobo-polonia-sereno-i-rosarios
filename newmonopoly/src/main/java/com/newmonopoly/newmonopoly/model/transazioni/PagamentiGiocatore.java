package com.newmonopoly.newmonopoly.model.transazioni;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Societa;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Stazione;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Tasse;

public class PagamentiGiocatore implements IPagamenti {

    @Override
    public int calcolaTassa(Tasse tassa) {
       return tassa.getImporto();
    }



    public void acquistaProprieta(Proprieta proprieta, Giocatore acquirente){
        if(acquirente.getSaldo() >= proprieta.getCosto()) {
            acquirente.pay(proprieta.getCosto());
            proprieta.setProprietario(acquirente);
            acquirente.aggiungiProprieta(proprieta);

            if(proprieta instanceof Stazione){
                for(Proprieta p : acquirente.getStazioni()){
                    //chiama metodo per modificare affitto in stazioni in base allla lunghezza della lista getStazioni
                }
            }
            if(proprieta instanceof Societa){
                for(Proprieta p : acquirente.getSocieta()){
                    //chiama metodo per modificare affitto in stazioni in base allla lunghezza della lista getStazioni
                }
            }
        }
    }
    
    //Per stazione e societa, gestire il possedimento di più proprietà dello stesso tipo
    public void pagaAffitto(Proprieta proprieta, Giocatore affittuario){
        int quantita = proprieta.getAffitto();
        if(proprieta instanceof Strada || proprieta instanceof Stazione || 
        proprieta instanceof Societa) {
            affittuario.pay(proprieta.getAffitto());
            proprieta.getProprietario().ricevi(quantita);
        }
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
        proprieta.getProprietario().rimuoviProprieta(proprieta);
        proprieta.setProprietario(acquirente);
        acquirente.aggiungiProprieta(proprieta);
        
    }

    public void pagaTassa(int tassa, Giocatore contribuente) {
        contribuente.pay(tassa);
    }
    
}

   
