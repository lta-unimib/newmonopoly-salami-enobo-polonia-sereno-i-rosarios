package com.newmonopoly.newmonopoly;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Proprieta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static com.newmonopoly.newmonopoly.model.transazioni.Banca.getBanca;

class BancaTest {

    private Giocatore giocatore1;
    private Giocatore giocatore2;
    private Proprieta proprieta;

    @BeforeEach
    public void setUp() {
        giocatore1 = new Giocatore("user");
        giocatore2 = new Giocatore("prova");
        proprieta = new Proprieta("proprieta", null, 130, 70, 25);
    }

    @Test
    void testAcquistaProprieta() {
        getBanca().acquistaProprieta(proprieta, giocatore1);
        assertEquals(1360, giocatore1.getSaldo());
        assertEquals("user", proprieta.getProprietario().getNome());
    }

    @Test
    void testPagaAffitto() {
        getBanca().acquistaProprieta(proprieta, giocatore1);
        getBanca().pagaAffitto(proprieta, giocatore2);
        assertEquals(1465, giocatore2.getSaldo());
    }

    @Test
    void testipotecaProprieta() {
        getBanca().acquistaProprieta(proprieta, giocatore1);
        getBanca().ipotecaProprieta(proprieta);
        assertEquals(1430, giocatore1.getSaldo());
    }

    @Test
    void testVendiProprieta() {
        getBanca().acquistaProprieta(proprieta, giocatore1);
        getBanca().vendiProprieta(150, proprieta, giocatore2);
        assertEquals(1510, giocatore1.getSaldo());
        assertEquals(1340, giocatore2.getSaldo());
        assertEquals("prova", proprieta.getProprietario().getNome());
    }

    @Test
    void testPagaTassa() {
        getBanca().pagaTassa(210, giocatore1);
        assertEquals(1280, giocatore1.getSaldo());
    }


}
