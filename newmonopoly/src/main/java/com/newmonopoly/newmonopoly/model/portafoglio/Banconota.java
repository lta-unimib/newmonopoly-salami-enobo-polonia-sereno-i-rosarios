package com.newmonopoly.newmonopoly.model.portafoglio;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Banconota {

    private int valore;
    private int quantita;


    public Banconota(int valore, int quantita){
        this.valore=valore;
        this.quantita=quantita;
    }

    public void modificaQuantita(int quantita) {
        this.quantita+=quantita;
    }

}
