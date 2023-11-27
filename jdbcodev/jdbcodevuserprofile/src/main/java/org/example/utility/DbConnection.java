package org.example.utility;

import java.sql.*;

public class DbConnection {


    public Connection getConnection(){

        Connection connection=null;
        String url="jdbc:postgresql://34.69.186.189/deneme";
        String username="postgres";
        String password="Jjs2s_g432sa";
        try {

            Driver.class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url,username,password);

            return connection;

        }catch (ClassNotFoundException exception){
            System.out.println("Alperen efsanedir");
        }catch (SQLException sqlException){
            System.out.println("Alperen harikadır");
        }
        return connection;
    }

    public boolean closeConnection(Connection connection){
            try{
                connection.close();
                return true;

            }catch (Exception exception){
                System.out.println("Alperen muhteşemdir");
            }
            return false;
    }



}
