package SportsAwards.business;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Validation {

    public boolean validation1(String input) {
        String regex = "^[0123]$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input).matches();
    }

    public boolean validation2(String input, List<SportsAward> sportsAwardList) {
        Collections.sort(sportsAwardList);
        int tempValue = Integer.parseInt(input);
        int lowerEnd = sportsAwardList.get(0).getYear();
        int higherEnd = sportsAwardList.get(sportsAwardList.size() - 1).getYear();
        String regex = "^\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(input).matches()) {
            if (tempValue >= lowerEnd && tempValue <= higherEnd) {
                return true;
            }
        }
        return false;
    }
}
