package ru.oldjew.utils;

import ru.oldjew.comparator.StudentComparator;
import ru.oldjew.comparator.UniversityComparator;
import ru.oldjew.enums.StudentEnumComparators;
import ru.oldjew.enums.UniversityEnumComparators;
import ru.oldjew.models.Student;
import ru.oldjew.models.University;
import ru.oldjew.readers.XLSXReader;

import java.util.List;

public class TestDriveUtil {

    public static void main(String[] args) {

        List<Student> students
                = XLSXReader.readXlsStudent("src/main/resources/universityInfo.xlsx");
        StudentComparator studentExamScoreComparator = ComparatorUtil.getStudentComparator(StudentEnumComparators.EXAM_SCORE);
        students.stream().sorted(studentExamScoreComparator).forEach(System.out::println);

        List<University> universities=
                XLSXReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityShortNameComparator = ComparatorUtil.getUniversityComparator(UniversityEnumComparators.SHORT_NAME);
        universities.stream().sorted(universityShortNameComparator).forEach(System.out::println);

    }
}
