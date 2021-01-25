package DataRetrieval;
/**
 * @author blocksOfCode
 * @version 1.0
 * @since 1.0
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

                //save a substring of that data to the entry data
                String entryText = entryLine.substring(startIndexOfEntry,lastIndexOfEntry);
                return entryText;
            }

        }


        return "The Specified Entry Cannot Be Found";
    }

    /** @return A Boolean representing an entry from the .csv journal file was marked as a favorite */
    public static boolean getIsEntryStarred(String date, String directory) {
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

                //save a substring of that data to the entry data
                String entryText = entryLine.substring(startIndexOfEntry,lastIndexOfEntry);
                String starredReplaced = entryLine.replace(entryText, ",");


                String finalKnowledge =  starredReplaced.substring(63, 68);


                if(finalKnowledge.equals("true,")) {
                    return true;
                } else {
                    break;
                }

            }

        }

        return false;

    }

    /** @return A double representing the time an entry was edited in seconds from the .csv journal file */
    public static double getEntryTimeSpentWriting(String date, String directory) {
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



        //there are 6 commas now between us and the data.
        int commasFound = 0;

        String secondsEditedString = "";



        //Locate the specified entry
        while(scan.hasNextLine()) {
            //new line, new entry
            String entryLine = scan.nextLine();
            //if entry date matches queried date, begin retrieving
            if(entryLine.startsWith(date)) {
                int startIndexOfEntry = entryLine.indexOf('\"');
                int lastIndexOfEntry = entryLine.lastIndexOf('\"');

                //save a substring of that data to the entry data
                String entryText = entryLine.substring(startIndexOfEntry,lastIndexOfEntry);

                //note for the future: you cannot edit, replace, etc. any of the text held in a scanned line
                String entryRemovedText = entryLine.replace(entryText, ",");


                for(int i=0; i < entryRemovedText.length(); i++) {

                    if((entryRemovedText.charAt(i) == ',') && (commasFound < 7)) {
                        commasFound++;
                    } else if((entryRemovedText.charAt(i) != ',') && (commasFound == 6)) {
                        secondsEditedString += entryRemovedText.charAt(i);
                    } else if (commasFound == 7) {
                        break;
                    }

                }


            }

        }

        //cast String to double
        double entryEditTime = Double.parseDouble(secondsEditedString);
        //return on the double
        return entryEditTime;

    }

    /** @return A String representing the device an entry was created on from the .csv journal file */
    public static String getEntryCreationDevice(String date, String directory) {
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



        //there are 6 commas now between us and the data.
        int commasFound = 0;

        String editDeviceString = "";



        //Locate the specified entry
        while(scan.hasNextLine()) {
            //new line, new entry
            String entryLine = scan.nextLine();
            //if entry date matches queried date, begin retrieving
            if(entryLine.startsWith(date)) {
                int startIndexOfEntry = entryLine.indexOf('\"');
                int lastIndexOfEntry = entryLine.lastIndexOf('\"');

                //save a substring of that data to the entry data
                String entryText = entryLine.substring(startIndexOfEntry,lastIndexOfEntry);

                //note for the future: you cannot edit, replace, etc. any of the text held in a scanned line
                String entryRemovedText = entryLine.replace(entryText, ",");


                for(int i=0; i < entryRemovedText.length(); i++) {

                    if((entryRemovedText.charAt(i) == ',') && (commasFound < 9)) {
                        commasFound++;
                    } else if((entryRemovedText.charAt(i) != ',') && (commasFound == 8)) {
                        editDeviceString += entryRemovedText.charAt(i);
                    } else if (commasFound == 9) {
                        break;
                    }

                }


            }

        }



        //return on the double
        return editDeviceString;

    }


    //editing time
    //step counter
    //latitude
    //longitude
    //sunrise
    //sunset
    //weather conditions



}