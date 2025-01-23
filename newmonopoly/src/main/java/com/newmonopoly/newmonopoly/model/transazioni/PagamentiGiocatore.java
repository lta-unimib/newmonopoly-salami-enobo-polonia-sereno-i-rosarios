package com.newmonopoly.newmonopoly.model.transazioni;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Societa;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Stazione;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Tassa;

public class PagamentiGiocatore implements IPagamenti {

    @Override
    public int calcolaTassa(Tassa tassa) {
       return tassa.getCosto();
    }



    public void acquistaProprieta(Proprieta proprieta, Giocatore acquirente){
        if(acquirente.getSaldo() >= proprieta.getCostoBase()) {
            acquirente.pay(proprieta.getCostoBase());
            proprieta.setProprietario(acquirente);
            acquirente.aggiungiProprieta(proprieta);

            if(proprieta instanceof Stazione) {
                for (Proprieta p : acquirente.getStazioni()) {
                    if (p instanceof Stazione stazione) {
                        stazione.aggiornaAffittoStazione();
                    }

                }
            }
            acquirente.aggiungiPuntiFedelta(proprieta.getCostoBase());
        }
    }

    @Override
    public double pagaAffitto(Proprieta proprieta, Giocatore affittuario){
        int quantita = proprieta.getAffitto();
        if(proprieta instanceof Strada || proprieta instanceof Stazione) {
            affittuario.pay(proprieta.getAffitto());
            proprieta.getProprietario().ricevi(quantita);
        }
        //se è una società il valore si basa sul risultato dei dadi
        else if(proprieta instanceof Societa societa) {
            quantita = societa.calcolaAffittoSocieta();
            affittuario.pay(quantita);
            societa.getProprietario().ricevi(quantita);
        }
        return 0;
    }

    @Override
    public void pagaTassa(Tassa tassa, Giocatore contribuente){
        int quantita = calcolaTassa(tassa);
        contribuente.pay(quantita);
    }


    public void ipotecaProprieta(Proprieta proprieta){
        if(proprieta instanceof Strada && ((Strada) proprieta).getNumCase()>0 || ((Strada) proprieta).hasAlbergo()){
            throw new IllegalArgumentException("Non puoi ipotecare la proprieta, devi prima rimuovere gli edifici");
        }
        proprieta.getProprietario().ricevi(proprieta.getIpoteca());
        proprieta.setProprietario(null);
    }

    public void vendiProprieta(int prezzoConcordato, Proprieta proprieta, Giocatore acquirente){
        if(proprieta instanceof Strada && ((Strada) proprieta).getNumCase()>0 || ((Strada) proprieta).hasAlbergo()){
            throw new IllegalArgumentException("Non puoi vendere la proprieta, devi prima rimuovere gli edifici");
        }
        proprieta.getProprietario().ricevi(prezzoConcordato);
        acquirente.pay(prezzoConcordato);
        proprieta.getProprietario().rimuoviProprieta(proprieta);
        proprieta.setProprietario(acquirente);
        acquirente.aggiungiProprieta(proprieta);
        
    }
    
}

   
