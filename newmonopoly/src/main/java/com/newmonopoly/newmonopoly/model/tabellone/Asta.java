package com.newmonopoly.newmonopoly.model.tabellone;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
public class Asta implements Serializable {
    private int offertaAttuale;
    private Giocatore miglioreOfferente;
    private Proprieta proprieta;

    public void offri(Giocatore g, int offerta) {
        if (offerta <= this.getOffertaAttuale()) {
            throw new IllegalArgumentException("L'offerta deve essere maggiore dell'offerta attuale.");
        }
        if (g.getSaldo() < offerta) {
            throw new IllegalArgumentException("Il saldo del giocatore non è sufficiente a coprire l'offerta.");
        }

        this.setMiglioreOfferente(g);
        this.setOffertaAttuale(offerta);
    }
}
