package com.hepsiburada.marsrover.domain.controls.left;

import com.hepsiburada.marsrover.domain.RoverDirection;
import com.hepsiburada.marsrover.domain.shared.Strategy;

public class LeftNorthStrategy implements Strategy<RoverDirection> {

    @Override
    public RoverDirection find(RoverDirection data) {
        return RoverDirection.W;
    }
}
