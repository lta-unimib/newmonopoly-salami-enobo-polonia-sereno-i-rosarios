package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.model.transazioni.IPagamenti;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class TassaLusso extends Tassa {


    public TassaLusso(){
        super("Tassa di Lusso", 200);
    }

    public int calcolaTassa(IPagamenti strategia){
        return strategia.calcolaTassa(this);
    }

}
