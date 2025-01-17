package com.newmonopoly.newmonopoly.model.tabellone;

import com.newmonopoly.newmonopoly.model.gamer.Token;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Prigione extends Casella implements Serializable {

    @Serial
    private static final long serialVersionUID = 2405172141950251807L;

    private static Prigione prigione = null;

    private ArrayList<Token> prigionieri;

    private Prigione () {
        super("prigione");
        this.prigionieri = new ArrayList<Token>(6);
    }

    public static synchronized Prigione getPrigione() {
        if (prigione == null) {
            prigione = new Prigione();
        }
        return prigione;
    }

    public void nuovoPrigioniero(Token pedina){
        if(!checkPrigioniero(pedina)){
            this.prigionieri.add(pedina);
        }
    }

    public void rilascioPrigioniero(Token pedina){
        this.prigionieri.remove(pedina);
    }

    public boolean checkPrigioniero(Token pedina) {
        return this.prigionieri.contains(pedina);
    }

}
