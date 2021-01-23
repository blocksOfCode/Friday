package Journal;

//imports
import java.io.*;
import java.util.Scanner;

public class Journal {
    String itemTags;
    int totalEntries;
    String[] rawData;
    Entry[] entries;


    //create the new journal and all that entails
    public void createJournal(String directory) {


        //create new file + scanner
        File filed = new File(directory);
        //scanner
        Scanner scan = null;
        try {
            scan = new Scanner(filed);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //declare item tags and store to final string
        itemTags = scan.nextLine();




        //import all the data on a per line basis
        int placeholder = 0;
        while(scan.hasNextLine()) {
            rawData[placeholder] = scan.nextLine();
            placeholder++;
        }
        totalEntries = placeholder;


        //close the scanner
        scan.close();



        //now take all the gathered data and put into something usable
        for (int i = 0; i < rawData.length; i++) {
            entries[i] = parseData(rawData[i]);
        }

        //that should be it... right?









    }





    private static Entry parseData(String data) {
        //contact to return
        Entry parsed = new Entry();

        //placeholders
        String holdingString = "";
        int entry = 0;

        //parse data
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == ',') {
                parsed.data[entry] = holdingString;
                holdingString = "";
                entry++;
            } else {
                holdingString += data.charAt(i);
            }

        }

        return parsed;
    }


}
