package com.hepsiburada.marsrover.application;

import com.hepsiburada.marsrover.TestConsts;
import com.hepsiburada.marsrover.application.validators.RoverCommandValidator;
import com.hepsiburada.marsrover.domain.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoverServiceTest {

    @ParameterizedTest
    @MethodSource(TestConsts.TEST_CLASS_SOURCE + "#createControlTestArguments")
    public void should_relocated_when_control(String commands, RoverDirection expectedDirection,
                                              int expectedX, int expectedY) {
        RoverService sut = new RoverServiceImpl(new RoverCommandValidator());
        Plateau plateau = new Plateau(new XBound(5), new YBound(5));

        Rover rover = DataGenerator.generateRover(RoverDirection.N, 1, 1);

        sut.control(plateau, rover, commands);

        assertThat(rover.getRoverDirection()).isEqualTo(expectedDirection);
        assertThat(rover.getRoverPosition().getX().getValue()).isEqualTo(expectedX);
        assertThat(rover.getRoverPosition().getY().getValue()).isEqualTo(expectedY);
    }

    @ParameterizedTest
    @MethodSource(TestConsts.TEST_CLASS_SOURCE + "#createFailControlTestArguments")
    public void should_throw_when_control_with_invalid_args(String commands){
        RoverService sut = new RoverServiceImpl(new RoverCommandValidator());
        Plateau plateau = new Plateau(new XBound(5), new YBound(5));

        Rover rover = DataGenerator.generateRover(RoverDirection.N, 1, 1);

        assertThatThrownBy(()->sut.control(plateau, rover, commands)).isInstanceOf(IllegalArgumentException.class);
    }
}
