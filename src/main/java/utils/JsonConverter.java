package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonConverter {

    private final Gson gson;

    public JsonConverter() {

        gson = new GsonBuilder().create();
    }

    public <T extends Object> String convertToJson(T object) {

//        JsonArray jarray = gson.toJsonTree(object).getAsJsonArray();
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.add("cities", jarray);

        return gson.toJson(object);
    }
}
