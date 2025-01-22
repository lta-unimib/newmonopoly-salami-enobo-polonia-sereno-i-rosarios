package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.model.gamer.Token;

import static com.newmonopoly.newmonopoly.model.tabellone.casella.Prigione.getPrigione;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class VaiInPrigione extends Casella {

    private static VaiInPrigione vaiInPrigione = null;

    public VaiInPrigione(){
        super("vaiInPrigione");
    }

    public static synchronized VaiInPrigione getVaiInPrigione() {
        if (vaiInPrigione == null) {
            vaiInPrigione = new VaiInPrigione();
        }
        return vaiInPrigione;
    }

    public void arresto(Token pedina){
        getPrigione().nuovoPrigioniero(pedina);
    }
}
