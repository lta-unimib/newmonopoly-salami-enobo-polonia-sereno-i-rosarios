package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.newmonopoly.newmonopoly.eventi.casella.Ricevi;
import com.newmonopoly.newmonopoly.eventi.gamer.*;


import java.io.Serializable;


public interface SquareState extends Serializable {
    @JsonProperty("type")
    default String getTipo(){
        return getClass().getSimpleName();
    }

    default void handleEvent(AcquistaProprieta acquistaProprieta) {}

    default void handleEvent(Join join) {}

    default void handleEvent(EventoIpoteca eventoIpoteca) {}

    default void handleEvent(DowngradaTerreno downgradaTerreno) {}

    default void handleEvent(UpgradaTerreno upgradaTerreno) {}

    default void handleEvent(EntraInPartita entraInPartita) {}

    default void handleEvent(EventoLanciaDadi eventoLanciaDadi) {}

    default void handleEvent(EventoOfferta eventoOfferta){}

    default void handleEvent(EventoPaga eventoPaga){}

    default void handleEvent(EventoVaiInPrigione eventoVaiInPrigione){}

    default void handleEvent(TerminaTurno terminaTurno){}

    default void handleEvent(VendiProprieta vendiProprieta){}

    default void handleEvent(EventoAvviaAsta EventoAvviaAsta){}

    default void handleEvent(EventoTerminaAsta eventoTerminaAsta){}
}
