import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class PathTest {
    public static void main(String[] args) {
        Path base = Paths.get("/temp");

        Path source = Paths.get(base.toString(), "source/새 폴더");
        source = source.resolve("소스.txt");

        Path target = Paths.get(base.toString(),"target/딴 폴더/타겟.txt");


        if(!source.toFile().exists()) {
            System.out.println("소스파일이 없습니다.");
            return;
        }

        if(!target.getParent().toFile().exists()) {
            System.out.println("타겟 폴더가 없습니다.");
            return;
        }
        
        if(target.toFile().exists()) {
            System.out.println("타겟에 동일 파일이 존재합니다.");
            return;            
        }



//, StandardCopyOption.REPLACE_EXISTING
        try {
            Files.move(source, target);
        } catch (NoSuchFileException e) {
            System.out.println("시도는 했으나 파일이 없습니다.");
        } catch (FileAlreadyExistsException e) {
            System.out.println("대상 파일이 이미 존재합니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
