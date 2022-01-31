package ru.oldjew.utils;

import org.apache.commons.lang3.StringUtils;
import ru.oldjew.enums.StudyProfile;
import ru.oldjew.models.Statistics;
import ru.oldjew.models.Student;
import ru.oldjew.models.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StatisticWorkerUtil {

    private StatisticWorkerUtil() {
    }

    public static List<Statistics> collectionToStatistic(Collection<Student> students, Collection<University> universities) {

        List<Statistics> statisticsList = new ArrayList<>();

        for (StudyProfile profile : StudyProfile.values()) {
            Statistics statistics = new Statistics();
            statistics.setStudyProfile(profile);
            List<String> universitiesId = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId).collect(Collectors.toList());
            //get student by profile and university id
            List<Student> studentsInUniversity = students.stream()
                    .filter(student -> universitiesId.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            //set studentsPerProfile
            statistics.setStudentsPerProfile(studentsInUniversity.size());
            //set avgScore
            OptionalDouble avgScore = studentsInUniversity.stream()
                    .mapToDouble(Student::getAvgExamScore).average();
            statistics.setAvgExamScore(0);
            avgScore.ifPresent(score -> statistics.setAvgExamScore(
                    (float) BigDecimal.valueOf(score).setScale(2, RoundingMode.HALF_UP).doubleValue()
            ));
            //set university per profile
            statistics.setUniversitiesPerProfile(universitiesId.size());
            //set names
            statistics.setUniversityName(StringUtils.EMPTY);
            universities.stream().filter(university -> universitiesId.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullName -> statistics.setUniversityName(
                            statistics.getUniversityName() + fullName + ";"
                    ));
            statisticsList.add(statistics);
        }

        return statisticsList;
    }


}
