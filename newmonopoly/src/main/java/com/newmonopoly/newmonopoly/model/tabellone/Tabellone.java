package com.newmonopoly.newmonopoly.model.tabellone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.interfacce.ITabellone;
import com.newmonopoly.newmonopoly.model.gamer.Token;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Casella;
import com.newmonopoly.newmonopoly.model.tabellone.strategy.EconomiaStabileStrategy;
import com.newmonopoly.newmonopoly.model.tabellone.strategy.IFluttuazioneEconomicaCaselleStrategy;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class Tabellone implements ITabellone, Serializable {


    @JsonIgnore
    private List<Casella> caselle;
    //private List<Token> pedine;

    @JsonIgnore
    @Builder.Default
    private transient IFluttuazioneEconomicaCaselleStrategy economia = new EconomiaStabileStrategy();

    public Tabellone (List<Token> tokensInGame){
        caselle = new ArrayList<>(40);
        //pedine = tokensInGame;
        //inizializzaPosizioni(pedine);
    }

    @Override
    public Casella getCasella(int numero) {
        return caselle.get(numero);
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
