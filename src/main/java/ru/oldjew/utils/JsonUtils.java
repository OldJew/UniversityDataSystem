package ru.oldjew.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ru.oldjew.models.Student;
import ru.oldjew.models.University;

import java.util.List;

public class JsonUtils {

    private JsonUtils() {
    }

    public static String studentToJson(Student student){
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static String studentListToJson(List<Student> students){
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);
    }

    public static String universityToJson(University university){
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static String universityListToJson(List<University> universities){
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);
    }

    public static Student jsonToStudent(String json){
        return new Gson().fromJson(json, Student.class);
    }

    public static List<Student> jsonToStudentList(String json){
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {}.getType());
    }

    public static University jsonToUniversity(String json){
        return new Gson().fromJson(json, University.class);
    }

    public static List<University> jsonToUniversityList(String json){
        return new Gson().fromJson(json, new TypeToken<List<University>>() {}.getType());
    }
}
