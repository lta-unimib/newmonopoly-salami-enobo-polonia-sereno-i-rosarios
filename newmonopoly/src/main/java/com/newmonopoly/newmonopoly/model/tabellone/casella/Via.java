package com.newmonopoly.newmonopoly.model.tabellone.casella;
import com.newmonopoly.newmonopoly.state.square.ViaState;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Via extends Casella {

    @Builder.Default
    private int val = 200;

    public Via(){
        state = ViaState.builder().via(this).build();
        val = 200;
    }
}