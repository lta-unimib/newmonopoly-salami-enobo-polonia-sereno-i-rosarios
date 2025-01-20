package com.newmonopoly.newmonopoly.model.transazioni;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Tasse;

public interface IPagamenti {
    //int calcolaAffitto(Strada strada);
    
    void pagaAffitto(Proprieta proprieta, Giocatore affittuario);
    
    int calcolaTassa(Tasse tassa);
}
