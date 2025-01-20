package com.newmonopoly.newmonopoly.model.transazioni;

import com.newmonopoly.newmonopoly.model.tabellone.casella.Societa;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Stazione;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Tasse;

public interface IPagamenti {
    //int calcolaAffitto(Strada strada);
    //int calcolaAffitto(Stazione stazione);
    //int calcolaAffitto(Societa societa);
    int calcolaTassa(Tasse tassa);
}
