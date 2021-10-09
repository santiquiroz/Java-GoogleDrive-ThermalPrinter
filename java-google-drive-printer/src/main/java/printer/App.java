package printer;

import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            if(args.length > 0){
                PrinterProperties.loadProperties(args[0]);
            }
            else{
                PrinterProperties.loadProperties();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(PrinterProperties.get("puto"));
    }
}
