package SportsAwards.business;

public class SportsPerson {
    private String name;
    private String sport;
    private String nation;

    public SportsPerson(String name, String sport, String nation) {
        this.name = name;
        this.sport = sport;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public String getSport() {
        return sport;
    }

    public String getNation() {
        return nation;
    }
}
