package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.model.transazioni.IPagamenti;

public class TassaOrdinaria extends Tasse {

    public TassaOrdinaria(){
        super("Tassa di Ordinaria", 100);
    }

    public int calcolaTassa(IPagamenti strategia){
        return strategia.calcolaTassa(this);
    }

}
