package com.hepsiburada.marsrover.domain;


import com.hepsiburada.marsrover.domain.shared.ControlFinder;
import com.hepsiburada.marsrover.domain.shared.ControlType;
import com.hepsiburada.marsrover.domain.shared.State;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Rover extends State<Rover> {
    private RoverId id;
    private RoverPosition roverPosition;
    private RoverDirection roverDirection;

    public Result turnLeft() {
        this.roverDirection = redirect(ControlType.L);
        return toResult(this);
    }

    public Result turnRight() {
        this.roverDirection = redirect(ControlType.R);
        return toResult(this);
    }

    public Result move(int xBound, int yBound) {
        this.roverPosition = redirect(ControlType.M);

        if (isInvalidSpot(xBound, yBound))
            throw new IllegalArgumentException(String.valueOf(xBound).concat(String.valueOf(xBound)));

        return toResult(this);
    }

    private boolean isInvalidSpot(int xBound, int yBound) {
        return this.roverPosition.getX().getValue() > xBound || this.roverPosition.getY().getValue() > yBound;
    }

    private <TResult> TResult redirect(ControlType controlType) {
        ControlFinder<TResult> controlFinder = ControlFinderFactory.get(controlType);
        return controlFinder.get(this);
    }
}
