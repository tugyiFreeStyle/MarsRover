package com.hepsiburada.marsrover.domain.controls.left;

import com.hepsiburada.marsrover.domain.RoverDirection;
import com.hepsiburada.marsrover.domain.shared.Strategy;

import java.util.HashMap;
import java.util.Map;

public class LeftStrategyContext {
    private static final Map<RoverDirection, Strategy<RoverDirection>> strategies = new HashMap<>();

    static {
        strategies.put(RoverDirection.N, new LeftNorthStrategy());

        strategies.put(RoverDirection.E, new LeftEastStrategy());

        strategies.put(RoverDirection.W, new LeftWestStrategy());

        strategies.put(RoverDirection.S, new LeftSouthStrategy());
    }

    public static RoverDirection apply(RoverDirection roverDirection) {
        return strategies.get(roverDirection).find(roverDirection);
    }

}
