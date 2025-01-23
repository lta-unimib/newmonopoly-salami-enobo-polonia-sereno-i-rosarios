package com.newmonopoly.newmonopoly.model.gamer;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Admin extends Giocatore{

    public Admin() {
        super(""); // chiama il costruttore della superclasse con un nome vuoto
    }
    
    public Admin (String nome) {
        super(nome);
    }
}
