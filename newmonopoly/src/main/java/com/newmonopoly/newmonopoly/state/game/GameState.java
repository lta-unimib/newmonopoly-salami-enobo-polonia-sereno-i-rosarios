package com.newmonopoly.newmonopoly.state.game;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.newmonopoly.newmonopoly.eventi.*;
import com.newmonopoly.newmonopoly.model.AbstractGame;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = LobbyState.class, name = "Lobby")
})
public abstract class GameState implements Serializable{
    
    @JsonProperty("type")
    public String getTipo() {
        return getClass().getSimpleName();
    }
    
    @JsonIgnore
    AbstractGame abstractGame;

    protected GameState() {}

    public void handleEvent(Join join){}

    public void handleEvent(){}

    public void handleEvent(AcquistaProprieta acquistaProprieta) {

    }

}