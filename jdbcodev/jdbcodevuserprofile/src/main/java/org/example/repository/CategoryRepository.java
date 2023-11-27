package org.example.repository;

import org.example.entities.Category;
import org.example.utility.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    DbConnection dbConnection=new DbConnection();
    Connection connection=null;
    public void createCategory(Category category){

                String createCateryQuery="insert into category(name) values('"+category.getCategoryname()+"')";
                connection=dbConnection.getConnection();
                try{
                    PreparedStatement preparedStatement=connection.prepareCall(createCateryQuery);
                    preparedStatement.executeUpdate();
                }catch (SQLException sqlException){
                    System.err.println("Sql hatası kanka");
                }finally {
                    dbConnection.closeConnection(connection);
                }
    }

    public boolean deleteCategory(Category category){
        String deleteCateryQuery="delete from category where id='"+category.getId()+"'";
        connection=dbConnection.getConnection();
        try {
                PreparedStatement preparedStatement=connection.prepareCall(deleteCateryQuery);
                preparedStatement.executeUpdate();
                return true;

        }catch (SQLException sqlException){
            System.err.println("category silinemedi kanka");
        }
        finally {
            dbConnection.closeConnection(connection);
        }
        return false;
    }

    public Category getByCategoryName(String categoryName){
            String isCategoryExistQuery="select * from category where name ='"+categoryName+"'";
            connection=dbConnection.getConnection();

            try{

                PreparedStatement preparedStatement=connection.prepareCall(isCategoryExistQuery);
                ResultSet resultSet=preparedStatement.executeQuery();
                Category category=new Category();
                while (resultSet.next()){
                        category.setId(resultSet.getInt("id"));
                        category.setCategoryname(resultSet.getString("name"));
                }
                return category;

            }catch (SQLException exception){
                System.err.println("Sql hatası kanka ");
            }finally {
                dbConnection.closeConnection(connection);
            }
            return null;
    }


    public List<Category> gelAll(){
        Connection con= dbConnection.getConnection();

        String selectSorgu="select * from category";
        PreparedStatement pp= null;
        try {
            pp = con.prepareCall(selectSorgu);
            ResultSet set=pp.executeQuery();

            List<Category>categories=new ArrayList<>();
            while (set.next()){
                int id=set.getInt("id");
                String name=set.getString("name");
                Category category=new Category();
                category.setId(id);
                category.setCategoryname(name);
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            dbConnection.closeConnection(con);
        }
    }








}
