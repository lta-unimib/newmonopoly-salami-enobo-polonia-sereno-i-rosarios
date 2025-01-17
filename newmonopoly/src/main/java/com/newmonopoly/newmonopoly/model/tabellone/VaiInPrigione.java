package com.newmonopoly.newmonopoly.model.tabellone;

import com.newmonopoly.newmonopoly.model.gamer.Token;
import static com.newmonopoly.newmonopoly.model.tabellone.Prigione.getPrigione;

public class VaiInPrigione extends Casella{

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
