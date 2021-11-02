package net.codejava;

import java.sql.*;

public class JavaMySQL {
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/autocheck";
        String username="root";
        String password="root";

        try {
            Connection connection= DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully...");

            //DB operations

            String sql="INSERT INTO Users (username,password) VALUES (?,?)";
            PreparedStatement statement=connection.prepareStatement(sql);
            int rows= statement.executeUpdate();
            if(rows>0){
                System.out.println("A row has been inserted...");
            }

            statement.close();
            connection.close();


        }catch (SQLException e){
            System.out.println("Eroare...");
            e.printStackTrace();
        }



    }
}
