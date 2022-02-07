package ru.oldjew.utils;

import ru.oldjew.IO.JSONWriter;
import ru.oldjew.IO.XLSXReader;
import ru.oldjew.IO.XMLWriter;
import ru.oldjew.comparator.StudentComparator;
import ru.oldjew.comparator.UniversityComparator;
import ru.oldjew.enums.StudentEnumComparators;
import ru.oldjew.enums.UniversityEnumComparators;
import ru.oldjew.models.Statistics;
import ru.oldjew.models.Student;
import ru.oldjew.models.University;
import ru.oldjew.models.XMLModel;

import java.io.IOException;
import java.util.Date;
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
        List<University> universities =
                XLSXReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityShortNameComparator = ComparatorUtil.getUniversityComparator(UniversityEnumComparators.SHORT_NAME);

        List<Statistics> statistics = StatisticWorkerUtil.collectionToStatistic(students, universities);

        XMLModel model = new XMLModel();
        model.setStudentList(students).setUniversitiesList(universities).setStatisticsList(statistics).setDateOfCreation(new Date());

        JSONWriter.writeJsonFiles(model);
        XMLWriter.writeXML(model);
        logger.info("App finished");

    }
}
