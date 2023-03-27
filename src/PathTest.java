import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest {
    public static void main(String[] args) {
        Path base = Paths.get("C:\\temp");

        Path source = base.resolve("source");
        source = source.resolve("새 폴더");
        source = source.resolve("소스.txt");

        Path target = base.resolve("target\\새 폴더\\타겟.txt");

        File sourceFile = source.toFile();
        File targetFile = target.toFile();


        try {
            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
