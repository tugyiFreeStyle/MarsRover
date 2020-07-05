package com.hepsiburada.marsrover;

import com.hepsiburada.marsrover.domain.RoverDirection;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestDataProvider {
    private TestDataProvider() {
    }

    public static Stream<Arguments> createLeftTestArguments() {
        return Stream.of(
                Arguments.of(RoverDirection.N, RoverDirection.W),
                Arguments.of(RoverDirection.W, RoverDirection.S),
                Arguments.of(RoverDirection.S, RoverDirection.E),
                Arguments.of(RoverDirection.E, RoverDirection.N));
    }

    public static Stream<Arguments> createRightTestArguments() {
        return Stream.of(
                Arguments.of(RoverDirection.N, RoverDirection.E),
                Arguments.of(RoverDirection.W, RoverDirection.N),
                Arguments.of(RoverDirection.S, RoverDirection.W),
                Arguments.of(RoverDirection.E, RoverDirection.S));
    }

    public static Stream<Arguments> createMoveTestArguments() {
        return Stream.of(
                Arguments.of(RoverDirection.N, 1, 1, RoverDirection.N, 1, 2),
                Arguments.of(RoverDirection.W, 1, 1, RoverDirection.W, 0, 1),
                Arguments.of(RoverDirection.S, 1, 1, RoverDirection.S, 1, 0),
                Arguments.of(RoverDirection.E, 1, 1, RoverDirection.E, 2, 1));
    }

    public static Stream<Arguments> createInvalidMoveTestArguments() {
        return Stream.of(
                Arguments.of(RoverDirection.W, 0, 1, 3, 3),
                Arguments.of(RoverDirection.S, 1, 0, 3, 3),
                Arguments.of(RoverDirection.E, 3, 1, 3, 3),
                Arguments.of(RoverDirection.N, 2, 5, 3, 5));
    }

    public static Stream<Arguments> createDeployFailTestArguments() {
        return Stream.of(
                Arguments.of(6, 2),
                Arguments.of(1,7));
    }

    public static Stream<Arguments> createPlateauFailTestArguments() {
        return Stream.of(
                Arguments.of(-1, 2),
                Arguments.of(1,-1));
    }

    private static Stream<Arguments> createFailControlTestArguments() {
        return Stream.of(
                Arguments.of("L L L"),
                Arguments.of("LRRK"),
                Arguments.of("LLLM1"));
    }

    private static Stream<Arguments> createControlTestArguments() {
        return Stream.of(
                Arguments.of("LLL", RoverDirection.E, 1, 1),
                Arguments.of("MMRM", RoverDirection.E, 2, 3),
                Arguments.of("RRM", RoverDirection.S, 1, 0));

    }

    private static Stream<Arguments> createBoundTestArguments() {
        return Stream.of(
                Arguments.of("12"),
                Arguments.of("1 N"),
                Arguments.of("N N"));
    }

    private static Stream<Arguments> createCoordinateTestArguments() {
        return Stream.of(
                Arguments.of("128"),
                Arguments.of("1 N 3"),
                Arguments.of("1 2 K"));
    }

    private static Stream<Arguments> createTestArguments() {
        return Stream.of(
                Arguments.of("LL1"),
                Arguments.of("LMMM="),
                Arguments.of("LL RMM"));

    }

    private static Stream<Arguments> createCreatePlateauFailTestArguments() {
        return Stream.of(
                Arguments.of("55"),
                Arguments.of("5 3 2"),
                Arguments.of("5 5M"),
                Arguments.of("5 M"));

    }

}
