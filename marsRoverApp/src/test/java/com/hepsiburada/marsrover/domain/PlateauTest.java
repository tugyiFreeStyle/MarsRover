package com.hepsiburada.marsrover.domain;

import com.hepsiburada.marsrover.TestConsts;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlateauTest {

    @Test
    public void should_be_deployed() {
        Plateau sut = new Plateau(new XBound(5), new YBound(5));

        Rover rover = DataGenerator.generateRover(RoverDirection.S, 1, 2);

        sut.deploy(rover);

        int count = sut.getRovers().size();

        assertThat(count).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource(TestConsts.TEST_CLASS_SOURCE + "#createPlateauFailTestArguments")
    public void should_throw_when_size_exceed(int x, int y) {
        assertThatThrownBy(() -> new Plateau(new XBound(x), new YBound(y))).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @MethodSource(TestConsts.TEST_CLASS_SOURCE + "#createDeployFailTestArguments")
    public void should_throw_when_deployed(int x, int y) {
        Plateau sut = new Plateau(new XBound(5), new YBound(5));

        Rover rover = DataGenerator.generateRover(RoverDirection.S, x, y);

        assertThatThrownBy(() -> sut.deploy(rover)).isInstanceOf(IllegalArgumentException.class);
    }
}
