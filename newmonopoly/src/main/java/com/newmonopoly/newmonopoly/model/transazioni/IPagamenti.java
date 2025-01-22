package com.newmonopoly.newmonopoly.model.transazioni;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Tassa;

public interface IPagamenti {
    //int calcolaAffitto(Strada strada);
    
    double pagaAffitto(Proprieta proprieta, Giocatore affittuario);
    int calcolaTassa(Tassa tassa);
    void pagaTassa(Tassa tassa, Giocatore contribuente);
}
