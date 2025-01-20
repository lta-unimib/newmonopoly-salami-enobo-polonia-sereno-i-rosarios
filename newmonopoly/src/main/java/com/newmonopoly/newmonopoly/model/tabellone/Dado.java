package com.newmonopoly.newmonopoly.model.tabellone;

import java.util.Random;

public class Dado {
    private static final Random random = new Random();

    private Dado() {
        // Costruttore privato per impedire l'instanziazione
    }

    public static int lancia() {
        return random.nextInt(6) + 1;
    }

    public static int lanciaDadi(int numeroDadi) {
        int risultato = 0;
        for (int i = 0; i < numeroDadi; i++) {
            risultato += lancia();
        }
        return risultato;
    }

}
