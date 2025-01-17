package com.newmonopoly.newmonopoly.model.tabellone;

public class Via extends Casella {

    private static Via via = null;

    public Via() {
        super("Via");
    }

    public static synchronized Via getVia() {
        if (via == null) {
            via = new Via();
        }
        return via;
    }
}
