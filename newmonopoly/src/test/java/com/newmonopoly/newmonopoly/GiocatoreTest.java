package com.newmonopoly.newmonopoly;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada.Colore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

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

    // @Test
    // void testPayExactAmount() {
    //     int importoDaPagare = giocatore.getSaldo();
    //     giocatore.pay(importoDaPagare);
    //     assertEquals(0, giocatore.getSaldo(), "Il saldo dovrebbe essere 0 dopo aver pagato l'intero importo.");
    // }

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

    // @Test
    // void testControlloLogicaPay() {
    //     // Pay 686 (500 + 100 + 50 + 20 + 10 + 5 + 1)
    //     giocatore.pay(686);
    //     assertEquals(1, giocatore.getBanconoteDaCinquecento());
    //     assertEquals(3, giocatore.getBanconoteDaCento());
    //     assertEquals(0, giocatore.getBanconoteDaCinquanta());
    //     assertEquals(0, giocatore.getBanconoteDaVenti());
    //     assertEquals(0, giocatore.getBanconoteDaDieci());
    //     assertEquals(0, giocatore.getBanconoteDaCinque());
    //     assertEquals(4, giocatore.getBanconoteDaUno());
    // }

    @Test
    void testCambioBanconoteCorrettoConResto() {
        giocatore.pay(120);
        assertEquals(1, giocatore.getBanconoteDaCinquecento()); 
        assertEquals(7, giocatore.getBanconoteDaCento());      
        assertEquals(2, giocatore.getBanconoteDaCinquanta());  
        assertEquals(2, giocatore.getBanconoteDaVenti()); 
        assertEquals(2, giocatore.getBanconoteDaDieci());  
        assertEquals(1, giocatore.getBanconoteDaCinque());     
        assertEquals(5, giocatore.getBanconoteDaUno());        
    }

    @Test
    void testCambioBanconoteCorrettoConResto2() {
        giocatore.pay(4);
        assertEquals(2, giocatore.getBanconoteDaCinquecento()); 
        assertEquals(4, giocatore.getBanconoteDaCento());      
        assertEquals(1, giocatore.getBanconoteDaCinquanta());  
        assertEquals(1, giocatore.getBanconoteDaVenti());   
        assertEquals(1, giocatore.getBanconoteDaDieci());  
        assertEquals(0, giocatore.getBanconoteDaCinque());  
        assertEquals(6, giocatore.getBanconoteDaUno());      
    }




    @Test
    void testPossiedeTutteLeProprietaDelColore() {
        ArrayList<Integer> affitti = new ArrayList<>(Arrays.asList(50, 250, 750, 925, 1100));
        Strada strada1 = new Strada("Viale Monterosa", null, 220, 18, 110, affitti, 150, 200, Colore.ROSSO);
        Strada strada2 = new Strada("Via Verdi", null, 120, 8, 60, affitti, 50, 100, Colore.ROSSO);
        Strada strada3 = new Strada("Corso Raffaello", null, 350, 35, 175, affitti, 200, 300, Colore.ROSSO);
        
        Giocatore giocatore = new Giocatore("Test");
        giocatore.aggiungiProprieta(strada1);
        giocatore.aggiungiProprieta(strada2);
        giocatore.aggiungiProprieta(strada3);
        
        assertTrue(giocatore.possiedeTutteLeProprietaDelColore(Colore.ROSSO), 
            "Il giocatore dovrebbe possedere tutte le proprietà del colore ROSSO.");
    }

    @Test
    void testNonPossiedeTutteLeProprietaDelColore() {
        ArrayList<Integer> affitti = new ArrayList<>(Arrays.asList(50, 250, 750, 925, 1100));
        Strada strada1 = new Strada("Viale Monterosa", null, 220, 18, 110, affitti, 150, 200, Colore.ROSSO);
        Strada strada2 = new Strada("Via Verdi", null, 120, 8, 60, affitti, 50, 100, Colore.ROSSO);
        Strada strada3 = new Strada("Corso Raffaello", null, 350, 35, 175, affitti, 200, 300, Colore.VERDE);
        
        Giocatore giocatore = new Giocatore("Test");
        giocatore.aggiungiProprieta(strada1);
        giocatore.aggiungiProprieta(strada2);
        giocatore.aggiungiProprieta(strada3);
        
        assertFalse(giocatore.possiedeTutteLeProprietaDelColore(Colore.ROSSO), 
            "Il giocatore non dovrebbe possedere tutte le proprietà del colore ROSSO.");
    }

}

