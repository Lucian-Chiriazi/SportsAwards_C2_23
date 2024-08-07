package SportsAwards.business;

import SportsAwards.data.DAO;
import SportsAwards.data.DAOImplementation;

import java.util.List;

public class Coordinator {
    private DAO dao;
    private Validation validation;
    private List<SportsAward> sportsAward;

    public Coordinator() {
        this.dao = new DAOImplementation();
        this.validation = new Validation();
        this.sportsAward = dao.getSportsAward();
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

    public StringBuilder printInvalid1() {
        StringBuilder output = new StringBuilder();
        output.append("Invalid input!");

        return output;
    }
}
