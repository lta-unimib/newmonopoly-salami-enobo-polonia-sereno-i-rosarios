package com.newmonopoly.newmonopoly;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.gamer.Token;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.newmonopoly.newmonopoly.model.tabellone.casella.Prigione.getPrigione;
import static org.junit.jupiter.api.Assertions.*;

import static com.newmonopoly.newmonopoly.model.tabellone.casella.VaiInPrigione.getVaiInPrigione;

class VaiInPrigioneTest {

    private Giocatore giocatore;
    private Token pedina;

    @BeforeEach
    public void setUp() {
        giocatore = new Giocatore("user");
        pedina = new Token(giocatore, 1111);
    }

    @Test
    void testArresto() {
        getVaiInPrigione().arresto(pedina);
        assertTrue(getPrigione().checkPrigioniero(pedina));
    }
}
