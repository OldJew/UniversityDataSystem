package ru.oldjew.comparator;

import org.apache.commons.lang3.StringUtils;
import ru.oldjew.models.University;

public class UniversityMainProfileComparator implements UniversityComparator{
    @Override
    public int compare(University o1, University o2) {
        if (o1.getMainProfile() == null){
            return 1;
        }
        if (o2.getMainProfile() == null){
            return -1;
        }
        return StringUtils.compare(o1.getMainProfile().name(), o2.getMainProfile().name());

    }
}
