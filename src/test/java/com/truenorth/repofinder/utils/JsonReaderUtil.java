package com.truenorth.repofinder.utils;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class JsonReaderUtil {

    public static <T> T getObjectFromJson(String jsonFile, Class<T> type) {
        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(Paths.get(Config.getTestDataPath() + jsonFile))) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonObject getJsonObject(String jsonFile) {
        Gson gson = new Gson();
        try (Reader reader = Files.newBufferedReader(Paths.get(Config.getTestDataPath() + jsonFile))) {
            return  JsonParser.parseReader(reader).getAsJsonObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}