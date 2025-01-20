package com.newmonopoly.newmonopoly;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

import com.newmonopoly.newmonopoly.model.tabellone.casella.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada.Colore;
import com.newmonopoly.newmonopoly.model.transazioni.PagamentiGiocatore;

public class PagamentiGiocatoreTest {

   private PagamentiGiocatore pagamentiGiocatore;
    private Giocatore giocatore;
    private Giocatore giocatore2;
    private Strada vialeMonterosa;
    private Strada viaVerdi;
    private Strada corsoRaffaello;
    private Stazione stazione;
    private Societa societa;
    private TassaLusso tassa;

    @BeforeEach
    public void setUp() { // brava cazzo
       pagamentiGiocatore = new PagamentiGiocatore();
        giocatore = new Giocatore("Giocatore 1");
        giocatore2 = new Giocatore("Giocatore 2");
        ArrayList<Integer> affittiVialeMonterosa = new ArrayList<>(Arrays.asList(50, 250, 750, 925, 1100));
        ArrayList<Integer> affittiViaVerdi = new ArrayList<>(Arrays.asList(30, 150, 450, 625, 750));
        ArrayList<Integer> affittiCorsoRaffaello = new ArrayList<>(Arrays.asList(90, 400, 1000, 1200, 1400));

        vialeMonterosa = new Strada("Viale Monterosa", null, 220, 18, 110, affittiVialeMonterosa, 150, 200, Colore.ROSSO);
        viaVerdi = new Strada("Via Verdi", null, 120, 8, 60, affittiViaVerdi, 50, 100, Colore.VERDE);
        corsoRaffaello = new Strada("Corso Raffaello", null, 350, 35, 175, affittiCorsoRaffaello, 200, 300, Colore.VIOLA);
        stazione = new Stazione("Stazione Nord", giocatore2, 200, 100, 25);
        societa = new Societa("Società elettrica", giocatore2, 150, 75, 50);
        tassa = new TassaLusso();
    }

 @Test
    void testAcquistoProprieta() {
        pagamentiGiocatore.acquistaProprieta(vialeMonterosa, giocatore);
        assertEquals(giocatore, vialeMonterosa.getProprietario());
        assertTrue(giocatore.getProprieta().contains(vialeMonterosa));
    }

      @Test
    void testAcquistaProprietaSenzaSaldo() {
        giocatore.pay(giocatore.getSaldo() - 20);  
        pagamentiGiocatore.acquistaProprieta(viaVerdi, giocatore);
        assertEquals(20, giocatore.getSaldo());
        assertNull(viaVerdi.getProprietario());
    }

    @Test
    void testPagaAffittoStrada() {
        vialeMonterosa.setProprietario(giocatore2);
        int saldoIniziale = giocatore.getSaldo();
        pagamentiGiocatore.pagaAffitto(vialeMonterosa, giocatore);
        assertEquals(saldoIniziale - vialeMonterosa.getAffitto(), giocatore.getSaldo());
    }

      @Test
    void testPagaTassa() {
        int saldoIniziale = giocatore.getSaldo();
        pagamentiGiocatore.pagaTassa(tassa, giocatore);
        assertEquals(saldoIniziale - pagamentiGiocatore.calcolaTassa(tassa), giocatore.getSaldo());
    }



}
