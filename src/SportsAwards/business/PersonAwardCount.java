package SportsAwards.business;

public class PersonAwardCount {
    private String person;
    private int firstPlace;
    private int secondPlace;
    private int thirdPlace;

    public PersonAwardCount(String person) {
        this.person = person;
        this.firstPlace = 0;
        this.secondPlace = 0;
        this.thirdPlace = 0;
    }

    public int getTotalCount() {
        return firstPlace + secondPlace + thirdPlace;
    }

    public int getFirstPlace() {
        return firstPlace;
    }

    public void incrementFirstPlace() {
        firstPlace++;
    }

    public int getSecondPlace() {
        return secondPlace;
    }

    public void incrementSecondPlace() {
        secondPlace++;
    }

    public int getThirdPlace() {
        return thirdPlace;
    }

    public void incrementThirdPlace() {
        thirdPlace++;
    }

    public String getPerson(){
        return person;
    }

}
