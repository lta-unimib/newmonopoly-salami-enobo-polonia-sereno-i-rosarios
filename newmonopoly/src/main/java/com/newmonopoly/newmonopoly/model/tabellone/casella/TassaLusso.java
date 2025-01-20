package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.model.transazioni.IPagamenti;

public class TassaLusso extends Tasse {


    public TassaLusso(){
        super("Tassa di Lusso", 200);
    }

    public int calcolaTassa(IPagamenti strategia){
        return strategia.calcolaTassa(this);
    }

}
