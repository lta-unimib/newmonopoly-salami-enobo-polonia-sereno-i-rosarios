package com.newmonopoly.newmonopoly.model.tabellone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.interfacce.ITabellone;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.gamer.Token;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Casella;
import com.newmonopoly.newmonopoly.model.tabellone.strategy.EconomiaStabileStrategy;
import com.newmonopoly.newmonopoly.model.tabellone.strategy.IFluttuazioneEconomicaStrategy;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Tabellone implements ITabellone, Serializable {

    @JsonIgnore
    private List<Casella> caselle;
    private List<Token> pedine;

    @JsonIgnore
    @Builder.Default
    private transient IFluttuazioneEconomicaStrategy economia = new EconomiaStabileStrategy();

/*
    public Tabellone (List<Casella> caselle, List<Token> tokensInGame){
        caselle = new ArrayList<>(caselle);
        pedine = new ArrayList<>(tokensInGame);
        // inizializzaPosizioni(pedine);
    }*/

    @Override
    public Casella getCasella(int numero) {
        return caselle.get(numero);
    }

    @Override
    public void muoviGiocatore(Token token, int quantita) {
        token.setCasella(caselle.get((caselle.indexOf(token.getCasella()) + quantita) % caselle.size()));
    }

    @Override
    public void applicaEffetto(Token token, int casellaDaVisitare) {
        muoviGiocatore(token, 1);
        if (offset == 0) {
            token.getCasella()
        } else {

        }
    }

    public void caselleCasuali() {
        for (Casella casella : caselle) {
            economia.economiaCasuale(casella);
        }
    }

    /*
    public void inizializzaPosizioni(List<Token> pedine)
    {
        for(Token token : pedine) {
            token.setCasella(getVia());
        }
    }*/

}
