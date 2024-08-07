package SportsAwards.data;

import SportsAwards.business.SportsAward;

import java.util.List;

public interface DAO {
    List<SportsAward> getSportsAward();
}
