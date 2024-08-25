package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseUriFactory {
    private Properties properties;

    public BaseUriFactory() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Sorry, unable to find config.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Failed to load configuration");
        }
    }

    public String getBaseUri(String apiName) {
        return properties.getProperty(apiName + ".baseUri");
    }
}

