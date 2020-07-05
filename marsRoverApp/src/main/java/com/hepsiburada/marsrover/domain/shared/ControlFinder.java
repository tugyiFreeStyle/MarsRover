package com.hepsiburada.marsrover.domain.shared;

import com.hepsiburada.marsrover.domain.Rover;
import com.hepsiburada.marsrover.domain.RoverDirection;

public interface ControlFinder<TResult> {
    TResult get(Rover rover);
}
