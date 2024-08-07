package SportsAwards.business;

public class SportsAward {

    String year;
    SportsPerson winner;
    SportsPerson second;
    SportsPerson third;
    SportsTeam team;

    public SportsAward(String year, SportsPerson winner, SportsPerson second, SportsPerson third , SportsTeam team) {
        this.year = year;
        this.winner = winner;
        this.second = second;
        this.third = third;
        this.team = team;
    }

    public String getYear() {
        return year;
    }

    public SportsPerson getWinner() {
        return winner;
    }

    public SportsPerson getSecond() {
        return second;
    }

    public SportsPerson getThird() {
        return third;
    }

    public SportsTeam getTeam() {
        return team;
    }

}
