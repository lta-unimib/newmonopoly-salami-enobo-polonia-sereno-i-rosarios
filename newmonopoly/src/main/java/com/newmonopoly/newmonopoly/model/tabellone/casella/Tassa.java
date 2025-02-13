package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.newmonopoly.newmonopoly.eventi.casella.Ricevi;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.transazioni.IPagamenti;
import com.newmonopoly.newmonopoly.state.square.TaxState;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Tassa extends Casella {

    private int costo;

    protected Tassa() {
        state = TaxState.builder().tax(this).build();
    }

    @Override
    public void arrivo(Giocatore giocatore) {
        publishEvent(Ricevi.builder().importo(-giocatore.getStrategiaCalcoloAffitto().calcolaTassa(this)).build());
    }

    public int calcolaTassa(IPagamenti strategia){
        return strategia.calcolaTassa(this);
    }

    public void economiaCasuale(float random) {
        costo = (int) Math.floor(costo * random);
    }

}
