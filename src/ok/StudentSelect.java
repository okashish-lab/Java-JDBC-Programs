package ok;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentSelect {
    public static void main(String[] args) {

        Connection con = Database.connect();

        if (con == null) return;

        try {
            String sql = "SELECT * FROM students";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                    "Roll No: " + rs.getInt("roll_no")
                );
                System.out.println(
                    "Name: " + rs.getString("name")
                );
                System.out.println("----------------");
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database.disconnect();
        }
    }
}
