package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.state.square.UnsoldStationState;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Stazione extends Proprieta {

    private ArrayList<Integer> affitti;
    private String type = "Stazione";

    /*
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
    */


    public void aggiornaAffittoStazione(){
            int numeroStazioniPossedute = getProprietario().getStazioni().size();
            if (numeroStazioniPossedute > 0 && numeroStazioniPossedute <= affitti.size()) {
                setAffitto(affitti.get(numeroStazioniPossedute - 1));
            }
        }

    @Override
    public int calcolaAffitto(PayStrategy payStrategy) {
        return payStrategy.calcolaPagamento(this);
    }

    @Override
    public void rinizializza(){
        setStato(UnsoldStationState.builder().stazione(this).build());
    }
}


