package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.transazioni.IPagamenti;

import lombok.Data;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class Proprieta extends Casella {

    private Giocatore proprietario;
    private int costoBase;
    private int ipoteca;
    private int affitto;

    public Proprieta(String nome, Giocatore proprietario, int costoBase, int ipoteca, int affitto) {
        super(nome);
        this.proprietario = proprietario;
        this.costoBase = costoBase;
        this.ipoteca = ipoteca;
        setAffitto(affitto);
    }
    // public  int calcolaAffitto(Pagamenti strategia);


    /*public abstract int calcolaAffitto(IPagamenti strategia);*/

    public void economiaCasuale(float random) {
        costoBase = (int) Math.floor(getCostoBase()*random);
        ipoteca = (int) Math.floor(getIpoteca()*random);
        affitto = (int) Math.floor(getAffitto()*random);
    }

    public Giocatore getProprietario() {
        return proprietario;
    }

    public int getCostoBase() {
        return costoBase;
    }

    public int getIpoteca() {
        return ipoteca;
    }

    public int getAffitto() {
        return affitto;
    }


}
