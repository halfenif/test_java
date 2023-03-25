import java.sql.*;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

public class HashMapAndDate {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        Connection conn = null;
        Statement stat = null;
        String sql = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.252:1521:xe","system","oracle");
            stat = conn.createStatement();

            sql = "select sysdate from dual";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                map.put("oracle date value", rs.getObject(1));
                map.put("oracle date simple name", rs.getObject(1).getClass().getSimpleName());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        Date date = new Date();
        date.setTime(new Date().getTime());
        map.put("java date value", date);
        map.put("java date simple name", date.getClass().getSimpleName());

        Timestamp timestamp = Timestamp.from(Instant.now());
        map.put("java timestamp value", timestamp);
        map.put("java timestamp simple name", timestamp.getClass().getSimpleName());


        System.out.println(map);

        //Result
        //{oracle date simple name=Timestamp, java timestamp simple name=Timestamp, java timestamp value=2023-03-25 09:40:09.886, oracle date value=2023-03-25 00:40:09.0, java date value=Sat Mar 25 09:40:09 KST 2023, java date simple name=Date}
    }
}
