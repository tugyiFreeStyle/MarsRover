package com.hepsiburada.marsrover.application;

import com.hepsiburada.marsrover.TestConsts;
import com.hepsiburada.marsrover.application.validators.RoverCommandValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoverCommandValidatorTest {

    @ParameterizedTest
    @MethodSource(TestConsts.TEST_CLASS_SOURCE + "#createTestArguments")
    public void should_throw_when_validate(String args) {
        RoverCommandValidator sut = new RoverCommandValidator();

        assertThatThrownBy(() -> sut.validate(args)).isInstanceOf(IllegalArgumentException.class);
    }
}
