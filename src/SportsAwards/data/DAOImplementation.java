package SportsAwards.data;

import SportsAwards.business.SportsAward;

import java.util.ArrayList;
import java.util.List;

public class DAOImplementation implements DAO {

    private List<SportsAward> sportsAward;

    public DAOImplementation() {
        this.sportsAward = new ArrayList<SportsAward>();
        load();
    }

    public List<SportsAward> getSportsAward() {
        return sportsAward;
    }

    private void load() {

    }
}

