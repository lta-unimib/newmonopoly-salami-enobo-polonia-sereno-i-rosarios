package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.model.transazioni.IPagamenti;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class TassaOrdinaria extends Tassa {

    public TassaOrdinaria(){
        super("Tassa di Ordinaria", 100);
    }

    public int calcolaTassa(IPagamenti strategia){
        return strategia.calcolaTassa(this);
    }

}
