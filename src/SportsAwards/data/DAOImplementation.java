package SportsAwards.data;

import SportsAwards.business.SportsAward;
import SportsAwards.business.SportsPerson;
import SportsAwards.business.SportsTeam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        try {

            String fileLocation = System.getProperty("user.dir");
            String dataPath = fileLocation + File.separator + "sports-personalities.txt";

            // Create scanner to read from the file
            Scanner scanner = new Scanner(new File(dataPath));
            // Iterate through each line
            while (scanner.hasNextLine()) {
                // Get the current line and split it into parts using the '|' delimiter
                String line = scanner.nextLine();
                String[] parts = line.split("\\|"); // '\\' Double slash needed.

                // Extract year
                int year = Integer.parseInt(parts[0]);

                // Extract information about the winner and create a SportsPerson object.
                String[] winnerParts = parts[1].split(",");
                String winnerName = winnerParts[0].substring(0, winnerParts[0].indexOf("(")).trim();
                String winnerNation = winnerParts[0].substring(winnerParts[0].indexOf("(") + 1, winnerParts[0].indexOf(")")).trim();
                String winnerSport = winnerParts[1].trim();
                SportsPerson winner = new SportsPerson(winnerName, winnerSport, winnerNation);

                // Extract information about the second-place and create object
                String[] secondParts = parts[2].split(",");
                String secondName = secondParts[0].substring(0, secondParts[0].indexOf("(")).trim();
                String secondNation = secondParts[0].substring(secondParts[0].indexOf("(") + 1, secondParts[0].indexOf(")")).trim();
                String secondSport = secondParts[1].trim();
                SportsPerson second = new SportsPerson(secondName, secondSport, secondNation);

                // Extract information about the third-place and create object
                String[] thirdParts = parts[3].split(",");
                String thirdName = thirdParts[0].substring(0, thirdParts[0].indexOf("(")).trim();
                String thirdNation = thirdParts[0].substring(thirdParts[0].indexOf("(") + 1, thirdParts[0].indexOf(")")).trim();
                String thirdSport = thirdParts[1].trim();
                SportsPerson third = new SportsPerson(thirdName, thirdSport, thirdNation);

                // Extract information about team and create a SportsTeam object.
                String[] teamParts = parts[4].split(",");
                String teamName = teamParts[0].substring(0, teamParts[0].indexOf("(")).trim();
                String teamNation = teamParts[0].substring(teamParts[0].indexOf("(") + 1, teamParts[0].indexOf(")")).trim();
                String teamSport = teamParts[1].trim();
                String teamCaptain = teamParts[2].trim();
                SportsTeam team = new SportsTeam(teamName, teamSport, teamNation, teamCaptain);

                // Create a new SportsAward object using the extracted information and add it to the ArrayList.
                sportsAward.add(new SportsAward(year, winner, second, third, team));
            }
            scanner.close();
            // Catch exception
        } catch (FileNotFoundException fnf) {
            // If the file is not found, print an error message and exit the program.
            System.out.println("File not found...");
            System.exit(0);
        }
    }
}

