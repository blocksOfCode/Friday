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
    public String getFirstName() {return field[0];}

    public String getLastName() {return field[1];}

    public String getDisplayName() {return field[2];}

    public String getNickname() {return field[3];}

    public String getEmail() {return field[4];}

    public String getEmail2() {return field[5];}

    public String getEmail3() {return field[6];}

    public String getHomePhone() {return field[7];}

    public String getBusinessPhone() {return field[8];}

    public String getCellPhone() {return field[12];}

    public String getHomeStreet() {return field[13];}

    public String getHomeAddress2() {return field[14];}

    public String getHomeCity() {return field[15];}

    public String getHomeState() {return field[16];}

    public String getHomePostalCode() {return field[17];}

    public String getHomeCountry() {return field[18];}

    public String getRelatedName() {return field[26];}

    public String getJobTitle() {return field[27];}

    public String getDepartment() {return field[28];}

    public String getOrganization() {return field[29];}

    public String getNotes() {return field[30];}

    public String getBirthday() {return field[31];}

    public String getAnniversary() {return field[32];}

    public String getGender() {return field[33];}

    public String getWebsite() {return field[34];}

    public String getWebsite2() {return field[35];}

    public String getCategories() {return field[36];}

    public String getUsername() {return field[37];}

    public String getUsername2() {return field[38];}

    public String getUsername3() {return field[39];}



    //more complicated get methods
    public String[] getAccountsOn(String dataFolderDirectory) {

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

}