package SportsAwards.business;

import java.util.Comparator;

public class PersonAwardCountComparator implements Comparator<PersonAwardCount>{

    public int compare(PersonAwardCount s1, PersonAwardCount s2) {

        int result = Integer.compare(s2.getFirstPlace(), s1.getFirstPlace());
        if (result != 0) return result;

        result = Integer.compare(s2.getSecondPlace(), s1.getSecondPlace());
        if (result != 0) return result;

        result = Integer.compare(s2.getThirdPlace() , s1.getThirdPlace());
        if (result != 0) return result;

        return Integer.compare(s2.getTotalCount(), s1.getTotalCount());
    }
}
