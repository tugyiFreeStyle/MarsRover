package com.hepsiburada.marsrover.application;

import com.hepsiburada.marsrover.domain.Plateau;
import com.hepsiburada.marsrover.domain.Rover;

public interface RoverService {

    Rover.Result control(Plateau plateau, Rover rover, String args);
}
