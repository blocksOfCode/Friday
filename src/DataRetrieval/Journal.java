package DataRetrieval;

//imports
import java.io.*;
import java.util.Scanner;

public class Journal {

    public static String viewEntryText(String date) {
        //create new file + scanner
        File filed = new File("/home/jack/Documents/Data/Journal.csv");
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