package ru.oldjew.comparator;

import org.apache.commons.lang3.StringUtils;
import ru.oldjew.models.Student;

public class StudentPhoneComparator implements StudentComparator{
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getContactPhone(),o2.getContactPhone());
    }
}
