package SportsAwards.business;

import java.util.regex.Pattern;

public class Validation {

    public boolean validation1(String input) {
        String regex = "^[0123]$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input).matches();
    }
}
