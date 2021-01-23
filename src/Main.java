import Journal.*;

public class Main {

    public static void main(String[] args) {


        String directory = "/home/jack/Downloads/Journal.csv";

        Entry[] theGoods = Journal.createJournal(directory);

        String textFromEntry = theGoods[0].getText();

        System.out.println("DID IT WORK? " + textFromEntry);

    }
}
