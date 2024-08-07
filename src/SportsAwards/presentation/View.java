package SportsAwards.presentation;

import SportsAwards.business.Coordinator;

import java.util.Scanner;

public class View {
    private Coordinator coordinator;
    private Scanner scanner;
    private boolean keepRunning;

    public View(Coordinator coordinator) {
        this.coordinator = coordinator;
        this.scanner = new Scanner(System.in);
        this.keepRunning = true;
    }

    public void startUI() {
        while(keepRunning) {
            System.out.println(printMenu());
            System.out.println(printMessage1());
            String input = scanner.nextLine();

            while(!coordinator.runValidation1(input)) {
                System.out.println(printInvalid1());
                System.out.println(printMessage1());
                input = scanner.nextLine();
            }

            switch (input) {
                case "1":
                    break;

            }
        }
    }

    private StringBuilder printMenu() {
        StringBuilder output = new StringBuilder();
        output.append("----------------------------\n");
        output.append("Sport Award menu\n");
        output.append("----------------------------\n");
        output.append("List ......................1\n");
        output.append("Select ....................2\n");
        output.append("Sort ......................3\n");
        output.append("Exit ......................0\n");
        output.append("----------------------------\n");

        return output;
    }

    private StringBuilder printMessage1() {
        StringBuilder output = new StringBuilder();
        output.append("Enter choice > ");

        return output;
    }

    private StringBuilder printInvalid1() {
        StringBuilder output = new StringBuilder();
        output.append("Invalid input!");

        return output;
    }

}
