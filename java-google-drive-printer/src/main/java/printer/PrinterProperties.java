package printer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PrinterProperties {

    private static InputStream inputStream;

    private static Properties prop;

    public static void loadProperties() throws IOException {
        try {
            prop = new Properties();
            String propFileName = "application.properties";

            inputStream = PrinterProperties.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }

    public static String get(String property){
        return(prop.getProperty(property));
    }

    public PrinterProperties(){

    }
}
