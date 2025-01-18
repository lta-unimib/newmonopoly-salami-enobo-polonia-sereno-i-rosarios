package com.newmonopoly.newmonopoly.model.tabellone.casella;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;


@SuperBuilder

public abstract class Casella implements Serializable {

    @Serial
    private static final long serialVersionUID = 2405172041951071807L;

    @Getter @Setter
    private String nome;

    protected Casella (String nome) {
        this.nome = nome;
    }

    public void economiaCasuale(float random) {}

}
