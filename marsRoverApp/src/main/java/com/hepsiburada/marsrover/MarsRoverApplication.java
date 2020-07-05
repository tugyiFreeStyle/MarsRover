package com.hepsiburada.marsrover;

import com.hepsiburada.marsrover.application.PlateauService;
import com.hepsiburada.marsrover.application.PlateauServiceImpl;
import com.hepsiburada.marsrover.application.RoverService;
import com.hepsiburada.marsrover.application.RoverServiceImpl;
import com.hepsiburada.marsrover.application.validators.PlateauCommandValidator;
import com.hepsiburada.marsrover.application.validators.RoverCommandValidator;
import com.hepsiburada.marsrover.domain.Plateau;
import com.hepsiburada.marsrover.domain.Rover;
import com.hepsiburada.marsrover.domain.shared.State;

import java.util.Scanner;

public class MarsRoverApplication {

    private static final PlateauService plateauService = new PlateauServiceImpl(new PlateauCommandValidator());

    private static final RoverService roverService = new RoverServiceImpl(new RoverCommandValidator());

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Please enter upper right coordinates");
            String coordinates = scanner.nextLine();
            Plateau plateau = plateauService.create(coordinates);
            Rover.Result resultFirst = processInput(scanner, plateau, "1");
            Rover.Result resultSecond = processInput(scanner, plateau, "2");

            System.out.println(getRoverOutput(resultFirst));
            System.out.println(getRoverOutput(resultSecond));

        } catch (Exception ex) {
            System.out.println("Invalid" + ex.getMessage());
        }
    }

    static Rover.Result processInput(Scanner scanner, Plateau plateau, String roverNumber) {

        System.out.println("Please enter position of rover-" + roverNumber);
        String position = scanner.nextLine();
        Rover rover = plateauService.deploy(plateau, position);

        System.out.println("Please enter controls of rover-" + roverNumber);
        String controls = scanner.nextLine();
        return roverService.control(plateau, rover, controls);

    }

    private static String getRoverOutput(State<Rover>.Result resultFirst) {
        return resultFirst.getCurrent().getRoverPosition().getX().getValue() + " " + resultFirst.getCurrent().getRoverPosition().getY().getValue() + " " + resultFirst.getCurrent().getRoverDirection();
    }
}
