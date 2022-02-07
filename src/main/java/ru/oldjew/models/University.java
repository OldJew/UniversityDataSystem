package ru.oldjew.models;

import com.google.gson.annotations.SerializedName;
import ru.oldjew.enums.StudyProfile;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @SerializedName("universityId")
    @XmlElement(name = "universityId")
    private String id;

    @SerializedName("universityName")
    @XmlElement(name = "universityName")
    private String fullName;

    @SerializedName("yearOfFoundation")
    @XmlElement(name = "yearOfFoundation")
    private int yearOfFoundation;

    @SerializedName("universityShortName")
    @XmlElement(name = "universityShortName")
    private String shortName;

    @SerializedName("profile")
    @XmlElement(name = "profile")
    private StudyProfile mainProfile;

    private University(Builder builder) {
        this.id = builder.id;
        this.fullName = builder.fullName;
        this.yearOfFoundation = builder.yearOfFoundation;
        this.shortName = builder.shortName;
        this.mainProfile = builder.mainProfile;

    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass()).append(":{\n").append("University Id: ").append(getId()).append("\n")
                .append("Full name: ").append(getFullName()).append("\n").append("Short name: ")
                .append(getShortName()).append("\n").append("Year of Foundation: ").append(getYearOfFoundation())
                .append("\n").append("Main profile: ").append(getMainProfile()).append("\n}");
        return stringBuilder.toString();
    }

    public static class Builder{
        private String id;
        private String fullName;
        private int yearOfFoundation;
        private String shortName;
        private StudyProfile mainProfile;
        //required fields
        public Builder(String id, String fullName, int yearOfFoundation) {
            this.id = id;
            this.fullName = fullName;
            this.yearOfFoundation = yearOfFoundation;
            this.shortName = "None";
        }

        public Builder setShortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public Builder setMainProfile(StudyProfile mainProfile) {
            this.mainProfile = mainProfile;
            return this;
        }

        public University build(){
            return new University(this);
        }
    }
}
