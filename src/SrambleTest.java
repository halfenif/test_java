import java.util.Random;
import java.util.StringJoiner;

public class SrambleTest {

    static String strBaseHan = "가나다라마바사아자차카타하";
    static String strBaseNum = "0123456789";
    static String strBaseAbc = "abcdefghijklmnopqrstuvwxyz";

    static int posHan = 0;
    static int posNum = 0;
    static int posAbc = 0;
    public static void main(String[] args) {


        String strSource = "홍길동-123-abC-!@#S";

        StringJoiner sjResult = new StringJoiner("");

        for(int i = 0; i < strSource.length(); i++) {
            String item = String.valueOf(strSource.charAt(i));

            StringJoiner sj = new StringJoiner(":");
            sj.add(item);
            sj.add(String.valueOf(Integer.valueOf(strSource.charAt(i))));

//            sjResult.add(scramble(strSource.charAt(i)));
            sjResult.add(ranStr(strSource.charAt(i)));

            System.out.println(sj.toString());
        }

        System.out.println(sjResult.toString());
    }

    private static String scramble(char charSource) {
        String strResult = "";
        if(Integer.valueOf(charSource) > 123) {
            if(posHan >= strBaseHan.length()) {
                posHan = 0;
            }
            strResult = String.valueOf(strBaseHan.charAt(posHan));
            posHan++;
        } else if(Integer.valueOf(charSource) >= 48 && Integer.valueOf(charSource) <= 57) {
            if(posNum >= strBaseNum.length()) {
                posNum = 0;
            }
            strResult = String.valueOf(strBaseNum.charAt(posNum));
            posNum++;
        } else if(Integer.valueOf(charSource) >= 65 && Integer.valueOf(charSource) <= 122) {
            if(posAbc >= strBaseAbc.length()) {
                posAbc = 0;
            }
            strResult = String.valueOf(strBaseAbc.charAt(posAbc));
            posAbc++;
        } else {
            strResult = String.valueOf(charSource);
        }

        return strResult;
    }

    private static String ranStr(char charSource) {
        Random random = new Random(System.nanoTime());

        String strResult = "";
        if(Integer.valueOf(charSource) > 123) {
            strResult = String.valueOf(strBaseHan.charAt(random.nextInt(strBaseHan.length() -1)));
        } else if(Integer.valueOf(charSource) >= 48 && Integer.valueOf(charSource) <= 57) {
            strResult = String.valueOf(strBaseNum.charAt(random.nextInt(strBaseNum.length() -1)));
        } else if(Integer.valueOf(charSource) >= 65 && Integer.valueOf(charSource) <= 122) {
            strResult = String.valueOf(strBaseAbc.charAt(random.nextInt(strBaseAbc.length() -1)));
        } else {
            strResult = String.valueOf(charSource);
        }

        return strResult;
    }

}
