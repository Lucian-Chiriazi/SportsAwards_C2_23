package SportsAwards.business;

import java.util.Comparator;

public class SportAwardCountComparator implements Comparator<SportAwardCount>{

    public int compare(SportAwardCount s1, SportAwardCount s2) {
        // Compare by first place count, descending
        int result = Integer.compare(s2.getFirstPlace(), s1.getFirstPlace());
        if (result != 0) return result;

        // If first place counts are the same, compare by second place count, descending
        result = Integer.compare(s2.getSecondPlace(), s1.getSecondPlace());
        if (result != 0) return result;

        // If second place counts are the same, compare by third place count, descending
        result = Integer.compare(s2.getThirdPlace() , s1.getThirdPlace());
        if (result != 0) return result;

        // If third place counts are the same, compare by total count, descending
        return Integer.compare(s2.getTotalCount(), s1.getTotalCount());
    }
}
