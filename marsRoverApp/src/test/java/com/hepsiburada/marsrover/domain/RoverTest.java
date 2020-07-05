package com.hepsiburada.marsrover.domain;

import com.hepsiburada.marsrover.TestConsts;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoverTest {

    @ParameterizedTest
    @MethodSource(TestConsts.TEST_CLASS_SOURCE + "#createLeftTestArguments")
    public void should_be_redirected_when_turn_left(RoverDirection currentDirection, RoverDirection expected) {
        Rover sut = DataGenerator.generateRover(currentDirection);

        Rover.Result result = sut.turnLeft();

        validate(result, expected);
    }

    @ParameterizedTest
    @MethodSource(TestConsts.TEST_CLASS_SOURCE + "#createRightTestArguments")
    public void should_be_redirected_when_turn_right(RoverDirection currentDirection, RoverDirection expected) {
        Rover sut = DataGenerator.generateRover(currentDirection);

        Rover.Result result = sut.turnRight();

        validate(result, expected);
    }

    private void validate(Rover.Result result, RoverDirection expected) {
        assertThat(result.getCurrent().getRoverDirection()).isEqualTo(expected);
        assertThat(result.getCurrent().getRoverPosition().getX().getValue()).isEqualTo(1);
        assertThat(result.getCurrent().getRoverPosition().getY().getValue()).isEqualTo(2);
    }

    @ParameterizedTest
    @MethodSource(TestConsts.TEST_CLASS_SOURCE + "#createMoveTestArguments")
    public void should_changed_spot_when_move(RoverDirection currentRoverDirection, int currentXposition, int currentYposition,
                                              RoverDirection expectedDirection, int expectedXposition, int expectedYposition) {

        Rover sut = DataGenerator.generateRover(currentRoverDirection, currentXposition, currentYposition);

        Rover.Result result = sut.move(10, 10);

        assertThat(result.getCurrent().getRoverPosition().getY().getValue()).isEqualTo(expectedYposition);
        assertThat(result.getCurrent().getRoverPosition().getX().getValue()).isEqualTo(expectedXposition);
        assertThat(result.getCurrent().getRoverDirection()).isEqualTo(expectedDirection);
    }

    @ParameterizedTest
    @MethodSource(TestConsts.TEST_CLASS_SOURCE + "#createInvalidMoveTestArguments")
    public void should_throw_when_move_to_invalid(RoverDirection currentRoverDirection, int currentXposition, int currentYposition,
                                                  int xBound, int yBound) {
        Rover sut = DataGenerator.generateRover(currentRoverDirection, currentXposition, currentYposition);

        assertThatThrownBy(() -> sut.move(xBound, yBound)).isInstanceOf(IllegalArgumentException.class);
    }

}
