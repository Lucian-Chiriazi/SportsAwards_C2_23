package SportsAwards.business;

import SportsAwards.data.DAO;
import SportsAwards.data.DAOImplementation;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Coordinator {
    private DAO dao;
    private Validation validation;
    private List<SportsAward> sportsAward;
    private Scanner scanner;

    public Coordinator() {
        this.dao = new DAOImplementation();
        this.validation = new Validation();
        this.sportsAward = dao.getSportsAward();
        this.scanner = new Scanner(System.in);
    }

    public boolean runValidation1(String input) {
        return validation.validation1(input);
    }

    public StringBuilder printMenu() {
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

    public StringBuilder printMessage1() {
        StringBuilder output = new StringBuilder();
        output.append("Enter choice > ");

        return output;
    }

    public StringBuilder printMessage2() {
        StringBuilder output = new StringBuilder();
        output.append("Enter year of the award > ");
        return output;
    }

    public StringBuilder printInvalid1() {
        StringBuilder output = new StringBuilder();
        output.append("Invalid input!");

        return output;
    }

    public StringBuilder listSportsAward() {
        StringBuilder output = new StringBuilder();
        Collections.sort(sportsAward);

        output.append("-------------------------------------------------------------------\n");
        output.append(String.format("| %-4s | %-18s | %-35s |\n",
                "Year", "Individual Award", "Team Award"));
        output.append("-------------------------------------------------------------------\n");
        for (SportsAward object : sportsAward) {
            output.append(String.format("| %-4s | %-18s | %-35s |\n",
                    object.getYear(),
                    object.getWinner().getName(),
                    object.getTeam().getTeamName()));
        }
        output.append("-------------------------------------------------------------------\n");

        return output;
    }

    public void selectSportsAward() {
        System.out.print(printMessage2());
        String input = scanner.nextLine().trim();

        while(!validation.validation2(input, sportsAward)) {
            System.out.println(printInvalid1());
            System.out.print(printMessage2());
            input = scanner.nextLine().trim();
        }

        for (SportsAward object : sportsAward) {
            if (object.getYear() == Integer.parseInt(input)) {
                System.out.println(object);
            }
        }
    }
}
