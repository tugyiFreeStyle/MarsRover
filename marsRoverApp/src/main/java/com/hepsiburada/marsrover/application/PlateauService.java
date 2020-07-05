package com.hepsiburada.marsrover.application;

import com.hepsiburada.marsrover.domain.Plateau;
import com.hepsiburada.marsrover.domain.Rover;

public interface PlateauService {

    Plateau create (String args);

    Rover deploy(Plateau plateau, String args);
}
