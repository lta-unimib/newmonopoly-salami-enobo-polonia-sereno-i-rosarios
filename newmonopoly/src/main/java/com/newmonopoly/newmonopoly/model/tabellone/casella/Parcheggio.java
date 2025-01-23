package com.newmonopoly.newmonopoly.model.tabellone.casella;

import com.newmonopoly.newmonopoly.state.square.ParkingState;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Parcheggio extends Casella {

    protected Parcheggio(){
        stato = ParkingState.builder().parcheggio(this).build();
    }

}
