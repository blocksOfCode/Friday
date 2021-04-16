import DataRetrieval.Contact;
import DataRetrieval.ContactImporter;
import DataRetrieval.Journal;

import java.io.File;
import java.util.Scanner;


/*
This class is not by any means going to be the final iteration of Friday. This class is only for testing purposes
and should be treated as such.

Update Log 4-16-21:
I am renaming this project to the FRIDAY Bedrock Layer. It will serve as a basic command line interface to expedite
data transfer to and from the the mainframe of FRIDAY, which will be in python. Yes I know. As much as I hate python
for this it is the easiest and best language to utilize. I will integrate everything I have learned in Java into this
interface.
 */
public class Main {
    static final String name = "Jackson";
    static final String directory = "/home/jack/Documents/Data/";
    public static void main(String[] args) {
        //init values

        Contact[] contacts = ContactImporter.getContacts(directory + "Contacts/Contacts.csv");


        //Use cases for finished methods
        //String thisThing = Journal.getEntryText("2019-12-24", directory);
        //boolean starry = Journal.getIsEntryStarred("2019-12-24", directory);
        //double timeEdited = Journal.getEntryTimeSpentWriting("2019-12-24", directory);



        //String creationDevice = Journal.getEntryCreationDevice("2019-12-24", directory + "Journal.csv");
        //System.out.println(creationDevice);
        //System.out.println(contacts[38].getHomePhone());

        //ContactImporter.updateAccounts(contacts, directory);

        Scanner scanner = new Scanner(System.in);



        //Interface
        boolean shouldEnd = false;
        System.out.println("Command Interface enabled.");
        System.out.println("Welcome back " + name);
        while(!shouldEnd) {
            System.out.println("========================================");
            System.out.println("        FRIDAY Bedrock Interface        ");
            System.out.println("========================================");
            System.out.println("1) Import Data");
            System.out.println("2) Export Data");
            System.out.println("3) View Data");
            System.out.println("4) Legacy Smart Assistant");
            System.out.println("5) Documentation");
            System.out.println("6) Protocols");
            System.out.println("7) Exit");
            System.out.println("========================================");
            System.out.println(">");
            String interface1 = scanner.next();


            switch (interface1) {
                case "6":
                    System.out.println("========================================");
                    System.out.println("                Protocols               ");
                    System.out.println("========================================");
                    System.out.println("1) Houseparty Protocol");
                    System.out.println("2) Vex Protocol");
                    System.out.println("3) Back");
                    System.out.println("========================================");
                    System.out.println(">");
                    String interface2 = scanner.next();
                    switch (interface2) {
                        case "1":
                            //Houseparty: Full lockdown and all security activated for immediate incursion threat
                            break;
                        case "2":
                            //Vex: Burn everything to hell. While not extremely secure its better than nothing
                            File file = new File(directory);
                            Protocols.Vex(file);
                            System.out.println("Files deleted........");
                            break;
                        case "3":
                            break;
                    }
                    break;
                case "7":
                    System.out.println("Goodbye " + name);
                    shouldEnd = true;
                    break;

            }

        }




    }
}
