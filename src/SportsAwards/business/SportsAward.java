package SportsAwards.business;

import java.util.HashMap;
import java.util.Map;

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

    public String toString() {
        StringBuilder output = new StringBuilder();
        String teamName = this.team.getTeamName();
        String teamCaptain = this.team.getTeamCaptain();
        String teamNation = provideFullNationName(this.team.getNation());
        String winnerName = this.winner.getName().toUpperCase();
        String winnerSport = this.winner.getSport().toUpperCase();
        String winnerNation = provideFullNationName(this.winner.getNation()).toUpperCase();
        String secondName = this.second.getName();
        String secondSport = this.second.getSport();
        String secondNation = provideFullNationName(this.second.getNation());
        String thirdName = this.third.getName();
        String thirdSport = this.third.getSport();
        String thirdNation = provideFullNationName(this.third.getNation());
        String personHead = "Individual Sports Person";
        String teamHead = "Team";

        output.append("-------------------------------------------------------------------------------------------------\n");
        output.append("|");
        output.append(calculatePadding(personHead, 60));
        output.append(personHead);
        output.append(calculatePadding(personHead, 60));
        output.append("|");
        output.append(calculatePadding(teamHead, 35));
        output.append(teamHead);
        output.append(calculatePadding(teamHead, 35));
        output.append("|\n");
        output.append("-------------------------------------------------------------------------------------------------\n");
        output.append(String.format("| %-8s| %-18s| %-13s| %-14s|",
                "Winner", winnerName, winnerSport, winnerNation));
        output.append(calculatePadding(teamName,35));
        output.append(teamName);
        output.append(calculatePadding(teamName,34));
        output.append("|\n");
        output.append("--------------------------------------------------------------\n");
        output.append(String.format("| %-8s| %-18s| %-13s| %-14s|",
                "Second", secondName, secondSport, secondNation));
        output.append(calculatePadding(("Captain: " + teamCaptain),35));
        output.append("Captain: ");
        output.append(teamCaptain);
        output.append(calculatePadding(("Captain: " + teamCaptain),34));
        output.append("|\n");
        output.append("--------------------------------------------------------------\n");
        output.append(String.format("| %-8s| %-18s| %-13s| %-14s|",
                "Third", thirdName, thirdSport, thirdNation));
        output.append(calculatePadding(teamNation,35));
        output.append(teamNation);
        output.append(calculatePadding(teamNation,34));
        output.append("|\n");
        output.append("-------------------------------------------------------------------------------------------------\n");

        return output.toString();
    }

    private String provideFullNationName(String initials) {
        Map<String, String> countryMap = new HashMap<>();
        countryMap.put("ENG", "England");
        countryMap.put("WAL", "Wales");
        countryMap.put("SCO", "Scotland");
        countryMap.put("NIR", "Northern Ireland");
        countryMap.put("IOM", "Isle of Man");
        countryMap.put("ITA", "Italy");
        countryMap.put("EU", "Europe");
        countryMap.put("UK", "United Kingdom");

        return countryMap.getOrDefault(initials, "Unknown Country");
    }

    private String calculatePadding(String input, int width) {
        int textLength = input.length();
        String padding = "";
        int temp = (width - textLength) / 2;
        for (int i = 0; i < temp; i++) {
            padding += " ";
        }
        String fullLength = padding + input;
        if (fullLength.length() > width) {
            padding = padding.substring(0, padding.length() - 1);
        }
        return padding;
    }
}
