package com.newmonopoly.newmonopoly.model.gamer;


import java.io.Serial;
import java.io.Serializable;

public class Banconota implements Serializable {

    @Serial
    private static final long serialVersionUID = 2405172041950251807L;

    private int valore;
    private int quantita;

    public Banconota(int valore, int quantita){
        this.valore=valore;
        this.quantita=quantita;
    }

    public int getQuantita() {
        return this.quantita;
    }

    public int getValore() {
        return valore;
    }

    public void modificaQuantita(int quantitaDaAggiungere) {
        int nuovaQuantita = this.quantita + quantitaDaAggiungere;
        if (nuovaQuantita < 0) {
            throw new IllegalArgumentException("Quantità insufficiente di banconote per questa operazione.");
        }
        this.quantita = nuovaQuantita;
    }

    /*
    public void incrementaQuantita(int quantita) {
        this.quantita+=quantita;
    }

    public void decrementaQuantita(int quantita) {
        if (quantita > this.quantita) {
            throw new IllegalArgumentException("Non sono presenti abbastanza banconote di questo taglio!");
        }
        this.quantita-=quantita;
    }
     */

}
