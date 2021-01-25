import DataRetrieval.Journal;



/*
This class is not by any means going to be the final iteration of Friday. This class is only for testing purposes
and should be treated as such.
 */
public class Main {

    public static void main(String[] args) {

        final String directory = "/home/jack/Documents/Data/Journal.csv";




        String thisThing = Journal.getEntryText("2019-12-24", directory);

        System.out.println(thisThing);



    }
}
