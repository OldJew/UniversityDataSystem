package ru.oldjew.comparator;

import org.apache.commons.lang3.StringUtils;
import ru.oldjew.models.University;

public class UniversityFullNameComparator implements UniversityComparator{
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());
    }
}
