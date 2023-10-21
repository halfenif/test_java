import java.sql.*;
import java.time.Instant;
import java.util.*;
import java.util.Date;

public class HashMapAndDate {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        Connection conn = null;
        Statement stat = null;
        String sql = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","test","test");
            stat = conn.createStatement();

            sql = "select sysdate from dual";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                map.put("oracle SYSDATE value", rs.getObject(1));
                map.put("oracle SYSDATE simple name", rs.getObject(1).getClass().getSimpleName());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        Date date = new Date();
        date.setTime(new Date().getTime());
        map.put("java Date value", date);
        map.put("java Date simple name", date.getClass().getSimpleName());

        Timestamp timestamp = Timestamp.from(Instant.now());
        map.put("java Timestamp value", timestamp);
        map.put("java Timestamp simple name", timestamp.getClass().getSimpleName());


        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        Iterator<String> keys = keySet.iterator();
        while(keys.hasNext()) {
            String key = keys.next();
            System.out.printf("%s : %s %s", key, map.get(key), System.lineSeparator());
        }


        //Result
//        java Date simple name : Date
//        java Date value : Sat Oct 21 10:25:21 KST 2023
//        java Timestamp simple name : Timestamp
//        java Timestamp value : 2023-10-21 10:25:21.367
//        oracle SYSDATE simple name : Timestamp
//        oracle SYSDATE value : 2023-10-21 10:25:21.0
    }
}
