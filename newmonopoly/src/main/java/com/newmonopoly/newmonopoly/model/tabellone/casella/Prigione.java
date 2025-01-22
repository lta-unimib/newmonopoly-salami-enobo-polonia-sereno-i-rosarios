package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.newmonopoly.newmonopoly.model.gamer.Token;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Prigione extends Casella implements Serializable {

    @Serial
    private static final long serialVersionUID = 2405172141950251807L;

    private static Prigione prigione = null;
    private int cauzione;

    private ArrayList<Token> prigionieri;

    @JsonCreator
    public Prigione() {
        super("Prigione");  // Se vuoi passare il nome al costruttore della classe base
        this.prigionieri = new ArrayList<Token>(6);
    }
    private Prigione (@JsonProperty("nome") String nome, @JsonProperty("cauzione") int cauzione) {
        super(nome);
        this.prigionieri = new ArrayList<Token>(6);
        this.cauzione = cauzione;
    }

    public static synchronized Prigione getPrigione() {
        if (prigione == null) {
            prigione = new Prigione();
        }
        return prigione;
    }

    public void nuovoPrigioniero(Token pedina){
        if(!checkPrigioniero(pedina)){
            this.prigionieri.add(pedina);
        }
    }

    public void rilascioPrigioniero(Token pedina){
        this.prigionieri.remove(pedina);
    }

    public boolean checkPrigioniero(Token pedina) {
        return this.prigionieri.contains(pedina);
    }

}
