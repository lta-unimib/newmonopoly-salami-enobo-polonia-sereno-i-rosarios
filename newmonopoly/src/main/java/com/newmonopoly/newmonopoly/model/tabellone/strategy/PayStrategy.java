package com.newmonopoly.newmonopoly.model.tabellone.strategy;

import com.newmonopoly.newmonopoly.model.tabellone.casella.Societa;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Stazione;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Tassa;

public interface PayStrategy {

    int calcolaPagamento(Societa societa);
    int calcolaPagamento(Strada strada);
    int calcolaPagamento(Stazione stazione);
    int calcolaTassa(Tassa tassa);

}
