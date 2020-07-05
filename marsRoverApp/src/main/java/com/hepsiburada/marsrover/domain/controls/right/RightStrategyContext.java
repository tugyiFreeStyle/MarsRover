package com.hepsiburada.marsrover.domain.controls.right;

import com.hepsiburada.marsrover.domain.RoverDirection;
import com.hepsiburada.marsrover.domain.shared.Strategy;

import java.util.HashMap;
import java.util.Map;

public class RightStrategyContext {

    private RightStrategyContext() {
    }

    private static final Map<RoverDirection, Strategy<RoverDirection>> strategies = new HashMap<>();

    static {

        strategies.put(RoverDirection.N, new RightNorthStrategy());

        strategies.put(RoverDirection.E, new RightEastStrategy());

        strategies.put(RoverDirection.W, new RightWestStrategy());

        strategies.put(RoverDirection.S, new RightSouthStrategy());
    }

    public static RoverDirection apply(RoverDirection roverDirection) {
        return strategies.get(roverDirection).find(roverDirection);
    }
}
