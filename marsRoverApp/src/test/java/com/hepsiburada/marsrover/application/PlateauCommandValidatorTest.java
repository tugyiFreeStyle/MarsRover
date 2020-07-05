package com.hepsiburada.marsrover.application;

import com.hepsiburada.marsrover.TestConsts;
import com.hepsiburada.marsrover.application.validators.PlateauCommandValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlateauCommandValidatorTest {

    @ParameterizedTest
    @MethodSource(TestConsts.TEST_CLASS_SOURCE + "#createBoundTestArguments")
    public void should_throw_when_validateBounds(String args) {

        PlateauCommandValidator sut = new PlateauCommandValidator();

        assertThatThrownBy(() -> sut.validateBounds(args)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource(TestConsts.TEST_CLASS_SOURCE + "#createCoordinateTestArguments")
    public void should_throw_when_validateCoordinates(String args) {

        PlateauCommandValidator sut = new PlateauCommandValidator();

        assertThatThrownBy(() -> sut.validateCoordinates(args)).isInstanceOf(IllegalArgumentException.class);
    }
}
