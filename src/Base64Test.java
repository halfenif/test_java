import com.google.gson.Gson;
import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base64Test {
    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format","%5$s %n");
        Logger logger = Logger.getAnonymousLogger();

        String filename = "base64.txt";

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
        byte[] byteJson = Base64.getDecoder().decode(strInput);

        String strJson = new String(byteJson, StandardCharsets.UTF_8);
        logger.log(Level.INFO,"JSON String:\n{0}",strJson);
        logger.log(Level.INFO,"Json Escape:\n{0}", StringEscapeUtils.escapeJson(strJson));

        Gson gson = new Gson();
        HashMap map = new HashMap();
        map = (HashMap)gson.fromJson(strJson,map.getClass());
        logger.log(Level.INFO,"MAP:\n{0}",map.toString());
    }
}
