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
public abstract class Tassa extends Casella {
    private int importo;

 /*   protected Tassa() {
        stato = TaxState.builder().tax(this).build();
    }

    @Override
    public void arrivo(Giocatore giocatore) {
        notifyAll(Ricevi.builder().importo(- giocatore.getStrategiaCalcoloAffitto().calcolaTassa(this)).build());
    }
*/

    public int calcolaTassa(IPagamenti strategia){
        return strategia.calcolaTassa(this);
    }

    public void economiaCasuale(float random) {
        importo = (int) Math.floor(getImporto()*random);
    }

}
