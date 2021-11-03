package net.codejava;
import Classes.FirstThread;
import Classes.SecondThread;
import GUI.Welcome;
import java.sql.*;


public class JavaMySQL {
    public static String[] username_vector = new String[101];
    public static String[] passwords_vector = new String[101];
    public static int[] mechanic_status = new int[101];

    public static void main(String[] args){

        String schema = "test";
        String url = "jdbc:mysql://localhost:3306/autocheck";
        String username="root";
        String password="root";

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



                System.out.println("Fetching data by column index for row " + results.getRow() + " : " + data);


                // Get the data from the current row using the column name - column data are in the VARCHAR format

                data = results.getString("username");

                System.out.println("Fetching data by column name for row " + results.getRow() + " : " + data);
                username_vector[contor] = data;
                contor++;
            }




            System.out.println("\n ");





            ResultSet results2 = statement.executeQuery("SELECT password FROM users");
           int contor2 = 0;
           while (results2.next()) {



               // Get the data from the current row using the column index - column data are in the VARCHAR format

               String data = results2.getString(1);



               System.out.println("Fetching data by column index for row " + results2.getRow() + " : " + data);


               // Get the data from the current row using the column name - column data are in the VARCHAR format

               data = results2.getString("password");

               System.out.println("Fetching data by column name for row " + results2.getRow() + " : " + data);
               passwords_vector[contor2] = data;
               contor2++;
           }




           ResultSet results3 = statement.executeQuery("SELECT ismechanic FROM users");

           int contor3 = 0;
           while (results3.next()) {



               // Get the data from the current row using the column index - column data are in the VARCHAR format

               int data = results3.getInt(1);

               System.out.println("Fetching data by column index for row " + results3.getRow() + " : " + data);

               // Get the data from the current row using the column name - column data are in the VARCHAR format

               data = results3.getInt("ismechanic");

               System.out.println("Fetching data by column name for row " + results3.getRow() + " : " + data);
               mechanic_status[contor3] = data;
               contor3++;
           }





for(int i=0;i<contor;++i)
{
    System.out.println(username_vector[i]);
}
           System.out.println("\n");

           for(int j=0;j<contor;++j) {
               System.out.println(passwords_vector[j]);
           }

           for(int k=0;k<contor;++k)
           {
               System.out.println(mechanic_status[k]);
           }
/*
            String query ="SELECT * FROM users;";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.close();
            connection.close();
*/
          // connection.close();


        } catch (SQLException e) {
            System.out.println("Could not connect to the database\n " + e.getMessage());
        }




        Welcome welcomeFrame = new Welcome("Login");

    }

}
