package com.newmonopoly.newmonopoly.state.game;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.newmonopoly.newmonopoly.eventi.casella.*;
import com.newmonopoly.newmonopoly.eventi.gamer.*;
import com.newmonopoly.newmonopoly.model.AbstractGame;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = LobbyState.class, name = "Lobby")
})
public abstract class GameState implements Serializable{
    
    @JsonIgnore
    AbstractGame game;

    protected GameState() {}

    @JsonProperty("type")
    public String getTipo() {
        return getClass().getSimpleName();
    }

    public void handleEvent(EntraInPartita entraInPartita){}

    public void handleEvent(){}

    public void handleEvent(AcquistaProprieta acquistaProprieta) {}

    public void handleEvent(PagaAffitto pagaAffitto) {}

    public void handleEvent(Ricevi ricevi){}

    public void handleEvent(EventoIpoteca ipoteca) {}

    public void handleEvent(UpgradaTerreno upgradaTerreno) {}

    public void handleEvent(DowngradaTerreno downgradaTerreno) {}

    public void handleEvent(EventoLanciaDadi eventoLanciaDadi) {}

    public void handleEvent(EventoOfferta eventoOfferta){}

    public void handleEvent(EventoPaga eventoPaga){}

    public void handleEvent(EventoVaiInPrigione eventoVaiInPrigione){}

    public void handleEvent(TerminaTurno terminaTurno){}

    public void handleEvent(VendiProprieta vendiProprieta){}

    public void handleEvent(PassaggioVuoto passaggioVuoto) {}

    public void handleEvent(RequestPurchase requestPurchase) {}

    public void handleEvent(ArrestaGiocatore arrestaGiocatore) {}

    public void handleEvent(PescaImprevisto pescaImprevisto) {}

    public void handleEvent(PescaProbabilita pescaProbabilita) {}

    public void handleEvent(EventoAttesaLancioDadi eventoAttesaLancioDadi) {}

    public void handleEvent(EventoVaiInAttesaPrigione eventoVaiInAttesaPrigione) {}

    public void handleEvent(EventoAvviaAsta eventoAvviaAsta) {}

    public void handleEvent(EventoTerminaAsta eventoTerminaAsta) {}
}