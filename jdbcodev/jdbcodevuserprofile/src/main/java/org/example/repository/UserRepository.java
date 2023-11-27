package org.example.repository;


import org.example.entities.Category;
import org.example.entities.UserProfile;
import org.example.utility.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {


    DbConnection dbConnection = new DbConnection();
    Connection connection = null;

    public boolean createUser(UserProfile userProfile) {
        String createUserQuery = "insert into customers(email,username,password,name,surname) values(?,?,?,?,?)";
        connection = dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareCall(createUserQuery);
            preparedStatement.setString(1, userProfile.getEmail());
            preparedStatement.setString(2, userProfile.getUsername());
            preparedStatement.setString(3, userProfile.getPassword());
            preparedStatement.setString(4,userProfile.getName());
            preparedStatement.setString(5,userProfile.getSurname());
            preparedStatement.executeUpdate();
            return true;

        } catch (Exception exception) {
            System.err.println("Sorguda hata var ");
        } finally {
            dbConnection.closeConnection(connection);
        }

        return false;
    }


    public List<UserProfile> getUsers() {
        connection = dbConnection.getConnection();
        String getUsersQuery = "select * from customers";
        List<UserProfile> userProfiles = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareCall(getUsersQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserProfile userProfile = new UserProfile();
                userProfile.setId(resultSet.getInt("id"));
                userProfile.setEmail(resultSet.getString("email"));
                userProfile.setUsername(resultSet.getString("username"));
                userProfile.setPassword(resultSet.getString("password"));
                userProfile.setName(resultSet.getString("name"));
                userProfile.setSurname(resultSet.getString("surname"));
                userProfiles.add(userProfile);
            }
            return userProfiles;
        } catch (Exception exception) {
            System.out.println("Select sorgusu çalışmadı kullanıcılar listeye aktarılamadı");
        } finally {
            dbConnection.closeConnection(connection);
        }
        return null;
    }

    public UserProfile getUserExist(String userEmail, String password) {
        String existedUserControllerQuery =
                "select * from customers where email='" + userEmail + "' and password ='" + password + "'";
        connection = dbConnection.getConnection();
        try {
            Driver.class.forName("org.postgresql.Driver");
            PreparedStatement pr = connection.prepareCall(existedUserControllerQuery);
            ResultSet set = pr.executeQuery();
            UserProfile userProfile = new UserProfile();
            while (set.next()) {
                int userid = set.getInt("id");
                String email = set.getString("email");
                String username = set.getString("username");
                String userPassword = set.getString("password");
                String userName = set.getString("name");
                String userSurname = set.getString("surname");
                userProfile.setId(userid);
                userProfile.setEmail(email);
                userProfile.setUsername(username);
                userProfile.setPassword(userPassword);
                userProfile.setName(userName);
                userProfile.setSurname(userSurname);


            }
            return userProfile;
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Class not found kanka");
        } catch (Exception exception) {
            System.err.println("aynı olanı bulmada hata yaşandı");
        } finally {
            dbConnection.closeConnection(connection);
        }
        return null;
    }


    public boolean updateUserEmail(UserProfile userProfile) {
        String emailQuery =
                "update customers set email ='" + userProfile.getEmail() + "' where id='" + userProfile.getId() + "'";
        connection = dbConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareCall(emailQuery);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException sqlException) {
            System.err.println("Kullanıcı emaili güncellenemedi");
        } finally {
            dbConnection.closeConnection(connection);
        }
        return false;

    }

    public boolean updateUserUsername(UserProfile userProfile) {


        String userNameQuery =
                "update customers set username ='" + userProfile.getUsername() + "' where id='" + userProfile.getId() + "'";

        connection = dbConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareCall(userNameQuery);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException sqlException) {
            System.err.println("Kullanıcı adı güncellenemedi kanka");
        } finally {
            dbConnection.closeConnection(connection);
        }

        return false;

    }


    public boolean updateUserPassword(UserProfile userProfile) {
        String passwordQuery =
                "update customers set password ='" + userProfile.getPassword() + "' where id='" + userProfile.getId() + "'";
        connection = dbConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareCall(passwordQuery);
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException sqlException) {
            System.err.println("Kullanıcı şifresi güncellenemedi kanka");
        } finally {
            dbConnection.closeConnection(connection);
        }

        return false;

    }


    public void deleteUser(UserProfile userProfile){
        String deleteUserQuery="delete from customers where customers.id="+userProfile.getId()+"";
        connection=dbConnection.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareCall(deleteUserQuery);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("HATA ALDIK");
            e.printStackTrace();
        }finally {
            dbConnection.closeConnection(connection);
        }


    }
    public UserProfile getByUserId(int userId){
        String isCustomerExistQuery="select * from customers where id ="+userId+"";
        connection=dbConnection.getConnection();

        try{
            PreparedStatement preparedStatement=connection.prepareCall(isCustomerExistQuery);
            ResultSet resultSet=preparedStatement.executeQuery();
            UserProfile userProfile =new UserProfile();
            while (resultSet.next()){
                userProfile.setId(resultSet.getInt("id"));
                userProfile.setName(resultSet.getString("name"));
                userProfile.setSurname(resultSet.getString("surname"));
                userProfile.setEmail(resultSet.getString("email"));
                userProfile.setUsername(resultSet.getString("username"));
                userProfile.setPassword(resultSet.getString("password"));
            }
            return userProfile;

        }catch (SQLException exception){
            System.err.println("Sql hatası kanka ");
        }finally {
            dbConnection.closeConnection(connection);
        }
        return null;
    }

}
