package com.hepsiburada.marsrover.application;

import com.hepsiburada.marsrover.TestConsts;
import com.hepsiburada.marsrover.application.validators.PlateauCommandValidator;
import com.hepsiburada.marsrover.domain.DataGenerator;
import com.hepsiburada.marsrover.domain.Plateau;
import com.hepsiburada.marsrover.domain.Rover;
import com.hepsiburada.marsrover.domain.RoverDirection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlateauServiceTest {

    @Test
    public void should_be_created() {

        PlateauService sut = new PlateauServiceImpl(new PlateauCommandValidator());

        Plateau plateau = sut.create("3 4");

        assertThat(plateau.getXBound().getValue()).isEqualTo(3);
        assertThat(plateau.getYBound().getValue()).isEqualTo(4);
    }

    @ParameterizedTest
    @MethodSource(TestConsts.TEST_CLASS_SOURCE + "#createCreatePlateauFailTestArguments")
    public void should_throw_when_create_with_invalid_args(String commands) {

        PlateauService sut = new PlateauServiceImpl(new PlateauCommandValidator());

        assertThatThrownBy(() -> sut.create(commands)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_be_deployed() {
        PlateauService sut = new PlateauServiceImpl(new PlateauCommandValidator());
        Plateau plateau = DataGenerator.generatePlateau(5, 5);

        Rover rover = sut.deploy(plateau, "2 1 N");

        assertThat(rover.getRoverPosition().getX().getValue()).isEqualTo(2);
        assertThat(rover.getRoverPosition().getY().getValue()).isEqualTo(1);
        assertThat(rover.getRoverDirection()).isEqualTo(RoverDirection.N);
    }
}
