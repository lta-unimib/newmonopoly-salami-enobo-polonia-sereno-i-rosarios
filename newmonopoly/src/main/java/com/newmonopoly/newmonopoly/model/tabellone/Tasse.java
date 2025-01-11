package com.newmonopoly.newmonopoly.model.tabellone;


import com.newmonopoly.newmonopoly.model.gamer.Token;
import lombok.Getter;

public abstract class Tasse extends Casella {

        @Getter
        protected int importo;

        public Tasse(String nome, int importo) {
            super(nome);
            this.importo = importo;
        }

        public abstract void applicaTassa(Token token);

}
