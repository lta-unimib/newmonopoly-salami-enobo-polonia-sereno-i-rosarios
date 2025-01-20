package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.model.transazioni.IPagamenti;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Stazione extends Proprieta {

    @Setter
    private ArrayList<Integer> affitti;

    public Stazione (String nome, Giocatore proprietario, int costo, int ipoteca, int affitto, ArrayList<Integer> affitti) {
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


