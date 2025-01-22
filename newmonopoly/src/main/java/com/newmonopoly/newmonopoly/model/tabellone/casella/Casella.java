package com.newmonopoly.newmonopoly.model.tabellone.casella;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

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
public abstract class Casella implements Serializable {

    @Serial
    private static final long serialVersionUID = 2405172041951071807L;

    @Getter @Setter
    protected int id;
    private String nome;
    protected SquareState stato;

    protected Casella (String nome) {
        this.nome = nome;
    }

    public void economiaCasuale(float random) {}

}
