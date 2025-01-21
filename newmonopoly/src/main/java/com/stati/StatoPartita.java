package com.stati;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.newmonopoly.azioni.Join;
import com.newmonopoly.newmonopoly.model.AbstractGame;

import lombok.experimental.SuperBuilder;

@SuperBuilder
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Lobby.class, name = "Lobby")
})
public abstract class StatoPartita implements Serializable{
    
    @JsonProperty("type")
    public String getTipo() {
        return getClass().getSimpleName();
    }
    
    @JsonIgnore
    AbstractGame abstractGame;

    protected StatoPartita() {}

    public void esegui(Join join){}

    public void esegui(){}
   
}