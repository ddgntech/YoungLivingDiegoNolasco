package Utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final String propFileName = "src/test/resources/user.properties";
    public static Properties prop;

    public static String readProperty(String property) {
        try {
            if (prop == null){
                prop = new Properties();
            }
            FileReader fileReader = new FileReader(propFileName);
            prop.load(fileReader);
            return prop.getProperty(property);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
