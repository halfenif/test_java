import java.util.StringJoiner;

public class BindRangeTest {

    public static void main(String[] args){
        // 특정 숫자의 분할 Range를 적절한 숫자로 만들기 위한 조건이다.

        System.out.println(String.valueOf(getRange(12345,10)));
        System.out.println("----------");
        System.out.println(String.valueOf(getRange(5,10)));
        System.out.println("----------");
        System.out.println(String.valueOf(getRange(5,1)));
        System.out.println("----------");

    }

    private static long getRange(long lWholCnt, long lSplit) {
        long lRange = lWholCnt / lSplit;
        System.out.println(String.valueOf(lRange));

        StringJoiner sj = new StringJoiner("");
        sj.add(String.valueOf(lWholCnt / lSplit).substring(0,1));

        for(int i = 0; i < String.valueOf(lWholCnt / lSplit).length() -1; i++) {
            sj.add("0");
        }

        return Integer.valueOf(sj.toString());
    }

}
