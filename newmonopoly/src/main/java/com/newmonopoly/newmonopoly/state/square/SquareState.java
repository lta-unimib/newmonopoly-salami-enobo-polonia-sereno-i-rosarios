package com.newmonopoly.newmonopoly.state.square;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.eventi.casella.PassaggioVuoto;
import com.newmonopoly.newmonopoly.eventi.casella.Ricevi;
import com.newmonopoly.newmonopoly.eventi.gamer.*;


import java.io.Serializable;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PurchasedSociety.class, name = "SocietaAcquistata"),
        @JsonSubTypes.Type(value = MortgagedSociety.class, name = "SocietaIpotecata"),
        @JsonSubTypes.Type(value = UnsoldSocietyState.class, name = "SocietaNonAcquistata"),
        @JsonSubTypes.Type(value = ImprevistoState.class, name = "StatoImprevisto"),
        @JsonSubTypes.Type(value = ParkingState.class, name = "StatoParcheggio"),
        @JsonSubTypes.Type(value = JailState.class, name = "StatoPrigione"),
        @JsonSubTypes.Type(value = ProbabilitaState.class, name = "StatoProbabilita"),
        @JsonSubTypes.Type(value = TaxState.class, name = "StatoTassa"),
        @JsonSubTypes.Type(value = GoToJailState.class, name = "StatoVaiInPrigione"),
        @JsonSubTypes.Type(value = ViaState.class, name = "StatoVia"),
        @JsonSubTypes.Type(value = PurchasedStation.class, name = "StazioneAcquistata"),
        @JsonSubTypes.Type(value = MortgagedStation.class, name = "StazioneIpotecata"),
        @JsonSubTypes.Type(value = UnsoldStationState.class, name = "StazioneNonAcquistata"),
        @JsonSubTypes.Type(value = PurchasedStreetState.class, name = "TerrenoAcquistato"),
        @JsonSubTypes.Type(value = MortgagedStreet.class, name = "TerrenoIpotecato"),
        @JsonSubTypes.Type(value = UnsoldStreetState.class, name = "TerrenoNonAcquistato")
})

public interface SquareState extends Serializable {
    @JsonProperty("type")
    default String getTipo(){
        return getClass().getSimpleName();
    }

    default EventoCasella arrivo() {
        return PassaggioVuoto.builder().build();
    }

    default EventoCasella passaggio() {
        return PassaggioVuoto.builder().build();
    }

    default void handleEvent(AcquistaProprieta acquistaProprieta) {}

    default void handleEvent(EntraInPartita entraInPartita) {}

    default void handleEvent(EventoIpoteca eventoIpoteca) {}

    default void handleEvent(DowngradaTerreno downgradaTerreno) {}

    default void handleEvent(UpgradaTerreno upgradaTerreno) {}

    default void handleEvent(EventoLanciaDadi eventoLanciaDadi) {}

    default void handleEvent(EventoOfferta eventoOfferta){}

    default void handleEvent(EventoPaga eventoPaga){}

    default void handleEvent(EventoVaiInPrigione eventoVaiInPrigione){}

    default void handleEvent(TerminaTurno terminaTurno){}

    default void handleEvent(VendiProprieta vendiProprieta){}

    default void handleEvent(EventoAvviaAsta eventoAvviaAsta){}

    default void handleEvent(EventoTerminaAsta eventoTerminaAsta){}
}
