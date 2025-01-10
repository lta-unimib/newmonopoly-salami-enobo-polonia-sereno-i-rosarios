package com.newmonopoly.newmonopoly.model.tabellone;

import com.newmonopoly.newmonopoly.model.gamer.Token;

import java.util.ArrayList;

public class Tabellone {

    private int difficolta = 1;
    private ArrayList<Casella> caselle;
    private ArrayList<Token> pedine;

    public Tabellone (int difficolta){
        this.difficolta = difficolta;
        caselle = new ArrayList<Casella>(40);
        pedine = new ArrayList<Token>(6);
    }

    /// per settaggio difficoltà
    public void setTabellone(int difficolta) {
        switch (difficolta){
            case 1:
                ///
        }
    }
}
