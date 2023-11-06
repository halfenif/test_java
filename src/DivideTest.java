public class DivideTest {
    public static void main(String[] args) {

        int iSource = 52219;

        int iLoopCount = 10;

        int iResult = iSource / iLoopCount;

        System.out.printf("1 Count: %d%s", iResult, System.lineSeparator());


        int iStart = 1;
        int iEnd = 0;
        int i = 0;
        while (iEnd < iSource) {
            i++;
            iEnd = iStart + iResult;

            System.out.printf("%d:%d to %d:%d%s", i, iStart, iEnd, (iEnd-iStart), System.lineSeparator());

            iStart = iEnd;
        }
    }
}
