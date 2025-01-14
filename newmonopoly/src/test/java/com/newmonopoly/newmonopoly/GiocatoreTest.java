package com.newmonopoly.newmonopoly;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GiocatoreTest {

    private Giocatore giocatore;

    @BeforeEach
    public void setUp() {
        giocatore = new Giocatore("Mario");
    }

    @Test
    public void testPaySuccess() {
        int saldoIniziale = giocatore.getSaldo();
        int importoDaPagare = 150;
        giocatore.pay(importoDaPagare);
        assertEquals(saldoIniziale - importoDaPagare, giocatore.getSaldo(), 
            "Il saldo dovrebbe essere ridotto correttamente.");
    }

    @Test
    public void testPayExactAmount() {
        int importoDaPagare = giocatore.getSaldo();
        giocatore.pay(importoDaPagare);
        assertEquals(0, giocatore.getSaldo(), "Il saldo dovrebbe essere 0 dopo aver pagato l'intero importo.");
    }

    @Test
    public void testPayInsufficientSaldo() {
        int importoDaPagare = giocatore.getSaldo() + 100;  // Supera il saldo disponibile
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            giocatore.pay(importoDaPagare);
        });
        assertEquals("Saldo insufficiente per effettuare il pagamento.", exception.getMessage(), 
            "Dovrebbe essere lanciata un'eccezione per saldo insufficiente.");
    }

    @Test
    public void testRicevi() {
        Giocatore giocatore = new Giocatore("Mario");
        int saldoIniziale = giocatore.getSaldo();
        // Ricevi 1350 (500x2, 100x4, 50x1, 20x1, 10x1, 5x1, 1x5)
        giocatore.ricevi(1350);
        assertEquals(saldoIniziale + 1350, giocatore.getSaldo());
    }
}

