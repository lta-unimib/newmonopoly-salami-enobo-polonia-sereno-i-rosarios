package com.newmonopoly.newmonopoly.model;

import com.newmonopoly.newmonopoly.interfacce.ITabellone;
import com.newmonopoly.newmonopoly.model.gamer.Token;
import com.newmonopoly.newmonopoly.model.tabellone.Dadi;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Turno implements Serializable {

    private Token token;
    private Dadi dadi;
    private int casellaDaVisitare;
    private static final int limiteLanciDiFila = 3;

    public boolean inVisita(){
        casellaDaVisitare = dadi.lanciaDadi();
        return casellaDaVisitare > 0;
    }

    public void prossimoEffetto(ITabellone tabellone) {
        --casellaDaVisitare;
        // tabellone.applicaEffetto(token, casellaDaVisitare);
    }

    public boolean turnoFinito(){
        return !dadi.dadiUguali() && dadi.getLanciDiFila() > 0;
    }

    public boolean limiteLanci(){
        return dadi.getLanciDiFila() == limiteLanciDiFila && dadi.dadiUguali(); // dopo 3 lanci di fila uguali --> Prigione
    }

}
