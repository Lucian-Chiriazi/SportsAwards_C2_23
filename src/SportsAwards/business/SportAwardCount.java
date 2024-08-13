package SportsAwards.business;

public class SportAwardCount {
    public String sport;
    public int firstPlace;
    public int secondPlace;
    public int thirdPlace;

    public SportAwardCount(String sport) {
        this.sport = sport;
        this.firstPlace = 0;
        this.secondPlace = 0;
        this.thirdPlace = 0;
    }

    public int getTotalCount() {
        return firstPlace + secondPlace + thirdPlace;
    }
}
