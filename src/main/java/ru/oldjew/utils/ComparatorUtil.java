package ru.oldjew.utils;

import ru.oldjew.comparator.*;
import ru.oldjew.enums.StudentEnumComparators;
import ru.oldjew.enums.UniversityEnumComparators;

public class ComparatorUtil {

    private ComparatorUtil(){

    }

    public static StudentComparator getStudentComparator(StudentEnumComparators studentEnumComparators){
        return switch (studentEnumComparators){
                    case FULL_NAME-> new StudentFullNameComparator();
                    case UNIVERSITY_ID -> new StudentUniversityIdComparator();
                    case COURSE_NUMBER -> new StudentCourseNumberComparator();
                    case EXAM_SCORE -> new StudentExamScoreComparator();
                    case PHONE-> new StudentPhoneComparator();
            };
    }

    public static UniversityComparator getUniversityComparator(UniversityEnumComparators universityEnumComparators){
        return switch (universityEnumComparators){
            case FULL_NAME -> new UniversityFullNameComparator();
            case ID -> new UniversityIdComparator();
            case SHORT_NAME -> new UniversityShortNameComparator();
            case MAIN_PROFILE -> new UniversityMainProfileComparator();
            case YEAR_OF_FOUNDATION -> new UniversityYearFoundationComparator();

        };
    }
}
