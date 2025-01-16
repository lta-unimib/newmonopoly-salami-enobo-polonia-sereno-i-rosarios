package com.newmonopoly.newmonopoly.model.tabellone;

import lombok.Getter;

public abstract class Tasse extends Casella {

        @Getter
        protected int importo;

        protected Tasse(String nome, int importo) {
            super(nome);
            this.importo = importo;
        }
}
