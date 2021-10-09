package printer;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            PrinterProperties.loadProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(PrinterProperties.get("puto"));
    }
}
