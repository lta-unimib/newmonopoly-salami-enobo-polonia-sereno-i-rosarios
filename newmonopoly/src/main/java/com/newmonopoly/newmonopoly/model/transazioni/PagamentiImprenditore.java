package com.newmonopoly.newmonopoly.model.transazioni;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.gamer.Imprenditore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Tassa;

public class PagamentiImprenditore extends PagamentiGiocatore {


    public int PagaAffitto(Proprieta proprieta, Giocatore affittuario) {

        return (int) Math.floor(super.pagaAffitto(proprieta, affittuario) - (super.pagaAffitto(proprieta, affittuario)* 0.1));
    }

    public int CalcolaTassa(Tassa tassa){
        return (int) Math.floor(tassa.getImporto() + tassa.getImporto()*0.5);
    }

    public void PagaTassa(Tassa tassa, Imprenditore contribuente){
        int quantita = calcolaTassa(tassa);
        contribuente.pay(quantita);
    }

}
