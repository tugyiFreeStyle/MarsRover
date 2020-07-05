package com.hepsiburada.marsrover.domain.controls.move;

import com.hepsiburada.marsrover.domain.RoverPosition;
import com.hepsiburada.marsrover.domain.X;
import com.hepsiburada.marsrover.domain.shared.Strategy;

public class MoveWestStrategy implements Strategy<RoverPosition> {

    @Override
    public RoverPosition find(RoverPosition roverPosition) {

        return new RoverPosition(new X(roverPosition.getX().getValue()-1), roverPosition.getY());
    }
}
