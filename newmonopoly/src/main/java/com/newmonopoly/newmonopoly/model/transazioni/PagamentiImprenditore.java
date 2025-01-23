package com.newmonopoly.newmonopoly.model.transazioni;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.gamer.Imprenditore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Tassa;

public class PagamentiImprenditore extends PagamentiGiocatore {

    @Override
    public int pagaAffitto(Proprieta proprieta, Giocatore affittuario) {

        return (int) Math.floor(super.pagaAffitto(proprieta, affittuario) - (super.pagaAffitto(proprieta, affittuario)* 0.1));
    }

    public void pagaTassa(Tassa tassa, Imprenditore contribuente){
        int quantita = calcolaTassa(tassa);
        contribuente.pay(quantita);
    }

    public int calcolaTassa(Tassa tassa){
        return (int) Math.floor(tassa.getCosto() + tassa.getCosto()*0.5);
    }



}
