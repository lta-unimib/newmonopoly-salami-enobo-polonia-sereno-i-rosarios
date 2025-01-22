package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.model.transazioni.IPagamenti;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada.Colore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Stazione extends Proprieta {

    @Setter
    private ArrayList<Integer> affitti;
    private String type = "Stazione";

    // public Stazione (String nome, Giocatore proprietario, int costoBase, int ipoteca, int affitto, ArrayList<Integer> affitti) {
    //     super(nome, proprietario, costoBase, ipoteca, affitti.get(0));
    //     setAffitti(affitti);
    // }
     @JsonCreator
    public Stazione(
        @JsonProperty("nome") String nome,
        @JsonProperty("proprietario") Giocatore proprietario,
        @JsonProperty("costo") int costo,
        @JsonProperty("affitto") int affitto,
        @JsonProperty("ipoteca") int ipoteca,
        @JsonProperty("affitti") ArrayList<Integer> affitti) {
            super(nome, proprietario, costo, ipoteca, affitti.get(0));
            setAffitti(affitti);
    }

    public void aggiornaAffittoStazione(){
            int numeroStazioniPossedute = getProprietario().getStazioni().size();
            if (numeroStazioniPossedute > 0 && numeroStazioniPossedute <= affitti.size()) {
                setAffitto(affitti.get(numeroStazioniPossedute - 1));
            }
        }
    }


