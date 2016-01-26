package renamer;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 1.0
 * @author Seijas
 */
public class Methods {
    
    public static boolean isNumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean isFolder(String url) {
        File folder = new File(url);
        if (folder.isDirectory()) {
            File[] listOfFiles = folder.listFiles();
            return listOfFiles.length >= 1;
        } else
            return false;
    }
    
    public static void listFiles(String url) {
        
        File folder = new File(url);
        File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles) {
            if(!file.isDirectory()) {
                try {
                    System.out.println(file.getCanonicalPath());
                } catch (IOException ex) {
                    Logger.getLogger(Methods.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static String setStringNumber(int number, int lenght) {
        String newNum = String.valueOf(number);
        while ( newNum.length() < lenght ) 
            newNum = '0' + newNum;
        return newNum;
    }
    
    public static String getExtension(String url) {
        String extension = "";
        int i = url.lastIndexOf('.');
        int p = Math.max(url.lastIndexOf('/'), url.lastIndexOf('\\'));
        if (i > p)
            extension = url.substring(i);
        return extension;
    }
}
