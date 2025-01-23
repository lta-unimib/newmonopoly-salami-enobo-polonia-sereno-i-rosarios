package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

import com.newmonopoly.newmonopoly.model.transazioni.PagamentiGiocatore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public abstract class Proprieta extends Casella {

    private int costoBase;
    private int ipoteca;
    private int affitto;

    protected Proprieta() {
    }

    @JsonIgnore
    private Giocatore proprietario;

    @JsonProperty("proprietario")
    public String getNomeProprietario() {
        if (proprietario != null){
            return proprietario.getNome();
        }
        return null;
    }

    public void economiaCasuale(float random) {
        costoBase = (int) Math.floor(getCostoBase()*random);
        ipoteca = (int) Math.floor(getIpoteca()*random);
        affitto = (int) Math.floor(getAffitto()*random);
    }


    public abstract int pagaAffitto(PagamentiGiocatore payStrategy);
}
