package com.newmonopoly.newmonopoly;

import com.newmonopoly.newmonopoly.model.gamer.Banconota;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BanconotaTest {
    private Banconota banconota;

    @BeforeEach
    public void setUp() { banconota = new Banconota(500, 2); }

    @Test
    void testGetValore() {
        assertEquals(500, banconota.getValore());
    }

    @Test
    void testGetQuantita() {
        assertEquals(2, banconota.getQuantita());
    }

    @Test
    void testsModificaQuantita() {
        banconota.modificaQuantita(-2);
        assertEquals(0, banconota.getQuantita());
        banconota.modificaQuantita(3);
        assertEquals(3,banconota.getQuantita());
    }
}
