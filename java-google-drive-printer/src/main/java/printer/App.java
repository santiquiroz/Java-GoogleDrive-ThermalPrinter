package printer;

import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        try {
            if(args.length > 0){
                PrinterProperties.loadProperties(args[0]);
            }
            else{
                PrinterProperties.loadProperties();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        finally {
            new Seeker().executeOrder66();
        }
    }
}
