package net.codejava;
import Classes.FirstThread;
import Classes.SecondThread;
import GUI.Welcome;

import java.sql.*;


public class JavaMySQL {
    public static void main(String[] args){

        String[] username_vector = new String[100];
        String[] passwords_vector = new String[100];

        String schema = "test";
        String url = "jdbc:mysql://localhost:3306/autocheck";
        String username="root";
        String password="root";

        FirstThread firstThread=new FirstThread();
        SecondThread secondThread=new SecondThread();



       try {

            //connecting database
            Connection connection= DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully...");




// Get a result set containing all data from test_table


            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT username FROM users");

            int contor = 0;
            while (results.next()) {



                // Get the data from the current row using the column index - column data are in the VARCHAR format

                String data = results.getString(1);

                username_vector[contor] = data;

                System.out.println("Fetching data by column index for row " + results.getRow() + " : " + data);


                // Get the data from the current row using the column name - column data are in the VARCHAR format

                data = results.getString("username");

                System.out.println("Fetching data by column name for row " + results.getRow() + " : " + data);

                contor++;
            }




            System.out.println("\n ");





            ResultSet results2 = statement.executeQuery("SELECT password FROM users");
            while (results2.next()) {


                // Get the data from the current row using the column index - column data are in the VARCHAR format

                String data = results2.getString(1);

                System.out.println("Fetching data by column index for row " + results2.getRow() + " : " + data);


                // Get the data from the current row using the column name - column data are in the VARCHAR format

                data = results2.getString("password");

                System.out.println("Fetching data by column name for row " + results2.getRow() + " : " + data);
            }



/*
            String query ="SELECT * FROM users;";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.close();
            connection.close();
*/
        } catch (SQLException e) {
            System.out.println("Could not connect to the database\n " + e.getMessage());
        }






    }

}
