package Classes;
import java.sql.*;


public class Connections
{
    Connection conn = null;
    try {
    String url = "jdbc:mysql://localhost:3306/autocheck";
    try {
        conn = DriverManager.getConnection(url);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    Statement stmt = null;
    String query = "select * from albums";
    try {
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("title");
            System.out.println(name);
        }
    } catch (SQLException e ) {
        throw new Error("Problem", e);
    } finally {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    } catch (SQLException e) {
    System.out.println("problem");
    } finally {
    try {
        if (conn != null) {
            conn.close();
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
}
