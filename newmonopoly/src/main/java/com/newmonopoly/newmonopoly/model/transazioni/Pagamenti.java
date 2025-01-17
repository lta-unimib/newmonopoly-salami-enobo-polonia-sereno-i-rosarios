package com.newmonopoly.newmonopoly.model.transazioni;

import com.newmonopoly.newmonopoly.model.tabellone.Societa;
import com.newmonopoly.newmonopoly.model.tabellone.Stazione;
import com.newmonopoly.newmonopoly.model.tabellone.Strada;
import com.newmonopoly.newmonopoly.model.tabellone.Tasse;

public interface Pagamenti {
    int calcolaAffitto(Strada strada);
    int calcolaAffitto(Stazione stazione);
    int calcolaAffitto(Societa societa);
    int calcolaTassa(Tasse tassa);
}
