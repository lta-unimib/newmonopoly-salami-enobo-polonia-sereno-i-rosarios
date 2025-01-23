package com.newmonopoly.newmonopoly;

import com.newmonopoly.newmonopoly.model.gamer.Banconota;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada.Colore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GiocatoreTest {

    private Giocatore giocatore;

    @BeforeEach
    void setUp() {
        Map<Integer, Banconota> banconote = new HashMap<>();
        banconote.put(500, new Banconota(500, 2));
        banconote.put(100, new Banconota(100, 5));
        banconote.put(50, new Banconota(50, 10));
        giocatore = Giocatore.builder()
                .nome("Player1")
                .banconote(banconote)
                .puntiFedelta(3)
                .build();
    }

    @Test
    void testRicevi() {
        giocatore.ricevi(150);
        assertEquals(11, giocatore.getBanconoteDaCinquanta());
    }

    @Test
    void testPay() {
        giocatore.pay(550);
        assertEquals(1, giocatore.getBanconoteDaCinquecento());
        assertEquals(6, giocatore.getBanconoteDaCento());
        assertEquals(10, giocatore.getBanconoteDaCinquanta());
        assertEquals(0, giocatore.getPuntiFedelta());
    }

    @Test
    void testAggiungiPuntiFedelta() {
        giocatore.aggiungiPuntiFedelta(200);
        assertEquals(7, giocatore.getPuntiFedelta());
    }

    
    @Test
    void testPossiedeTutteLeProprietaDelColore() {
        Strada strada1 = Strada.builder()
        .nome("Viale dei Giardini")
        .colore(Strada.Colore.green)
        .costoCasa(200)
        .costoAlbergo(500)
        .albergo(false)
        .numCase(0)
        .build();
        Strada strada2 = Strada.builder().nome("Viale dei Giardini")
        .colore(Strada.Colore.green)
        .costoCasa(200)
        .costoAlbergo(500)
        .albergo(false)
        .numCase(0)
        .build();
        giocatore.aggiungiProprieta(strada1);
        giocatore.aggiungiProprieta(strada2);
        assertTrue(giocatore.possiedeTutteLeProprietaDelColore(Colore.green));
        assertFalse(giocatore.possiedeTutteLeProprietaDelColore(Colore.blue));
    }


    @Test
    void testGetSaldo() {
        assertEquals(2000, giocatore.getSaldo());
    }

    @Test
    void testAggiungiProprieta() {
     Strada strada = Strada.builder()
        .nome("Viale dei Giardini")
        .colore(Strada.Colore.green)
        .costoCasa(200)
        .costoAlbergo(500)
        .albergo(false)
        .numCase(0)
        .build();
        giocatore.aggiungiProprieta(strada);

        assertTrue(giocatore.getProprieta().contains(strada));
        assertEquals(1, giocatore.getProprieta().size());
    }

    @Test
    void testAcquistaProprieta() {
        Strada strada = Strada.builder()
        .nome("Viale dei Giardini")
        .colore(Strada.Colore.green)
        .costoCasa(200)
        .costoAlbergo(500)
        .albergo(false)
        .numCase(0)
        .build();
        Giocatore venditore = Giocatore.builder()
                .nome("Venditore")
                .banconote(new HashMap<>())
                .build();

        giocatore.acquistaProprieta(strada, venditore, 300);

        assertTrue(giocatore.getProprieta().contains(strada));
        assertFalse(venditore.getProprieta().contains(strada));
        assertEquals(1850, giocatore.getSaldo());
    }
}
