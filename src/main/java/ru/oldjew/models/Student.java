package ru.oldjew.models;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class Student  {


    @SerializedName("studentName")
    @XmlElement(name = "studentName")
    private String fullName;

    @SerializedName("universityId")
    @XmlElement(name = "universityId")
    private String universityId;

    @SerializedName("course")
    @XmlElement(name = "course")
    private int currentCourseNumber;

    @SerializedName("avgScore")
    @XmlElement(name = "avgScore")
    private float avgExamScore;

    @SerializedName("phone")
    @XmlElement(name = "phone")
    private String contactPhone;

    private Student(Builder builder) {
        this.fullName = builder.fullName;
        this.universityId = builder.universityId;
        this.currentCourseNumber = builder.currentCourseNumber;
        this.avgExamScore = builder.avgExamScore;
        this.contactPhone = builder.contactPhone;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass()).append(":{\n").append("Full name: ").append(getFullName()).append("\n")
                .append("University Id: ").append(getUniversityId()).append("\n").append("Course number: ")
                .append(getCurrentCourseNumber()).append("\n").append("Average Exam Score: ").append(getAvgExamScore())
                .append("\n").append("Contact phone: ").append(getContactPhone()).append("\n}");
        return stringBuilder.toString();
    }

    //static builder
    public static class Builder {
        private String fullName;
        private String universityId;
        private int currentCourseNumber;
        private float avgExamScore;
        private String contactPhone;
    //required fields
        public Builder(String fullName, String universityId, int currentCourseNumber) {
            this.fullName = fullName;
            this.universityId = universityId;
            this.currentCourseNumber = currentCourseNumber;
            this.avgExamScore = 0;
            this.contactPhone = "not specified";
        }

        public Builder setAvgExamScore(float avgExamScore) {
            this.avgExamScore = avgExamScore;
            return this;
        }

        public Builder setContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }
}


