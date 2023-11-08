import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.StringJoiner;

public class RandomTest {

    public static void main(String[] args) {
        rand();
        srand();
    }

    private static void rand() {
        Random random = new Random();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);

        StringJoiner sj = new StringJoiner(",");
        for(byte b: bytes) {
            sj.add(String.format("%02x",b&0xff));
        }
        System.out.printf("[%s][%s]%s",new String(bytes), sj.toString(), System.lineSeparator());
    }

    private static void srand() {
        SecureRandom random = null;
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);

        StringJoiner sj = new StringJoiner(",");
        for(byte b: bytes) {
            sj.add(String.format("%02x",b&0xff));
        }
        System.out.printf("[%s][%s]%s",new String(bytes), sj.toString(), System.lineSeparator());
    }
}
