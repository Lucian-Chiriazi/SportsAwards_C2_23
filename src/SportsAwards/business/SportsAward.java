package SportsAwards.business;

public class SportsAward implements Comparable<SportsAward> {

    int year;
    SportsPerson winner;
    SportsPerson second;
    SportsPerson third;
    SportsTeam team;

    public SportsAward(int year, SportsPerson winner, SportsPerson second, SportsPerson third , SportsTeam team) {
        this.year = year;
        this.winner = winner;
        this.second = second;
        this.third = third;
        this.team = team;
    }

    public int getYear() {
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

    public int compareTo(SportsAward other) {
        if (other.getYear() > this.getYear()) {
            return -1;
        }
        if (this.getYear() > other.getYear()) {
            return 1;
        }
        return 0;
    }



}
