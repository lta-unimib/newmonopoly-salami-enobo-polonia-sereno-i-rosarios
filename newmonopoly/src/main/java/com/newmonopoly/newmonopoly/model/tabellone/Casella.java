package com.newmonopoly.newmonopoly.model.tabellone;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public abstract class Casella implements Serializable {

    @Getter @Setter
    private String nome;

    public Casella (String nome) {
        this.nome = nome;
    }

}
