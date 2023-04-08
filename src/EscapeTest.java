import org.apache.commons.text.StringEscapeUtils;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EscapeTest {
    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format","%5$s %n");
        Logger logger = Logger.getAnonymousLogger();

//        String filename = "utf8.txt";
        String filename = "sample.json";

        logger.log(Level.INFO,"Filename: {0}",filename);
        Path path = Paths.get("data",filename);
        byte[] byteFile = null;
        try {
            byteFile = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String strInput = new String(byteFile);

        logger.log(Level.INFO,"String:\n{0}",strInput);
        logger.log(Level.INFO,"Java:\n{0}",StringEscapeUtils.escapeJava(strInput));
        logger.log(Level.INFO,"Ecma:\n{0}",StringEscapeUtils.escapeEcmaScript(strInput));
        logger.log(Level.INFO,"Html4:\n{0}",StringEscapeUtils.escapeHtml4(strInput));
        logger.log(Level.INFO,"Json:\n{0}",StringEscapeUtils.escapeJson(strInput));
    }
}
