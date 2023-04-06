import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.StringJoiner;
import java.util.UUID;

public class FileWriteTest {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("key1", "val1");
        map.put("key2", "val2");
        map.put("key3", "val3");
        map.put("key4", "val4");

        writeFile("ID12345", map);
    }



    private static void writeFile(String id, HashMap map) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter iso = DateTimeFormatter.ISO_DATE;

        StringJoiner sj = new StringJoiner("_");
        sj.add(now.format(iso).toString());
        sj.add(id);
        sj.add(UUID.randomUUID().toString());

        Path path = Paths.get("/temp", sj.toString());
        File f = path.toFile();
        try {
            f.createNewFile();
        } catch (IOException e) {
            return;
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write(map.toString());
            writer.close();
        } catch (IOException e) {
            return;
        }

        return;
    }
}
