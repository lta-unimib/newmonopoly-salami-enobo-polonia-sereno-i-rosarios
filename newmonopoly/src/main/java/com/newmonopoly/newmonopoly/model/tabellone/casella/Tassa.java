package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = TassaLusso.class, name = "Tassa di Lusso"),
    @JsonSubTypes.Type(value = TassaOrdinaria.class, name = "Tassa Patrimoniale")
})
public abstract class Tassa extends Casella {

    @Getter
    protected int importo;

    protected Tassa(String nome, int importo) {
        super(nome);
        this.importo = importo;
    }

    public void economiaCasuale(float random) {
        importo = (int) Math.floor(getImporto()*random);
    }

    public int getImporto() {
        return importo;
    }
}
