package com.newmonopoly.newmonopoly.interfacce;

import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;

public interface ICasellaPublisher {
    void publishEvent(EventoCasella evento);
    void addEventListener(ICasellaSubscriber subscriber);
    void removeEventListener(ICasellaSubscriber subscriber);
}