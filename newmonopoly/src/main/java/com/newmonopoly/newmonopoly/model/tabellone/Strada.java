package com.newmonopoly.newmonopoly.model.tabellone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.transazioni.Pagamenti;

public class Strada extends Proprieta {
    
    @Getter @Setter
    private int numCase;
    @Getter @Setter
    private boolean albergo;
    @Getter @Setter
    private ArrayList<Integer> affitti;
    @Getter @Setter
    private int costoCasa;
    @Getter @Setter
    private int costoAlbergo;
    @Getter @Setter
    private Colore colore;


    public Strada (String nome, Giocatore proprietario, int costo, int ipoteca, ArrayList<Integer> affitti, int costoCasa, int costoAlbergo, Colore colore) {
        super(nome, proprietario, costo, ipoteca);
        setNumCase(0);
        setAlbergo(false);
        setAffitti(affitti);
        setCostoCasa(costoCasa);
        setCostoAlbergo(costoAlbergo);
        setColore(colore);
    }

    public int calcolaAffitto(Pagamenti strategia) {
        return strategia.calcolaAffitto(this);
    }

    public boolean hasAlbergo(){
        return albergo;
    }

    public void aggiungiEdificio() {
        if (getProprietario().possiedeTutteLeProprietaDelColore(getColore())){
            if (getNumCase() < 4) {
                getProprietario().pay(costoCasa);
                numCase++;
            } else if(!hasAlbergo()) {
                getProprietario().pay(costoAlbergo);
                albergo = true;
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
            getProprietario().ricevi(costoAlbergo/2);
        } else if (numCase != 0) {
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
