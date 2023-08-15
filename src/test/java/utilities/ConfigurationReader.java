package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static final Properties config;

    static {
        config = new Properties();
        try (FileInputStream file = new FileInputStream("configuration.properties")) {
            config.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the value of the specified key from the configuration properties.
     *
     * @param key the key to retrieve the value for
     * @return the value associated with the key, or null if the key is not found
     */
    public static String getProperty(String key) {
        return config.getProperty(key);
    }
}

