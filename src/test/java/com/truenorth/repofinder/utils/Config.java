package com.truenorth.repofinder.utils;

import lombok.extern.slf4j.Slf4j;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Properties;


@Slf4j
public class Config {
    private static final Properties PROPS = new Properties();
    public static final String CONFIG_FILE = "config.properties";
    public static final String BASE_PATH = System.getProperty("user.dir");

    public static void loadConfig() throws IOException {
        String configPath = getConfigPath(CONFIG_FILE);
        PROPS.load( Files.newInputStream(Path.of(configPath)));
    }

    public static String getResourcesPath() {
        return BASE_PATH + "/src/test/resources/";
    }

    public static String getConfigPath(String filename) {
        return getResourcesPath().concat(filename);
    }

    public static String getTestDataPath(){
        return getResourcesPath().concat("testdata/");
    }

    private static String getVariable(String name) {
        return Objects.nonNull(System.getenv(name)) ?
                System.getenv(name) : PROPS.getProperty(name);
    }

    public static String getBaseUrl() {
        return getVariable("baseurl");
    }


    public static String getBrowser() {
        return getVariable("browser").toLowerCase().trim();
    }


    public static boolean getHeadless() {
        return Boolean.parseBoolean(PROPS.getProperty("headless"));
    }

    public static Integer getTimeout() {
        String timeout = getVariable("timeout");
        return Integer.parseInt(timeout);
    }


}

