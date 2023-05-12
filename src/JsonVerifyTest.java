import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonVerifyTest {
    public static void main(String[] args) {
        String strJson = "---";


        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(strJson);

        try {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
        } catch (IllegalStateException e) {
            System.out.println("Not JSON Object");
        }
    }
}
