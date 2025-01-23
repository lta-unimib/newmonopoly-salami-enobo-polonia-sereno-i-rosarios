package com.newmonopoly.newmonopoly.controller;

import lombok.Data;
import lombok.Builder;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import com.newmonopoly.newmonopoly.model.AbstractGame;


@Data
@Builder
public class Broker {
    private final SimpMessagingTemplate t;
    private static Broker instance;

    public static Broker getBroker() {
        return instance;
    }

    public synchronized void aggiorna(AbstractGame game) {
        t.convertAndSend("/topic/partita", game);
    }
    
}