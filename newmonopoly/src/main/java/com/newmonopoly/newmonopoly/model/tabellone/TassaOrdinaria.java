package com.newmonopoly.newmonopoly.model.tabellone;

import com.newmonopoly.newmonopoly.model.transazioni.Pagamenti;

public class TassaOrdinaria extends Tasse{

    public TassaOrdinaria(){
        super("Tassa di Ordinaria", 100);
    }

    public int calcolaTassa(Pagamenti strategia){
        return strategia.calcolaTassa(this);
    }

}
