import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HtmlTest {

    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format","%5$s %n");
        Logger logger = Logger.getAnonymousLogger();

        String filename = "Sample.html";

        logger.log(Level.INFO,"Filename: {0}",filename);
        Path path = Paths.get("data",filename);
        byte[] byteFile = null;
        try {
            byteFile = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String strInput = new String(byteFile, StandardCharsets.UTF_8);

//        logger.log(Level.INFO,"File Content: {0}", strInput);

        Document doc = Jsoup.parse(strInput);

        String text = doc.body().text();

//        logger.log(Level.INFO,text);

        String[] list = text.split(" ");

        logger.log(Level.INFO, String.valueOf(list.length));

//        for(int i = 0; i < list.length; i++) {
//            logger.log(Level.INFO,list[i]);
//        }

        HashSet<String> hashSet = new HashSet<>(Arrays.asList(list));

        ArrayList<String> al = new ArrayList<>(hashSet);
        Collections.sort(al);

        String result = String.join(" ", al);

        logger.log(Level.INFO, result);


    }

}
