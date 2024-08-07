package SportsAwards.business;

public class Coordinator {
    private Validation validation;

    public Coordinator() {
        this.validation = new Validation();
    }

    public boolean runValidation1(String input) {
        return validation.validation1(input);
    }
}
