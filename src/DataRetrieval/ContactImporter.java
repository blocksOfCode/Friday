package DataRetrieval;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

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


    /**@returns void, but updates the Accounts.csv file*/
    //USE DATA DIRECTORY. ANYTHING ELSE WILL FAIL
    public static void updateAccounts(Contact[] contacts, String directory) {

        for(Contact i:contacts) {
            String id = i.getID();

            if(id == null) {
                continue;
            }





            if(new File(directory + "Contacts/UsernameTraces/" + id + ".txt").exists()) {
                File file = new File(directory + "Contacts/UsernameTraces/" + id + ".txt");

                Scanner scan = null;
                try {
                    scan = new Scanner(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                //garbage
                String itemTags = scan.nextLine();


                //website array
                String[] websites = new String[200];

                //fill the array
                for(int j=0; scan.hasNextLine(); j++) {
                    String website = scan.nextLine();
                    String website1 = website.replace("https://", "");
                    websites[j] = website1;
                }

                scan.close();


                //append data to Accounts.csv
                Path path = Paths.get(directory + "Contacts/Accounts.csv");
                String thing = id + ",";

                try {
                    Files.write(path, thing.getBytes(), StandardOpenOption.APPEND);  //Append mode
                } catch (IOException e) {
                    e.printStackTrace();
                }

                for(String str:websites) {
                    try {
                        Files.write(path, str.getBytes(), StandardOpenOption.APPEND);  //Append mode
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

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


        contact.field[37] = holdingString;


        return contact;
    }

}
