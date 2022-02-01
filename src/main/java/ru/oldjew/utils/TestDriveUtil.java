package ru.oldjew.utils;

import ru.oldjew.comparator.StudentComparator;
import ru.oldjew.comparator.UniversityComparator;
import ru.oldjew.enums.StudentEnumComparators;
import ru.oldjew.enums.UniversityEnumComparators;
import ru.oldjew.models.Student;
import ru.oldjew.models.University;
import ru.oldjew.readers.XLSXReader;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestDriveUtil {
    private static final Logger logger = Logger.getLogger(TestDriveUtil.class.getName());

    public static void main(String[] args) {
       //
        try {
            LogManager.getLogManager().readConfiguration(
                    TestDriveUtil.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        logger.info("App started");
        List<Student> students
                = XLSXReader.readXlsStudent("src/main/resources/universityInfo.xlsx");
        StudentComparator studentExamScoreComparator = ComparatorUtil.getStudentComparator(StudentEnumComparators.EXAM_SCORE);
        List<University> universities=
                XLSXReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityShortNameComparator = ComparatorUtil.getUniversityComparator(UniversityEnumComparators.SHORT_NAME);

//        String studentsJson = JsonUtils.studentListToJson(students);
//        String universitiesJson = JsonUtils.universityListToJson(universities);
//
//        List<Student> studentListFromJson = JsonUtils.jsonToStudentList(studentsJson);
//        List<University> universityListFromJson = JsonUtils.jsonToUniversityList(universitiesJson);
//
//        System.out.println("Old: " +students.size() + "\nFrom JSON: " + studentListFromJson.size());
//        System.out.println("Old: " +universities.size() + "\nFrom JSON: " + universityListFromJson.size());
//
//        students.stream().forEach(student -> {
//            String json = JsonUtils.studentToJson(student);
//            System.out.println(json);
//            Student studentFromJson = JsonUtils.jsonToStudent(json);
//            System.out.println(studentFromJson);
//        });
//
//        universities.stream().forEach(university -> {
//            String json = JsonUtils.universityToJson(university);
//            System.out.println(json);
//            University universityFromJson = JsonUtils.jsonToUniversity(json);
//            System.out.println(universityFromJson);
//        });
//
//        List<Statistics> statistics = StatisticWorkerUtil.collectionToStatistic(students, universities);
//        XLSWriter.generateTable(statistics, "D:\\WorkSpace\\MyDocs\\stat.xlsx");
        logger.info("App finished");

    }
}
