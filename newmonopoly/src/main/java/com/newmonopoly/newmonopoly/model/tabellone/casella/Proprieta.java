package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.transazioni.IPagamenti;
import lombok.Setter;

public abstract class Proprieta extends Casella {

    @Setter
    private Giocatore proprietario;
    private int costo;
    private int ipoteca;
    @Setter
    private int affitto;

    public Proprieta(String nome, Giocatore proprietario, int costo, int ipoteca, int affitto) {
        super(nome);
        this.proprietario = proprietario;
        this.costo = costo;
        this.ipoteca = ipoteca;
        setAffitto(affitto);
    }
    // public  int calcolaAffitto(Pagamenti strategia);


    /*public abstract int calcolaAffitto(IPagamenti strategia);*/

    public void economiaCasuale(float random) {
        costo = (int) Math.floor(getCosto()*random);
        ipoteca = (int) Math.floor(getIpoteca()*random);
        affitto = (int) Math.floor(getAffitto()*random);
    }

    public Giocatore getProprietario() {
        return proprietario;
    }

    public int getCosto() {
        return costo;
    }

    public int getIpoteca() {
        return ipoteca;
    }

    public int getAffitto() {
        return affitto;
    }


}
