import DataRetrieval.Contact;
import DataRetrieval.ContactImporter;
import DataRetrieval.Journal;

import java.io.IOException;


/*
This class is not by any means going to be the final iteration of Friday. This class is only for testing purposes
and should be treated as such.
 */
public class Main {

    public static void main(String[] args) {
        //init values
        final String directory = "/home/jack/Documents/Data/";
        Contact[] contacts = ContactImporter.getContacts(directory + "Contacts/Contacts.csv");


        //Use cases for finished methods
        //String thisThing = Journal.getEntryText("2019-12-24", directory);
        //boolean starry = Journal.getIsEntryStarred("2019-12-24", directory);
        //double timeEdited = Journal.getEntryTimeSpentWriting("2019-12-24", directory);



        String creationDevice = Journal.getEntryCreationDevice("2019-12-24", directory + "Journal.csv");

        System.out.println(creationDevice);

        System.out.println(contacts[38].getHomePhone());

        //lets try this
        String[] accountTry = contacts[38].getPossibleAccountsUsername(directory);
        for(String e : accountTry) {
            System.out.println(e);
        }





        //this runs an external python file for more complicated stuff
        String command = "python3 /home/jack/sherlock/sherlock noobmaster69";
        try {
            Process p = Runtime.getRuntime().exec(command);
            System.out.println("This code executed");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
