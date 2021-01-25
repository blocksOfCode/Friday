package DataRetrieval;
/**
 * @author blocksOfCode
 * @version 0.1
 * @since 0.1
 */



//imports
import java.io.*;
import java.util.Scanner;

public class Journal {


    /** @return A String representing the text of a single entry from the .csv journal file */
    public static String getEntryText(String date, String directory) {
        //create new file + scanner
        File filed = new File(directory);
        //scanner
        Scanner scan = null;
        try {
            scan = new Scanner(filed);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String itemTags = scan.nextLine();

        //Locate the specified entry
        while(scan.hasNextLine()) {
            //new line, new entry
            String entryLine = scan.nextLine();
            //if entry date matches queried date, begin retrieving
            if(entryLine.startsWith(date)) {
                int startIndexOfEntry = entryLine.indexOf('\"');
                int lastIndexOfEntry = entryLine.lastIndexOf('\"');

                //2) save a substring of that data to the entry data
                String entryText = entryLine.substring(startIndexOfEntry,lastIndexOfEntry);
                return entryText;
            }

        }


        return "The Specified Entry Cannot Be Found";
    }




}