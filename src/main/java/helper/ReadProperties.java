package helper;

import java.io.*;
import java.util.Properties;

public class ReadProperties {
    private static final String CONFIG_PATH = "resources/config/config.properties";

    public static Properties setConfig() throws IOException {
        Properties configProperties = new Properties();
            FileInputStream inputStream = new FileInputStream(CONFIG_PATH);
            configProperties.load(inputStream);

        return configProperties;
    }
}
