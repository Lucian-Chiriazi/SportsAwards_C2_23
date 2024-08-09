package SportsAwards.business;

public class SportsTeam {
    private String teamName;
    private String sport;
    private String nation;
    private String teamCaptain;

    public SportsTeam(String teamName, String sport, String nation, String teamCaptain) {
        this.teamName = teamName;
        this.sport = sport;
        this.nation = nation;
        this.teamCaptain = teamCaptain;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamCaptain() {
        return teamCaptain;
    }

    public String getNation() {
        return nation;
    }
}
