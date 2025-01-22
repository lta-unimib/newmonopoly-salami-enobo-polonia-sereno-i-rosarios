package com.newmonopoly.newmonopoly.model.tabellone.casella;
import lombok.experimental.SuperBuilder;

@SuperBuilder
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