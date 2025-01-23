package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;
import com.newmonopoly.newmonopoly.interfacce.ICasellaSubscriber;
import com.newmonopoly.newmonopoly.interfacce.ICasellaPublisher;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.newmonopoly.newmonopoly.state.square.SquareState;


@Data
@SuperBuilder
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Strada.class, name = "Strada"),
        @JsonSubTypes.Type(value = Societa.class, name = "Societa"),
        @JsonSubTypes.Type(value = Stazione.class, name = "Stazione"),
        @JsonSubTypes.Type(value = Via.class, name = "Via"),
        @JsonSubTypes.Type(value = Imprevisti.class, name = "Imprevisti"),
        @JsonSubTypes.Type(value = Probabilita.class, name = "Probabilita"),
        @JsonSubTypes.Type(value = Prigione.class, name = "Prigione"),
        @JsonSubTypes.Type(value = Parcheggio.class, name = "Parcheggio"),
        @JsonSubTypes.Type(value = Tassa.class, name = "Tassa"),
        @JsonSubTypes.Type(value = VaiInPrigione.class, name = "VaiInPrigione"),
})
public abstract class Casella implements Serializable, ICasellaPublisher {

    @Serial
    private static final long serialVersionUID = 2405172041951071807L;

    // @Getter @Setter
    protected int id;
    private String nome;

    @Builder.Default
    @JsonIgnore
    protected ArrayList<ICasellaSubscriber> subscribers = new ArrayList<>();
    protected SquareState state;

    protected Casella () {
        // this.nome = nome;
        subscribers = new ArrayList<>();
    }

    @JsonProperty("type")
    public String getTipo() {
        return getClass().getSimpleName();
    }

    public void economiaCasuale(float random) {}

    public void arrivo(Giocatore giocatore) {
        publishEvent(state.arrivo());
    }

    public void passaggio(Giocatore giocatore) {
        publishEvent(state.passaggio());
    }

    @Override
    public void publishEvent(EventoCasella eventoCasella) {
        subscribers.forEach(subscriber -> subscriber.casellaHandleEvent(eventoCasella));
    }

    @Override
    public void addEventListener(ICasellaSubscriber observer) {
        subscribers.add(observer);
    }

    @Override
    public void removeEventListener(ICasellaSubscriber observer) {
        subscribers.remove(observer);
    }


}
