package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import model.Course;

import java.util.List;

public class JsonConverter {

    private final Gson gson;

    public JsonConverter() {

        gson = new GsonBuilder().create();
    }

    public String convertToJson(List<Course> courses) {

        JsonArray jarray = gson.toJsonTree(courses).getAsJsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("courses", jarray);

        return jsonObject.toString();
    }
}
