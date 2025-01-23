package com.newmonopoly.newmonopoly.model.tabellone.strategy;

import com.newmonopoly.newmonopoly.model.tabellone.casella.Societa;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Stazione;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Tassa;

public class PayStrategyGamer implements PayStrategy {


    @Override
    public int calcolaPagamento(Societa societa) {
        return societa.getAffitto();
    }

    @Override
    public int calcolaPagamento(Strada strada) {
        if (strada.hasAlbergo()) {
            return strada.getAffitti().get(strada.getAffitti().size() - 1);
        } else if (strada.getNumCase() > strada.getAffitti().size()) {
            return strada.getAffitti().get(strada.getAffitti().size() - 2);
        }
        if (strada.getNumCase() != 0){
            return strada.getAffitti().get(strada.getNumCase() - 1);
        }
        return strada.getAffitto();
    }

    @Override
    public int calcolaPagamento(Stazione stazione) {
        return stazione.getAffitto();
    }

    @Override
    public int calcolaTassa(Tassa tassa) {
        return tassa.getImporto();
    }
}
