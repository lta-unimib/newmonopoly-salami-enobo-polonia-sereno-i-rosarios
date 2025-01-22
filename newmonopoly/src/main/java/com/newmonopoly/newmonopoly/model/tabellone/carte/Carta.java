package com.newmonopoly.newmonopoly.model.tabellone.carte;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.newmonopoly.newmonopoly.interfacce.ITabellone;
import com.newmonopoly.newmonopoly.model.gamer.Token;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

// implementazione con file .json

@Data
@SuperBuilder
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CartaDenaro.class, name = "CartaDenaro"),
        @JsonSubTypes.Type(value = CartaPosizione.class, name = "CartaPosizione"),
        @JsonSubTypes.Type(value = CartaScarcerazione.class, name = "CartaScarcerazione"),
        @JsonSubTypes.Type(value = CartaSpostamento.class, name = "CartaSpostamento"),
})
public abstract class Carta implements Serializable {

    protected String testo;
    @JsonIgnore
    protected ITabellone tabellone;

    protected Carta(){}

    @JsonProperty("type")
    public String getTipo() {
        return getClass().getSimpleName();
    }

    public abstract boolean effettoCarta (Token token);

    public void economiaCasuale(float m){ }

}
