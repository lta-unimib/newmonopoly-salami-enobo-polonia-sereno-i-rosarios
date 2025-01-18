package com.newmonopoly.newmonopoly.model.tabellone;

import com.newmonopoly.newmonopoly.model.transazioni.Pagamenti;

public class TassaLusso extends Tasse{

    public TassaLusso(String string, int importo){
        super("Tassa di Lusso", 200);
    }

    public int calcolaTassa(Pagamenti strategia){
        return strategia.calcolaTassa(this);
    }

}
