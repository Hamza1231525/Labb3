import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/labb3";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM person");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("person_id") + " " +
                                rs.getString("first_name") + " " +
                                rs.getString("last_name") + " " +
                                rs.getDate("dob") + " " +
                                rs.getDouble("income")
                );
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}