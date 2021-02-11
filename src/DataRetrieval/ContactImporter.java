package DataRetrieval;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//example code

//C:\Users\jbyer\Downloads\Jack_Byers.csv
//String contactDirectory = scanner.nextLine();
//Contact[] contacts = ContactImporter.getContacts(contactDirectory);
//System.out.println("Name: " + contacts[0].field[0]);


public class ContactImporter {
    /*static void exportContact(String directory, String infoToWrite) {
        File file = new File(directory);


        //Still don't know what try is, but I think it prevents an overload
        try {
            //if file doesn't exist then write to file
            if (!file.exists()) {
                file.createNewFile();
                //initiate file printing object
                PrintWriter pw = new PrintWriter(file);
                //print the info to the file
                pw.print(infoToWrite);
                //close the file
                pw.close();
                //else, display an error message of choice
            } else {
                System.out.println("hello");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static Contact[] getContacts(String directory) {
        File filed = new File(directory);
        //scanner
        Scanner scan = null;
        try {
            scan = new Scanner(filed);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //declare item tags
        String itemTags = scan.nextLine();


        //contact array
        Contact[] contacts = new Contact[contactNumber(directory)];

        //fill the array
        for(int i=0; scan.hasNextLine(); i++) {
            String contact = scan.nextLine();
            contacts[i] = parseData(contact);
        }

        scan.close();

        return contacts;
    }

    //private method that returns the number of contacts in file
    private static int contactNumber(String directory) {
        File filed = new File(directory);
        //scanner
        Scanner scan = null;
        try {
            scan = new Scanner(filed);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //junk
        String itemTags = scan.nextLine();

        //loop to get the number of contacts
        int numOfContacts = 1;
        while(scan.hasNextLine()) {
            numOfContacts++;
            scan.nextLine();
        }

        return numOfContacts;
    }

    //private method that sorts a string into a contact file
    private static Contact parseData(String data) {
        //contact to return
        Contact contact = new Contact();

        //placeholders
        String holdingString = "";
        int entry = 0;

        //parse data
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == ',') {
                contact.field[entry] = holdingString;
                holdingString = "";
                entry++;
            } else {
                holdingString += data.charAt(i);
            }

        }

        return contact;
    }

}
