package com.newmonopoly.newmonopoly;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import com.newmonopoly.newmonopoly.model.tabellone.casella.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Strada.Colore;
import com.newmonopoly.newmonopoly.model.transazioni.PagamentiGiocatore;

public class PagameniGiocatoretTest {
   /* private PagamentiGiocatore pagamentiGiocatore;
    private Giocatore giocatore;
    private Giocatore giocatore2;
    private Strada strada;
    private Strada strada2;
    private Stazione stazione;
    private Societa societa;
    private Tasse tassa;

    @BeforeEach
    public void setUp() {
        pagamentiGiocatore = new PagamentiGiocatore();
        giocatore = new Giocatore("Giocatore 1");
        giocatore2 = new Giocatore("Giocatore 2");
        ArrayList<Integer> affitti = new ArrayList<>();
        affitti.add(25);
        affitti.add(50);
        affitti.add(150);
        affitti.add(450);
        affitti.add(625);
        affitti.add(750);
        //strada = new Strada("Via Roma", giocatore2, 140, 70,affitti , 100, 100, Colore.VERDE);
        //strada2 = new Strada("Viale Accademia", null, 140, 70,affitti , 100, 100, Colore.VIOLA);
        //stazione = new Stazione("Stazione Nord", giocatore2, 200,100,25 );
        //societa = new Societa("Società elettrica", giocatore2, 150, 75, 50);
        tassa = new TassaLusso();
    }

     @Test
    void testCalcolaAffittoStrada() {
        assertEquals(25, pagamentiGiocatore.calcolaAffitto(strada));
        System.out.println("saldo senza casa: " + giocatore2.getSaldo());
        strada.aggiungiEdificio();
        System.out.println("saldo dopo prima casa: " + giocatore2.getSaldo());
        assertEquals(1, strada.getNumCase());
        assertEquals(50, pagamentiGiocatore.calcolaAffitto(strada));
        strada.aggiungiEdificio();
        System.out.println("saldo dopo seconda casa: " + giocatore2.getSaldo());
        strada.aggiungiEdificio();
        System.out.println("saldo dopo terza casa: " + giocatore2.getSaldo());
        assertEquals(450, pagamentiGiocatore.calcolaAffitto(strada));
        strada.aggiungiEdificio();
        System.out.println("saldo dopo quarta casa " + giocatore2.getSaldo());
        System.out.println("pezzi da 100: "+giocatore2.getBanconoteDaCento());
        System.out.println("pezzi da 500; "+giocatore2.getBanconoteDaCinquecento());
       // strada.aggiungiEdificio();
       // assertTrue(strada.hasAlbergo());
       // assertEquals(750, pagamentiGiocatore.calcolaAffitto(strada));
    }

    @Test
    void testCalcolaAffittoStazione() {
        assertEquals(25, pagamentiGiocatore.calcolaAffitto(stazione));
    }

    @Test
    void testCalcolaAffittoSocieta() {
        assertEquals(50, pagamentiGiocatore.calcolaAffitto(societa));
    }

    @Test
    void testCalcolaTassa() {
        assertEquals(200, pagamentiGiocatore.calcolaTassa(tassa));
    }

      @Test
    void testAcquistoProprieta() {
        pagamentiGiocatore.acquistaProprieta(strada, giocatore);
        assertEquals(giocatore, strada.getProprietario());
    }

    @Test
void testAcquistaProprietaSenzaSaldo() {
    int saldoIniziale = giocatore.getSaldo();
    int costoStrada = strada2.getCosto();
    giocatore.pay(saldoIniziale - 20);  
    pagamentiGiocatore.acquistaProprieta(strada2, giocatore);
    assertEquals(giocatore.getSaldo(), 20); 
    assertNull(strada2.getProprietario());  
}


    @Test
    void testPagaAffittoStrada() {
        int saldoIniziale = giocatore.getSaldo();
        int affitto = strada.getAffitto();
        pagamentiGiocatore.pagaAffitto(strada, giocatore);
        assertEquals(giocatore.getSaldo(), saldoIniziale - affitto);  
    }

    @Test
    void testPagaTassa() {
        int saldoIniziale = giocatore.getSaldo();
        pagamentiGiocatore.pagaTassa(tassa, giocatore);
        assertEquals(giocatore.getSaldo(), saldoIniziale - pagamentiGiocatore.calcolaTassa(tassa)); 
    }    

    @Test
    void testPagaAffittoSocieta() {
        int saldoIniziale = giocatore.getSaldo();
        int affitto = societa.getAffitto();
        pagamentiGiocatore.pagaAffitto(societa, giocatore);
        assertEquals(giocatore.getSaldo(), saldoIniziale - affitto); 
    }

    @Test
    void testPagaAffittoStazione() {
        int saldoIniziale = giocatore.getSaldo();
        int affitto = stazione.getAffitto();
        pagamentiGiocatore.pagaAffitto(stazione, giocatore);
        assertEquals(giocatore.getSaldo(), saldoIniziale - affitto); 
    }*/
}
