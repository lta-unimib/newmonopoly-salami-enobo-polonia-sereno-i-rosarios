package com.newmonopoly.newmonopoly.model.tabellone.strategy;

import com.newmonopoly.newmonopoly.model.tabellone.casella.Casella;
import lombok.Builder;

import java.security.SecureRandom;

@Builder
public class FluttuazioneStrategy implements IFluttuazioneEconomicaCaselleStrategy {

    @Override
    public void economiaCasuale(Casella casella) {
        float random = (float) (new SecureRandom().nextFloat()*0.4 + 0.8);
        casella.economiaCasuale(random);
    }
}
