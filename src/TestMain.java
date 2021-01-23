import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
        //create new file + scanner
        File filed = new File("/home/jack/Downloads/Journal.csv");
        //scanner
        Scanner scan = null;
        try {
            scan = new Scanner(filed);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //declare item tags
        String itemTags = scan.nextLine();

        //BETA NOTE: this code snippet is meant to test what data I can get from a single line
        String entry1 = scan.nextLine();

        //close the scanner
        scan.close();



        //BETA NOTE: Parse data and see what will need to be assigned to the file
        String parseThing = "";

        String[] finalEntry = new String[46];

        int entry = 0;



         /*
        Okay, I think I know what to do now.
        1) find the quotes and save their actual spots
        2) save a substring of that data to the entry data
        3) replace every character in between the quotes with a space
        4) Done (finally)!
         */


        //1) find the quotes and save their actual spots
        int startIndexOfEntry = entry1.indexOf('"');
        int lastIndexOfEntry = entry1.lastIndexOf('"');

        //2) save a substring of that data to the entry data
        String entryText = entry1.substring(startIndexOfEntry,lastIndexOfEntry);

        //3) replace every character in between the quotes with a space
        entry1 = entry1.replace(entry1.substring(startIndexOfEntry,lastIndexOfEntry+1)," no data ");

        //4) Done (finally)!

        //parse data
        for (int j = 0; j < entry1.length(); j++) {
            if (entry1.charAt(j) == ',') {
                finalEntry[entry] = parseThing;
                parseThing = "";
                entry++;
            } else {
                parseThing += entry1.charAt(j);
            }

        }

        //that should be it... right?

        //print out LITERALLY EVERYTHING to the console
        for (int i = 0; i < finalEntry.length; i++) {
            System.out.println(finalEntry[i]);

        }



        //println
        System.out.println("\"this is a quote\"");
    }

}



