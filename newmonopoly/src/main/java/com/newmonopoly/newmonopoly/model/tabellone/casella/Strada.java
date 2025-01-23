package com.newmonopoly.newmonopoly.model.tabellone.casella;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.model.tabellone.strategy.PayStrategy;
import com.newmonopoly.newmonopoly.state.square.UnsoldStreetState;
import lombok.*;
import lombok.experimental.SuperBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Strada extends Proprieta {


    @Builder.Default
    private String type = "Strada";
    private Colore colore;
    private int costoAlbergo;
    private int costoCasa;
    private boolean albergo;
    private int numCase;
    private int maxCase = 4;

    @JsonIgnore
    private ArrayList<Integer> affitti;

    /*
    @JsonCreator
    public Strada(
        @JsonProperty("nome") String nome,
        @JsonProperty("proprietario") Giocatore proprietario,
        @JsonProperty("costo") int costo,
        @JsonProperty("affitto") int affitto,
        @JsonProperty("ipoteca") int ipoteca,
        @JsonProperty("affitti") ArrayList<Integer> affitti,
        @JsonProperty("costoCasa") int costoCasa,
        @JsonProperty("costoAlbergo") int costoAlbergo,
        @JsonProperty("colore") Colore colore) {
            super(nome, proprietario, costo, ipoteca, affitti.get(0));
            setNumCase(0);
            setAlbergo(false);
            setAffitti(affitti);
            setCostoCasa(costoCasa);
            setCostoAlbergo(costoAlbergo);
            setColore(colore);
    }

     */

    public Strada() {
        stato = UnsoldStreetState.builder().strada(this).build();
        affitti = new ArrayList<>();
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
        red,
        blue,
        lightblue,
        yellow,
        orange,
        brown,
        purple,
        green
    }

    @Override
    public int calcolaAffitto(PayStrategy payStrategy) {
        return payStrategy.calcolaPagamento(this);
    }

    public void rinizializza(){
        numCase = 0;
        albergo = false;
        setStato(UnsoldStreetState.builder().strada(this).build());
    }

}