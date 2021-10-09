package printer;

import printer.PrinterProperties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Seeker {
    private File[] readPath() {
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
    private void printFiles(File[] files){

    }
    private void killThoseFiles(File[] files){
        for (File file: files) {
            try{
                if(!file.delete()){
                    throw new IOException();
                }
                else{
                    System.out.println("puto");
                }
            }
            catch (IOException e){
                System.out.println("cannot find or erase file: "+e);
            }
        }
    }
    public void executeOrder66 () {
        do {
            File[] files = readPath();
            killThoseFiles(files);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (true);

    }
}
