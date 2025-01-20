package com.newmonopoly.newmonopoly.model.tabellone.casella;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

public class Strada extends Proprieta {
    
    @Getter @Setter
    private int numCase;
    @Getter @Setter
    private boolean albergo;
    @Setter
    private ArrayList<Integer> affitti;
    @Getter @Setter
    private int costoCasa;
    @Getter @Setter
    private int costoAlbergo;
    @Getter @Setter
    private Colore colore;


    public Strada (String nome, Giocatore proprietario, int costo, int affitto, int ipoteca, ArrayList<Integer> affitti, int costoCasa, int costoAlbergo, Colore colore) {
        super(nome, proprietario, costo, ipoteca, affitti.get(0));
        setNumCase(0);
        setAlbergo(false);
        setAffitti(affitti);
        setCostoCasa(costoCasa);
        setCostoAlbergo(costoAlbergo);
        setColore(colore);
    }

    public boolean hasAlbergo(){
        return albergo;
    }

    public void aggiungiEdificio() {
        if (getProprietario().possiedeTutteLeProprietaDelColore(getColore())){
            if (getNumCase() < 4) {
                getProprietario().pay(costoCasa);
                super.setAffitto(this.affitti.get(numCase));
                numCase++;
            } else if(!hasAlbergo()) {
                getProprietario().pay(costoAlbergo);
                albergo = true;
                super.setAffitto(this.affitti.get(numCase));
                numCase=0;
            }
            else{
                throw new IllegalArgumentException("la proprietà ha il numero massimo di edifici");
            }
        
       }
    }

    public void rimuoviEdificio(){
        if (hasAlbergo()) {
            albergo = false;
            numCase = 4;
            super.setAffitto(this.affitti.get(numCase-1));
            getProprietario().ricevi(costoAlbergo/2);
        } else if (numCase != 0) {
            super.setAffitto(this.affitti.get(numCase-1));
            numCase --;
            getProprietario().ricevi(costoCasa/2);
        }
        else
            throw new IllegalArgumentException("Il giocatore non possiede alcun edificio");
    }


    public enum Colore {
        ROSSO,
        BLU,
        AZZURRO,
        GIALLO,
        ARANCIONE,
        MARRONE,
        VIOLA,
        VERDE
    }

}
