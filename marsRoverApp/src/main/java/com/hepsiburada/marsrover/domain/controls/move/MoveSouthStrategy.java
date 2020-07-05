package com.hepsiburada.marsrover.domain.controls.move;

import com.hepsiburada.marsrover.domain.RoverPosition;
import com.hepsiburada.marsrover.domain.Y;
import com.hepsiburada.marsrover.domain.shared.Strategy;

public class MoveSouthStrategy implements Strategy<RoverPosition> {


    @Override
    public RoverPosition find(RoverPosition roverPosition) {
        return new RoverPosition(roverPosition.getX(), new Y(roverPosition.getY().getValue() - 1));
    }
}
