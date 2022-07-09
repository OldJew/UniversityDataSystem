package ru.oldjew.utils;

import com.google.gson.GsonBuilder;

import java.util.List;

public class JsonUtils {

    private JsonUtils() {
    }

    public static String writeListToJSON(List<?> list){
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }
//    public List<?> getListFromJSON(String json){
//        return new Gson().fromJson(json, new TypeToken<List<?>>() {}.getType());
//    }
}
