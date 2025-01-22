package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.model.tabellone.Dadi;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Societa extends Proprieta {
    private String type = "Societa";
    
    // Costruttore di default pubblico
    public Societa() {
        super("", null, 0, 0, 0);  // Assicurati che la classe base Proprieta abbia un costruttore di default
    }

    // Costruttore con i parametri
    @JsonCreator
    public Societa(
        @JsonProperty("nome") String nome,
        @JsonProperty("proprietario") Giocatore proprietario,
        @JsonProperty("costoBase") int costoBase,
        @JsonProperty("ipoteca") int ipoteca,
        @JsonProperty("affitto") int affitto) {
        super(nome, proprietario, costoBase, ipoteca, affitto);
    }

    public int calcolaAffittoSocieta() {
        // Lancia due dadi
        int risultatoDadi = Dadi.lancia() + Dadi.lancia();
        // Determina il numero di società possedute dal proprietario
        int societaPossedute = this.getProprietario().getSocieta().size();
        // Imposta il moltiplicatore in base al numero di società possedute
        int moltiplicatore = (societaPossedute == 1) ? 4 : 10;
        // Calcola l'affitto totale
        return risultatoDadi * moltiplicatore;
    }


}
