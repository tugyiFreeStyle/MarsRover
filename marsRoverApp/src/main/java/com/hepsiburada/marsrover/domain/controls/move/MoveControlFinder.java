package com.hepsiburada.marsrover.domain.controls.move;

import com.hepsiburada.marsrover.domain.Rover;
import com.hepsiburada.marsrover.domain.RoverPosition;
import com.hepsiburada.marsrover.domain.shared.ControlFinder;

public class MoveControlFinder implements ControlFinder<RoverPosition> {

    @Override
    public RoverPosition get(Rover rover) {
        return MoveStrategyContext.apply(rover.getRoverPosition(), rover.getRoverDirection());
    }
}
