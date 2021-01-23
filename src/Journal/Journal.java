package Journal;

//imports
import java.io.*;
import java.util.Scanner;

public class Journal {
    Entry[] entries;


    //create the new journal and all that entails
    public static Entry[] createJournal(String directory) {

        //create new file + scanner
        File filed = new File(directory);
        //scanner
        Scanner scan = null;
        try {
            scan = new Scanner(filed);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //these are the item tags... this is worthless!
        String itemTags = scan.nextLine();


        String[] rawData = new String[numberOfEntries(directory)];



        //import all the data on a per line basis
        int placeholder = 0;
        while(scan.hasNextLine()) {
            rawData[placeholder] = scan.nextLine();
            placeholder++;
        }
        int totalEntries = placeholder;


        //close the scanner
        scan.close();


        //entry array to return
        Entry[] entries = new Entry[totalEntries];

        //now take all the gathered data and put into something usable
        for (int i = 0; i < rawData.length; i++) {
            entries[i] = parseData(rawData[i], numberOfEntries(directory));
        }

        //that should be it... right?






        return entries;



    }





    private static Entry parseData(String data, int entryNum) {
        //storage array for data
        String[] processedData = new String[entryNum];


        //placeholders
        String holdingString = "";
        String secondaryHoldingString = "";
        int holdingInt = 0;








        //parse data
        for (int j = 0; j < data.length(); j++) {

            //if here
            if ((data.charAt(j) == ',')) {


                processedData[holdingInt] = holdingString;
                holdingString = "";
                holdingInt++;
            } else {
                holdingString += data.charAt(j);
            }


        }

        Entry parsed = new Entry(processedData);

        return parsed;
    }



    private static int numberOfEntries(String directory) {
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

        int placeholder = 0;
        while(scan.hasNextLine()) {
            scan.nextLine();
            placeholder++;
        }
        return placeholder;
    }


}
