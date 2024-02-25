package utils.props;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class QaProps {

    private static Properties properties;

    public static void init() {
        if (properties == null){
            properties = new Properties();
            try {
                properties.load(new FileReader("src/test/resources/QaProperties.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
