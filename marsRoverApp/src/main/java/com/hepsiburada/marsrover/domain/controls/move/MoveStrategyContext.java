package com.hepsiburada.marsrover.domain.controls.move;

import com.hepsiburada.marsrover.domain.RoverDirection;
import com.hepsiburada.marsrover.domain.RoverPosition;
import com.hepsiburada.marsrover.domain.shared.Strategy;

import java.util.HashMap;
import java.util.Map;

public class MoveStrategyContext {
    public static final Map<RoverDirection, Strategy<RoverPosition>> strategies = new HashMap<>();

    static {

        strategies.put(RoverDirection.N, new MoveNorthStrategy());

        strategies.put(RoverDirection.E, new MoveEastStrategy());

        strategies.put(RoverDirection.W, new MoveWestStrategy());

        strategies.put(RoverDirection.S, new MoveSouthStrategy());

    }

    public static RoverPosition apply(RoverPosition roverPosition, RoverDirection roverDirection) {
        return strategies.get(roverDirection).find(roverPosition);

    }
}
