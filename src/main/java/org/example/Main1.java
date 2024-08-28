package org.example;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Main1 {
    public static void main(String[] args) {
        String path = "jdbc:mysql://localhost/table";
        String userName = "root";
        String password = "";
//      String name = "Amit";
      String name = "'OR 1=1 OR name = '";
      String query = "SELECT * FROM emp WHERE Name = ? AND Age = ?";
        try(
                Connection connection = DriverManager.getConnection(path, userName, password);
                PreparedStatement stmt = connection.prepareStatement(query);
        ) {
            stmt.setString(1, name);
            stmt.setInt(2, 10);

            ResultSet resultSet  = stmt.executeQuery();
            while(resultSet.next()) {
                System.out.println(
                        resultSet.getInt(1) + "\t" +
                        resultSet.getString(2) + "\t" +
                        resultSet.getInt(3)
                );
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
