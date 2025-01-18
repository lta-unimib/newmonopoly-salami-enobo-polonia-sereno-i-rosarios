package com.newmonopoly.newmonopoly.model.tabellone.casella;


public class Parcheggio extends Casella {

    private static Parcheggio parcheggio = null;

    public Parcheggio() {
        super("Parcheggio");
    }

    public static synchronized Parcheggio getParcheggio() {
        if (parcheggio == null) {
            parcheggio = new Parcheggio();
        }
        return parcheggio;
    }
}
