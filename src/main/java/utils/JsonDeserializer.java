package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Course;

import java.io.BufferedReader;

public class JsonDeserializer {

    private final Gson gson;

    public JsonDeserializer() {
        gson = new GsonBuilder().create();
    }

    public Course convertToObject(BufferedReader bufferedReader) {
        return gson.fromJson(bufferedReader, Course.class);
    }
}
