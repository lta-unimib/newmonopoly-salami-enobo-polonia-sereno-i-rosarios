package com.newmonopoly.newmonopoly.model.tabellone.strategy;

import com.newmonopoly.newmonopoly.model.tabellone.casella.Casella;
import com.newmonopoly.newmonopoly.model.tabellone.carte.Carta;
import lombok.Builder;

import java.security.SecureRandom;

@Builder
public class FluttuazioneStrategy implements IFluttuazioneEconomicaStrategy {

    @Override
    public void economiaCasuale(Casella casella) {
        float random = (float) (new SecureRandom().nextFloat()*0.4 + 0.8);
        casella.economiaCasuale(random);
    }

    @Override
    public void economiaCasuale(Carta carta) {
        float random = (float) (new SecureRandom().nextFloat()*0.4 + 0.8);
        carta.economiaCasuale(random);
    }
}
