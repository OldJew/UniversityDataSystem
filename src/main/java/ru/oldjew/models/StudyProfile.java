package ru.oldjew.models;

public enum StudyProfile {
    MATH("Математика"),
    COMPUTER_SCIENCE("Информатика"),
    ENGLISH("Английский язык"),
    PHYSICS("Физика"),
    MEDICINE("Медицина"),
    PHYSICAL_CULTURE("Физкультура");
    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
