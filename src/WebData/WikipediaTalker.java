package WebData;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class WikipediaTalker {



    public static void main(String[] args) {

        String searchText = "tom hanks";

        try {

            URL url = new URL("https://en.wikipedia.org/w/api.php?action=opensearch&search=" + searchText.replace(" ", "_") + "&limit=1&format=json&exintro=1");
            String jsonFromServer = "";

            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()))) {
                String line = null;
                while (null != (line = br.readLine())) {
                    jsonFromServer += line;

                }
                //debug code don't mind me
                System.out.println(jsonFromServer);
                }

            //now sort that data into a String Array
            String correctDirectory = "";
            int quoteCount = 0;
            boolean acceptingChars = false;
            for(int i=0; i < jsonFromServer.length(); i++) {
                if(jsonFromServer.charAt(i) == '"' && quoteCount == 6) {
                    quoteCount++;
                    acceptingChars = true;
                } else if(jsonFromServer.charAt(i) == '"' && quoteCount != 6) {
                    quoteCount++;
                    acceptingChars = false;
                }

                if (acceptingChars) {
                    correctDirectory += jsonFromServer.charAt(i);
                }
            }


            //remove "
            correctDirectory = correctDirectory.substring(1);

            //TODO remove this once done debugging
            System.out.println(correctDirectory);















            //one more time around the horn
            URL finalULR = new URL(correctDirectory);
            String text = "";
            try (BufferedReader br = new BufferedReader(new InputStreamReader(finalULR.openConnection().getInputStream()))) {
                String line = null;
                while (null != (line = br.readLine())) {
                    line = line.trim();
                    if (!line.startsWith("<p>")) {
                            //&& !line.startsWith("{")
                            //&& !line.startsWith("}")
                            //&& !line.startsWith("<center>")
                            //&& !line.startsWith("---")) {
                        text += line;
                    }
                    if (text.length() > 200) {
                        break;
                    }
                }
            }
            System.out.println("text = " + text);



        } catch (IOException e) {
            System.out.println("Something is Wrong if you are seeing this. Keep trying you got this!");
            e.printStackTrace();
        }

    }
}
