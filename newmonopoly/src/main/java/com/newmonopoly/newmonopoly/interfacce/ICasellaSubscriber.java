package com.newmonopoly.newmonopoly.interfacce;

import com.newmonopoly.newmonopoly.eventi.casella.EventoCasella;

import java.io.Serializable;

public interface ICasellaSubscriber extends Serializable {

    void casellaHandleEvent(EventoCasella evento);

}
