package com.newmonopoly.newmonopoly.model.tabellone;

import lombok.Builder;
import lombok.Data;

import java.util.Random;

@Data
@Builder
public class Dadi {

    @Builder.Default
    private static final Random random = new Random();
    private static int dado1, dado2;
    private int lanciDiFila = 0;

    private Dadi() {
        dado1 = -1;
        dado2 = -1;
    }

    public static int lancia() {
        return random.nextInt(6) + 1;
    }

    public int lanciaDadi() {
        lanciDiFila++;
        dado1 = lancia();
        dado2 = lancia();
        return (dado1+dado2);
    }

    public boolean dadiUguali(){
        return (dado1 == dado2);
    }

}
