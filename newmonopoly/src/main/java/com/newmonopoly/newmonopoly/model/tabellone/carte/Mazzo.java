package com.newmonopoly.newmonopoly.model.tabellone.carte;

import java.util.LinkedList;
import java.util.Queue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.interfacce.IMazzo;
import com.newmonopoly.newmonopoly.model.gamer.Token;
import com.newmonopoly.newmonopoly.model.tabellone.strategy.EconomiaStabileStrategy;
import com.newmonopoly.newmonopoly.model.tabellone.strategy.IFluttuazioneEconomicaStrategy;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Mazzo implements IMazzo {

    @JsonIgnore
    @Builder.Default
    private IFluttuazioneEconomicaStrategy economia = new EconomiaStabileStrategy();
    @Builder.Default
    private Queue<Carta> probabilita = new LinkedList<>();
    @Builder.Default
    private Queue<Carta> imprevisto = new LinkedList<>();

    @Override
    public void pescaImprevisto(Token token) {
        Carta carta = imprevisto.remove();
        if(carta.effettoCarta(token)){
            imprevisto.add(carta);
        }
    }

    @Override
    public void pescaProbabilita(Token token) {
        Carta carta = probabilita.remove();
        if(carta.effettoCarta(token)){
            probabilita.add(carta);
        }
    }

    @Override
    public void usaCarta(Token token) {
        
    }

    @Override
    public void economiaCasuale() {
        imprevisto.forEach(carta -> economia.economiaCasuale(carta));
        probabilita.forEach(carta -> economia.economiaCasuale(carta));
    }

    @Override
    public Carta nextProbabilita() {
        return probabilita.peek();
    }

    @Override
    public Carta nextImprevisto() {
        return imprevisto.peek();
    }
}
