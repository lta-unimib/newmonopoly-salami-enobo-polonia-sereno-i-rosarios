package com.newmonopoly.newmonopoly.state.square;

import com.newmonopoly.newmonopoly.eventi.gamer.DowngradaTerreno;
import com.newmonopoly.newmonopoly.eventi.gamer.EventoIpoteca;
import com.newmonopoly.newmonopoly.eventi.gamer.UpgradaTerreno;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.slf4j.LoggerFactory;

@Data
@SuperBuilder
public class PurchasedStreetState extends StreetState {

    protected PurchasedStreetState() {}

    @Override
    public void handleEvent(EventoIpoteca ipoteca) {
        strada.getProprietario().ricevi(strada.getIpoteca());
        strada.setStato(
                MortgagedStreet
                        .builder()
                        .strada(strada)
                        .build());
    }

    @Override
    public void handleEvent(UpgradaTerreno upgradaTerreno) {
        try {
            strada.aggiungiEdificio();
        } catch (IllegalArgumentException e) {
            LoggerFactory.getLogger(PurchasedStreetState.class).error("Errore di modifica denaro");
            // Non è necessario gestire ulteriormente l'eccezione
        }
    }

    @Override
    public void handleEvent(DowngradaTerreno downgradaTerreno) {
        try {
            strada.rimuoviEdificio();
        } catch (IllegalArgumentException ignored){}
    }

}
