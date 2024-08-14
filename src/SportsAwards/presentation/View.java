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
            System.out.println(coordinator.printOptionsMenu());
            System.out.print(coordinator.printMessage1());
            String input = scanner.nextLine().trim();

            while(!coordinator.runValidation1(input)) {
                System.out.println(coordinator.printInvalid1());
                System.out.print(coordinator.printMessage1());
                input = scanner.nextLine().trim();
            }

            switch (input) {
                case "1":
                    System.out.println(coordinator.listSportsAward());
                    break;
                case "2":
                    coordinator.selectSportsAward();
                    break;
                case "3":
                    System.out.println(coordinator.printSortMenu());
                    System.out.print(coordinator.printMessage1());
                    input = scanner.nextLine().trim();

                    while(!coordinator.runValidation2(input)) {
                        System.out.println(coordinator.printInvalid1());
                        System.out.print(coordinator.printMessage1());
                        input = scanner.nextLine().trim();
                    }

                    switch (input) {
                        case "1":
                            coordinator.sortAwardsBySport();
                            break;
                        case "2":
                        case "0":
                            break;
                    }
                    break;
                case "0":
                    System.out.println("Bye Bye!");
                    System.exit(0);
            }
        }
    }



}
