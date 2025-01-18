package com.newmonopoly.newmonopoly;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GiocatoreTest {

    private Giocatore giocatore;

    @BeforeEach
    public void setUp() {
        giocatore = new Giocatore("User");
    }

    @Test
    void testGetSaldo() {
        assertEquals(1490, giocatore.getSaldo());
    }

    @Test
    void testPaySuccess() {
        int saldoIniziale = giocatore.getSaldo();
        int importoDaPagare = 150;
        giocatore.pay(importoDaPagare);
        assertEquals(saldoIniziale - importoDaPagare, giocatore.getSaldo(), 
            "Il saldo dovrebbe essere ridotto correttamente.");
    }

    @Test
    void testPayExactAmount() {
        int importoDaPagare = giocatore.getSaldo();
        giocatore.pay(importoDaPagare);
        assertEquals(0, giocatore.getSaldo(), "Il saldo dovrebbe essere 0 dopo aver pagato l'intero importo.");
    }

    @Test
    void testPayInsufficientSaldo() {
        int importoDaPagare = giocatore.getSaldo() + 100;  // Supera il saldo disponibile
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            giocatore.pay(importoDaPagare);
        });
        assertEquals("Saldo insufficiente per effettuare il pagamento.", exception.getMessage(), 
            "Dovrebbe essere lanciata un'eccezione per saldo insufficiente.");
    }

    @Test
    void testRicevi() {
        int saldoIniziale = giocatore.getSaldo();
        // Ricevi 1350
        giocatore.ricevi(1350);
        assertEquals(saldoIniziale + 1350, giocatore.getSaldo());
    }

    @Test
    void testControlloLogicaRicevi() {
        // Ricevi 686 (500 + 100 + 50 + 20 + 10 + 5 + 1)
        giocatore.ricevi(686);
        assertEquals(3, giocatore.getBanconoteDaCinquecento());
        assertEquals(5, giocatore.getBanconoteDaCento());
        assertEquals(2, giocatore.getBanconoteDaCinquanta());
        assertEquals(2, giocatore.getBanconoteDaVenti());
        assertEquals(2, giocatore.getBanconoteDaDieci());
        assertEquals(2, giocatore.getBanconoteDaCinque());
        assertEquals(6, giocatore.getBanconoteDaUno());
    }

    @Test
    void testControlloLogicaPay() {
        // Pay 686 (500 + 100 + 50 + 20 + 10 + 5 + 1)
        giocatore.pay(686);
        assertEquals(1, giocatore.getBanconoteDaCinquecento());
        assertEquals(3, giocatore.getBanconoteDaCento());
        assertEquals(0, giocatore.getBanconoteDaCinquanta());
        assertEquals(0, giocatore.getBanconoteDaVenti());
        assertEquals(0, giocatore.getBanconoteDaDieci());
        assertEquals(0, giocatore.getBanconoteDaCinque());
        assertEquals(4, giocatore.getBanconoteDaUno());
    }

}

