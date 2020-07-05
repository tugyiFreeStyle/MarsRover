package com.hepsiburada.marsrover.domain.controls.right;

import com.hepsiburada.marsrover.domain.RoverDirection;
import com.hepsiburada.marsrover.domain.shared.Strategy;

public class RightNorthStrategy implements Strategy<RoverDirection> {

    @Override
    public RoverDirection find(RoverDirection data) {
        return RoverDirection.E;
    }
}
