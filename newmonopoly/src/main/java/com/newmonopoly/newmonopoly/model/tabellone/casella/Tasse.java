package com.newmonopoly.newmonopoly.model.tabellone.casella;

import lombok.Getter;

public abstract class Tasse extends Casella {

    @Getter
    protected int importo;

    protected Tasse(String nome, int importo) {
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
