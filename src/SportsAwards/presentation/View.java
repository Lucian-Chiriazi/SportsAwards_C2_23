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
            System.out.println(coordinator.printMenu());
            System.out.println(coordinator.printMessage1());
            String input = scanner.nextLine();

            while(!coordinator.runValidation1(input)) {
                System.out.println(coordinator.printInvalid1());
                System.out.println(coordinator.printMessage1());
                input = scanner.nextLine();
            }

            switch (input) {
                case "1":
                    break;

            }
        }
    }



}
