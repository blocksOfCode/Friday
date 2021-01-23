/****************************************************************************************
Author: blocksOfCode
  Date: 2021-23-1
 Notes: This Package is meant to read in and allow for the easy use of Apple Health data
 imported from the health app in .csv format. All data is accessible using getter methods
 ****************************************************************************************/
package DataRetrieval;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Health {

    //class initializer
    public Health(String directory) {
        //create new file + scanner
        File file = new File(directory);
        //scanner
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }





    }
}
