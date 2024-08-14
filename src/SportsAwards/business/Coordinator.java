package SportsAwards.business;

import SportsAwards.data.DAO;
import SportsAwards.data.DAOImplementation;

import java.util.*;

public class Coordinator {
    private DAO dao;
    private Validation validation;
    private List<SportsAward> sportsAward;
    private Scanner scanner;
    private List<SportAwardCount> sortedSportAwards;
    private Map<String, SportAwardCount> sportAwardCounts;
    private List<PersonAwardCount> sortedPersonAwards;
    private Map<String, PersonAwardCount> personAwardCounts;

    public Coordinator() {

        this.dao = new DAOImplementation();
        this.validation = new Validation();
        this.sportsAward = dao.getSportsAward();
        this.scanner = new Scanner(System.in);
        this.sportAwardCounts = new HashMap<>();
        this.personAwardCounts = new HashMap<>();
    }

    public boolean runValidation1(String input) {
        return validation.validation1(input);
    }

    public boolean runValidation2(String input) { return validation.validation2(input); }

    public StringBuilder printOptionsMenu() {
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

    public StringBuilder printSortMenu() {
        StringBuilder output = new StringBuilder();
        output.append("--------------------------------------\n");
        output.append("Sort Options \n");
        output.append("--------------------------------------\n");
        output.append("Sort awards won by sport ............1\n");
        output.append("Sort awards won by sports person ....2\n");
        output.append("Back to main menu ...................0\n");
        output.append("--------------------------------------\n");

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

        while(!validation.validation3(input, sportsAward)) {
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

    public void sortAwardsBySport() {
        for (SportsAward object : sportsAward) {
            incrementAwardCount(sportAwardCounts, object.winner.getSport(), 1);
            incrementAwardCount(sportAwardCounts, object.second.getSport(), 2);
            incrementAwardCount(sportAwardCounts, object.third.getSport(), 3);
        }


        this.sortedSportAwards = new ArrayList<>(sportAwardCounts.values());
        sortedSportAwards.sort(new SportAwardCountComparator());
        displaySportData(sortedSportAwards);
    }

    public void sortAwardsByPerson() {
        for (SportsAward object : sportsAward) {
            incrementPersonAwardCount(personAwardCounts, object.winner.getName(), 1);
            incrementPersonAwardCount(personAwardCounts, object.second.getName(), 2);
            incrementPersonAwardCount(personAwardCounts, object.third.getName(), 3);
        }

        this.sortedPersonAwards = new ArrayList<>(personAwardCounts.values());
        sortedPersonAwards.sort(new PersonAwardCountComparator());
        displayPersonSportData(sortedPersonAwards);

    }

    private static void incrementAwardCount(Map<String, SportAwardCount> sportAwardCounts, String sport, int place) {
        SportAwardCount count = sportAwardCounts.getOrDefault(sport, new SportAwardCount(sport));
        switch (place) {
            case 1:
                count.incrementFirstPlace();
                break;
            case 2:
                count.incrementSecondPlace();
                break;
            case 3:
                count.incrementThirdPlace();
                break;
        }
        sportAwardCounts.put(sport, count);
    }

    private static void incrementPersonAwardCount(Map<String, PersonAwardCount> personAwardCounts, String name, int place) {
        PersonAwardCount count = personAwardCounts.getOrDefault(name, new PersonAwardCount(name));
        switch (place) {
            case 1:
                count.incrementFirstPlace();
                break;
            case 2:
                count.incrementSecondPlace();
                break;
            case 3:
                count.incrementThirdPlace();
                break;
        }
        personAwardCounts.put(name, count);
    }

    public static void displaySportData(List<SportAwardCount> sortedSportAwards) {
        // Print table header
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("| Sport              | First Place | Second Place | Third Place | Total       |");
        System.out.println("-------------------------------------------------------------------------------");

        for (SportAwardCount stats : sortedSportAwards) {
            System.out.printf("| %-18s | %-11d | %-12d | %-11d | %-11d |%n",
                    stats.getSport(),
                    stats.getFirstPlace(),
                    stats.getSecondPlace(),
                    stats.getThirdPlace(),
                    stats.getTotalCount()
            );
        }
        // Print the table footer
        System.out.println("-------------------------------------------------------------------------------");
    }

    public static void displayPersonSportData(List<PersonAwardCount> sortedPersonSportAwards) {
        // Print table header
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("| Sport              | First Place | Second Place | Third Place | Total       |");
        System.out.println("-------------------------------------------------------------------------------");

        for (PersonAwardCount stats : sortedPersonSportAwards) {
            System.out.printf("| %-18s | %-11d | %-12d | %-11d | %-11d |%n",
                    stats.getPerson(),
                    stats.getFirstPlace(),
                    stats.getSecondPlace(),
                    stats.getThirdPlace(),
                    stats.getTotalCount()
            );
        }
        // Print the table footer
        System.out.println("-------------------------------------------------------------------------------");
    }
}
