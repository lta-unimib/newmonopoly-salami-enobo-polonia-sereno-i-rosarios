package com.newmonopoly.newmonopoly.interfacce;

import com.newmonopoly.newmonopoly.model.tabellone.casella.Casella;

import java.io.Serializable;

public interface ITabellone extends Serializable {

    void caselleCasuali();

    Casella getCasella(int numeroCasella);
}
