package com.newmonopoly.newmonopoly.model;

import com.newmonopoly.newmonopoly.interfacce.ITabellone;
import com.newmonopoly.newmonopoly.model.gamer.Token;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;

@Data
@Builder
public class Turno implements Serializable {

    private Token token;

    @Builder.Default
    private int lanciConsecutivi = 0;

    @Builder.Default
    private int casellaDaVisitare = -1;

    @Builder.Default
    private ArrayList<Integer> valoreDadi = new ArrayList<>();

    @Builder.Default
    private SecureRandom random = new SecureRandom();

    @Builder.Default
    private int triggerDadiUguali = 3;

    public void initDadi(int numeroDadi) {
        if (valoreDadi.isEmpty()) {
            for (int i = 0; i < numeroDadi; ++i) {
                valoreDadi.add(-1);
            }
        }
    }

    public void lancioDadi(int facceDadi) {
        for (int i = 0; i < valoreDadi.size(); ++i) {
            valoreDadi.set(i, random.nextInt(facceDadi) + 1);
        }

        ++lanciConsecutivi;
        casellaDaVisitare = sommaDadi();
    }

    public int sommaDadi() {
        return valoreDadi.stream().reduce(0, Integer::sum);
    }

    public boolean ugualiDadi() {
        if (valoreDadi.isEmpty()){
            return false;
        }
        boolean uguali = true;
        int valorePrecedente = valoreDadi.get(0);
        Iterator<Integer> iter = valoreDadi.iterator();
        while (iter.hasNext() && uguali) {
            Integer successivo = iter.next();
            if (valorePrecedente != successivo) {
                uguali = false;
            }
        }
        return uguali;
    }

    public boolean inCasella() {
        return casellaDaVisitare > 0;
    }

    public void nextCasella(ITabellone tabellone) {
        --casellaDaVisitare;
        tabellone.visitaCasella(token, casellaDaVisitare);
    }

    public boolean fineTurno(){
        return !ugualiDadi() && lanciConsecutivi > 0;
    }

    public boolean limitePrigione(){
        return lanciConsecutivi == triggerDadiUguali && ugualiDadi();
    }

}
