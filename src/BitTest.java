public class BitTest {

    private static final int ATTACH_FILE_INPUT_OVERWRITE_YES = 1; //0001
    private static final int ATTACH_FILE_INPUT_MOVE_YES = 2; //0010
    private static final int ATTACH_FILE_INPUT_ZIP_YES = 4; //0100
    private static final int ATTACH_FILE_INPUT_PASSWORD_YES = 10; //1000
    public static void main(String[] args) {

        int testValue;


        testValue = 10;
        if(checkBit(testValue,ATTACH_FILE_INPUT_OVERWRITE_YES)) {
            System.out.println("True: ATTACH_FILE_INPUT_OVERWRITE_YES: ".concat(String.valueOf(testValue)));
        } else {
            System.out.println("False: ATTACH_FILE_INPUT_OVERWRITE_YES: ".concat(String.valueOf(testValue)));
        }

    }

    private static boolean checkBit(int inBit, int checkBit) {
        if((checkBit & inBit) == checkBit) {
            return true;
        }
        return false;
    }
}
