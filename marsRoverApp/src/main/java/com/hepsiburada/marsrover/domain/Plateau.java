package com.hepsiburada.marsrover.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Plateau {
    private XBound xBound;
    private YBound yBound;
    private List<Rover> rovers = new ArrayList<>();

    public Plateau(XBound xBound, YBound yBound) {
        this.xBound = xBound;
        this.yBound = yBound;
    }

    public void deploy(Rover rover) {

        validateLocation(rover.getRoverPosition().getX().getValue(), rover.getRoverPosition().getY().getValue());
        rovers.add(rover);
    }

    private void validateLocation(int x, int y) {
        if (x > this.xBound.getValue()) throw new IllegalArgumentException(String.valueOf(x));

        if (y > this.yBound.getValue()) throw new IllegalArgumentException(String.valueOf(y));
    }
}
