package com.newmonopoly.newmonopoly.model.tabellone;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

public class Proprieta extends Casella {

    private Giocatore proprietario;
    private int costo;
    private int ipoteca;
    private int affitto;

    public Proprieta (String nome, Giocatore proprietario, int costo, int ipoteca) {
        super(nome);
        setProprietario(proprietario);
        setCosto(costo);
        setIpoteca(ipoteca);
    }

   // public  int calcolaAffitto(Pagamenti strategia);

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public void setIpoteca(int ipoteca) {
        this.ipoteca = ipoteca;
    }

    public void setProprietario(Giocatore proprietario) {
        this.proprietario = proprietario;
    }

    public void setAffitto(int affitto) {
        this.affitto = affitto;
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
