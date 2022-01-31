package ru.oldjew.models;

import ru.oldjew.enums.StudyProfile;

public class Statistics {

    private StudyProfile studyProfile;
    private float avgExamScore;
    private int studentsPerProfile;
    private int universitiesPerProfile;
    private String universityName;

    public Statistics() {
    }

    public Statistics(StudyProfile studyProfile, float avgExamScore, int studentsPerProfile, int universitiesPerProfile, String universityName) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.studentsPerProfile = studentsPerProfile;
        this.universitiesPerProfile = universitiesPerProfile;
        this.universityName = universityName;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public double getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getStudentsPerProfile() {
        return studentsPerProfile;
    }

    public void setStudentsPerProfile(int studentsPerProfile) {
        this.studentsPerProfile = studentsPerProfile;
    }

    public int getUniversitiesPerProfile() {
        return universitiesPerProfile;
    }

    public void setUniversitiesPerProfile(int universitiesPerProfile) {
        this.universitiesPerProfile = universitiesPerProfile;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
