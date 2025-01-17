package com.newmonopoly.newmonopoly.model.transazioni;

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
                return strada.getAffitti().get(numeroCase - 1);
            }
    
            return strada.getAffitto();
        
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
    
}
