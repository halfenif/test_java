import java.time.LocalTime;

public class DurationTest {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime end = LocalTime.now().plusMinutes(1);

        while (now.isBefore(end)) {
            now = LocalTime.now();

            System.out.println(now);
        }

        System.out.println("--------------------------END");

    }
}
