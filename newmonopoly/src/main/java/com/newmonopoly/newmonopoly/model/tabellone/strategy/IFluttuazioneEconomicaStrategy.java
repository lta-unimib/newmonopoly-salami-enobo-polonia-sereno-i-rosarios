package com.newmonopoly.newmonopoly.model.tabellone.strategy;

import com.newmonopoly.newmonopoly.model.tabellone.casella.Casella;
import com.newmonopoly.newmonopoly.model.tabellone.carte.Carta;

public interface IFluttuazioneEconomicaStrategy {
    public void economiaCasuale(Casella casella);   
    public void economiaCasuale(Carta carta);
}
