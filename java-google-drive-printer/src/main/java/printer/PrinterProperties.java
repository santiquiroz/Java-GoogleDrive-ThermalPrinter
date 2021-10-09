package printer;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class PrinterProperties {

    private static InputStream inputStream;

    private static Properties prop;

    public static void loadProperties(String propPath) throws IOException {

        try {
            prop = new Properties();
            String propFileName = propPath;

            inputStream = new FileInputStream(propFileName);

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

    public static void loadProperties() throws IOException {

        try {
            prop = new Properties();
            String propFileName = "application.properties";

            inputStream = PrinterProperties.class.getClassLoader().getResourceAsStream(propFileName);

            //use this if you want to load properties from a config file that could be edited for the end user

            /*URL url = PrinterProperties.class.getClassLoader().getResource(propFileName);

            File f = new File(url.getPath());
            // Populates the array with names of files and directories
            String[] pathnames = f.list();

            // For each pathname in the pathnames array
            for (String pathname : pathnames) {
                // Print the names of files and directories
                System.out.println(pathname);
            }
            inputStream = new FileInputStream(propFileName);

             */
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
