package com.hepsiburada.marsrover.domain.controls.left;

import com.hepsiburada.marsrover.domain.Rover;
import com.hepsiburada.marsrover.domain.RoverDirection;
import com.hepsiburada.marsrover.domain.shared.ControlFinder;

public class LeftControlFinder implements ControlFinder<RoverDirection> {

    @Override
    public RoverDirection get(Rover rover) {
        return LeftStrategyContext.apply(rover.getRoverDirection());
    }
}
