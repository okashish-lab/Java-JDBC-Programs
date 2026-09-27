
package ok;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentInsert {

    public static void main(String[] args) {

        Connection con = Database.connect();

        if (con == null) {
            System.out.println("Connection Failed!");
            return;
        }

        try {
            // 1. Create Table
            String createTable =
                "CREATE TABLE IF NOT EXISTS students (" +
                "roll_no INT PRIMARY KEY, " +
                "name VARCHAR(100))";

            Statement stmt = con.createStatement();
            stmt.executeUpdate(createTable);

            System.out.println("Table Created!");

            // 2. Insert Student Data
            String sql =
                "INSERT INTO students (roll_no, name) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 101);
            ps.setString(2, "Rahul");

            ps.executeUpdate();

            System.out.println("Student Inserted Successfully!");

            ps.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Database.disconnect();
        }
    }
}

