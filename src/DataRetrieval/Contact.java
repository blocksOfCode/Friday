package DataRetrieval;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Contact {
    String grouping = "";
    protected String[] field = new String[43];


    //init
    public Contact() {

    }




    //getter methods
    /** @return A String representing contact first name */
    public String getFirstName() {return field[0];}

    /** @return A String representing contact last name */
    public String getLastName() {return field[1];}

    /** @return A String representing contact display name */
    public String getDisplayName() {return field[2];}

    /** @return A String representing contact nickname */
    public String getNickname() {return field[3];}

    /** @return A String representing contact email */
    public String getEmail() {return field[4];}

    /** @return A String representing contact email2 */
    public String getEmail2() {return field[5];}

    /** @return A String representing contact email3 */
    public String getEmail3() {return field[6];}

    /** @return A String representing contact home phone */
    public String getHomePhone() {return field[7];}

    /** @return A String representing contact business phone */
    public String getBusinessPhone() {return field[8];}

    /** @return A String representing contact cell phone */
    public String getCellPhone() {return field[12];}

    /** @return A String representing contact home street */
    public String getHomeStreet() {return field[13];}

    /** @return A String representing contact home address 2 */
    public String getHomeAddress2() {return field[14];}

    /** @return A String representing contact home city */
    public String getHomeCity() {return field[15];}

    /** @return A String representing contact home state */
    public String getHomeState() {return field[16];}

    /** @return A String representing contact postal code */
    public String getHomePostalCode() {return field[17];}

    /** @return A String representing contact home country */
    public String getHomeCountry() {return field[18];}

    /** @return A String representing contact related name */
    public String getRelatedName() {return field[26];}

    /** @return A String representing contact job title */
    public String getJobTitle() {return field[27];}

    /** @return A String representing contact department */
    public String getDepartment() {return field[28];}

    /** @return A String representing contact organization */
    public String getOrganization() {return field[29];}

    /** @return A String representing contact notes */
    public String getNotes() {return field[30];}

    /** @return A String representing contact birthday */
    public String getBirthday() {return field[31];}

    /** @return A String representing contact anniversary */
    public String getAnniversary() {return field[32];}

    /** @return A String representing contact gender */
    public String getGender() {return field[33];}

    /** @return A String representing contact website */
    public String getWebsite() {return field[34];}

    /** @return A String representing contact website 2 */
    public String getWebsite2() {return field[35];}

    /** @return A String representing contact categories */
    public String getCategories() {return field[36];}

    /** @return A String representing contact username */
    public String getUsername() {return field[37];}

    /** @return A String representing contact username 2 */
    public String getUsername2() {return field[38];}

    /** @return A String representing contact username 3 */
    public String getUsername3() {return field[39];}



    //more complicated get methods
    public String[] getPossibleAccountsUsername(String dataFolderDirectory) {

        String directory = dataFolderDirectory + "/Contacts/UsernameTraces/" + getUsername() + ".txt";

        File filed = new File(directory);

        //scanner
        Scanner scan = null;


        try {
            scan = new Scanner(filed);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        String[] sitesOn = new String[200];


        //fill the array
        for(int i=0; scan.hasNextLine(); i++) {
            String website = scan.nextLine();
            sitesOn[i] = website;
        }


        scan.close();

        return sitesOn;
    }


    public String[] getPossibleAccountsUsername2(String dataFolderDirectory) {

        String directory = dataFolderDirectory + "/Contacts/UsernameTraces/" + getUsername2() + ".txt";

        File filed = new File(directory);
        //scanner
        Scanner scan = null;


        try {
            scan = new Scanner(filed);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        String[] sitesOn = new String[200];


        //fill the array
        for(int i=0; scan.hasNextLine(); i++) {
            String website = scan.nextLine();
            sitesOn[i] = website;
        }


        scan.close();

        return sitesOn;
    }


    public String[] getPossibleAccountsUsername3(String dataFolderDirectory) {

        String directory = dataFolderDirectory + "/Contacts/UsernameTraces/" + getUsername3() + ".txt";

        File filed = new File(directory);
        //scanner
        Scanner scan = null;


        try {
            scan = new Scanner(filed);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        String[] sitesOn = new String[200];


        //fill the array
        for(int i=0; scan.hasNextLine(); i++) {
            String website = scan.nextLine();
            sitesOn[i] = website;
        }


        scan.close();

        return sitesOn;
    }

}