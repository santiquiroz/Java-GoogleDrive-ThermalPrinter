package printer;

import printer.PrinterProperties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;

public class Seeker {
    public File[] readPath() {
        File [] files = null;
        try {
            File dir = new File(PrinterProperties.get("printer_path"));
            files = dir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith("."+ PrinterProperties.get("file_extension"));
                }
            });

        }
        catch (Exception exc){
            System.out.println(exc);
            System.exit(1);
        }
        finally {
            return(files);
        }
    }
    public void executeOrder66 () {
        File[] files = readPath();
        for (File file: files) {
            System.out.println(file);
        }
    }
}
