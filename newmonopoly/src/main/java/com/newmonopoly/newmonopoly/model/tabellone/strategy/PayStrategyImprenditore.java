package com.newmonopoly.newmonopoly.model.tabellone.strategy;

import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Tassa;
import com.newmonopoly.newmonopoly.state.square.TaxState;

public class PayStrategyImprenditore extends PayStrategyGamer{

    @Override
    public int calcolaPagamento(Strada strada) {
        return (int) Math.floor(super.calcolaPagamento(strada) - super.calcolaPagamento(strada) * 0.5);
    }

    @Override
    public int calcolaTassa(Tassa tassa) {
        return (int) Math.floor(tassa.getImporto() + tassa.getImporto() * 0.75);
    }

}
