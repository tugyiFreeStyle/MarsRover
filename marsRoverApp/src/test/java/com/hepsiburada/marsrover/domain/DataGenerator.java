package com.hepsiburada.marsrover.domain;

public class DataGenerator {
    private DataGenerator() {
    }

    public static Rover generateRover(RoverDirection roverDirection) {
        return new Rover(new RoverId("1"), new RoverPosition(new X(1), new Y(2)), roverDirection);
    }

    public static Rover generateRover(RoverDirection currentRoverDirection, int currentXposition, int currentYposition) {
        return new Rover(new RoverId("1"), new RoverPosition(new X(currentXposition), new Y(currentYposition)), currentRoverDirection);
    }

    public static Plateau generatePlateau(int xBound, int yBound) {
        return new Plateau(new XBound(xBound), new YBound(yBound));
    }
}
