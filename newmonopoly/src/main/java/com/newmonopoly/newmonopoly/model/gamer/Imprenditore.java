package com.newmonopoly.newmonopoly.model.gamer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.newmonopoly.newmonopoly.model.transazioni.IPagamenti;

import com.newmonopoly.newmonopoly.model.transazioni.PagamentiImprenditore;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Imprenditore extends Giocatore {
    @JsonIgnore
    @Builder.Default
    private transient IPagamenti strategiaCalcoloAffitto = new PagamentiImprenditore();
}