package ru.oldjew.utils;

import ru.oldjew.models.Student;
import ru.oldjew.models.StudyProfile;
import ru.oldjew.models.University;

public class TestDriveUtil {

    public static void main(String[] args) {
        Student student = new Student.Builder("Andrew", "10",10).build();
        Student student1 = new Student.Builder("Tester", "11",11).setAvgExamScore(10)
        .setContactPhone("88005553535").build();
        University university = new University.Builder("10", "National university of testers", 1970).build();
        University university1 = new University.Builder("11", "\n" +
                "Moscow Institute of Steel and Alloys", 1970)
                .setShortName("MUoSaA").setMainProfile(StudyProfile.PHYSICS).build();
        System.out.println(student);
        System.out.println(student1);
        System.out.println(university);
        System.out.println(university1);

    }
}
