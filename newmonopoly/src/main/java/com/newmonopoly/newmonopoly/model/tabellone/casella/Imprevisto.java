package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Imprevisto extends Casella{

    public Imprevisto() {
        super("Imprevisti");
    }

    @JsonCreator
    public Imprevisto(@JsonProperty("nome") String nome) {
        super(nome);  // Se vuoi passare il nome al costruttore della classe base
    }


}
