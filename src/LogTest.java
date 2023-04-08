import org.apache.commons.text.StringEscapeUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogTest {
    public static void main(String[] args) {
//        System.setProperty("java.util.logging.SimpleFormatter.format","[%1$tF %1$tT] [%4$-7s] %5$s %n");
        System.setProperty("java.util.logging.SimpleFormatter.format","%5$s %n");
        Logger logger = Logger.getAnonymousLogger();
        logger.setLevel(Level.ALL);

        logger.log(Level.INFO,"msg: {0},{1}", new String[]{"1","2"});


    }
}
