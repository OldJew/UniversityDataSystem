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
        List<University> universities=
                XLSXReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityShortNameComparator = ComparatorUtil.getUniversityComparator(UniversityEnumComparators.SHORT_NAME);

        String studentsJson = JsonUtils.studentListToJson(students);
        String universitiesJson = JsonUtils.universityListToJson(universities);

        List<Student> studentListFromJson = JsonUtils.jsonToStudentList(studentsJson);
        List<University> universityListFromJson = JsonUtils.jsonToUniversityList(universitiesJson);

        System.out.println("Old: " +students.size() + "\nFrom JSON: " + studentListFromJson.size());
        System.out.println("Old: " +universities.size() + "\nFrom JSON: " + universityListFromJson.size());

        students.stream().forEach(student -> {
            String json = JsonUtils.studentToJson(student);
            System.out.println(json);
            Student studentFromJson = JsonUtils.jsonToStudent(json);
            System.out.println(studentFromJson);
        });

        universities.stream().forEach(university -> {
            String json = JsonUtils.universityToJson(university);
            System.out.println(json);
            University universityFromJson = JsonUtils.jsonToUniversity(json);
            System.out.println(universityFromJson);
        });

    }
}
