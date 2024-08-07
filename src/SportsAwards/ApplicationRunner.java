package SportsAwards;

import SportsAwards.business.Coordinator;
import SportsAwards.presentation.View;

public class ApplicationRunner {
    public static void main(String[] args) {
        Coordinator coordinator = new Coordinator();
        View view = new View(coordinator);
        view.startUI();
    }
}
