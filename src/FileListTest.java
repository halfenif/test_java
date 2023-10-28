import sun.util.resources.LocaleData;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.*;
import java.util.Date;
import java.util.HashSet;


public class FileListTest {

    public static void main(String[] args) {
        String strRoot = "/home";

        try {
            Files.walkFileTree(Paths.get(strRoot),new HashSet<>(), Integer.MAX_VALUE, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                        throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                        throws IOException {

                    LocalDateTime fileDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(file.toFile().lastModified()), ZoneId.systemDefault());
                    if(fileDate.isBefore(LocalDateTime.now().minusDays(30))) {
                        System.out.printf("%s %s%s",fileDate.toString(), file.toString(),System.lineSeparator());
                    }

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc)
                        throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                        throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
