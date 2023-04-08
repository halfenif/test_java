import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;

public class Base64Test {
    public static void main(String[] args) {
        String strBase64 = "eyJ0aXRsZSI6Iu2DgOydtO2LgOyeheuLiOuLpC4iLCJib2R5Ijoi67O466y4IOyyqyDspITsnoXri4jri6QuXG7rs7jrrLgg65GQIOuyiOynuCDspITsnoXri4jri6QuXG7rs7jrrLgg7IS4IOuyiOynuCDspITsnoXri4jri6QuXG7rs7jrrLgg64SkIOuyiOynuCDspITsnoXri4jri6QuXG7rs7jrrLgg64uk7ISvIOuyiOynuCDspITsnoXri4jri6QuXG4iLCJhcnJheURhdGEiOlt7ImlucHV0QXJyYXlEYXRhIjoiQXJyYXkgMeuyiOyeheuLiOuLpC4ifSx7ImlucHV0QXJyYXlEYXRhIjoiQXJyYXkgMuuyiOyeheuLiOuLpC4ifSx7ImlucHV0QXJyYXlEYXRhIjoiQXJyYXkgM+uyiOyeheuLiOuLpC4ifSx7ImlucHV0QXJyYXlEYXRhIjoiQXJyYXkgNOuyiOyeheuLiOuLpC4ifSx7ImlucHV0QXJyYXlEYXRhIjoiQXJyYXkgNeuyiOyeheuLiOuLpC4ifV19";

        byte[] byteJson = Base64.getDecoder().decode(strBase64);

        String strJson = new String(byteJson, StandardCharsets.UTF_8);
        System.out.println(strJson);


        Gson gson = new Gson();
        HashMap map = new HashMap();
        map = (HashMap)gson.fromJson(strJson,map.getClass());

        System.out.println(map.toString());
    }
}
