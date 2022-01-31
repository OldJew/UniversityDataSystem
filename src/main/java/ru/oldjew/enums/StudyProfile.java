package ru.oldjew.enums;

public enum StudyProfile {
    MATHEMATICS("Математика"),
    COMPUTER_SCIENCE("Информатика"),
    ENGLISH("Английский язык"),
    PHYSICS("Физика"),
    MEDICINE("Медицина"),
    PHYSICAL_CULTURE("Физкультура"),
    LINGUISTICS("Лингвистика");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
