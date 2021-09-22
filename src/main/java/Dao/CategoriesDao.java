package Dao;


import Model.Categories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDao {

    public Categories getCategoriesById(int id) throws SQLException {
        PreparedStatement preparedStatement = ConnectionClass.getConnection()
                .prepareStatement("SELECT * FROM Categories WHERE Id =?");
        preparedStatement.setInt(1, id); //we have to set ID to retrieve our interest category
        ResultSet resultSet = preparedStatement.executeQuery();
        Categories category = new Categories();
        if(resultSet.next()) {//we have to set a field as a parameter to work
            category.setId(resultSet.getInt("id"));
            category.setCategory(resultSet.getString("Category"));
        }
        return category; //return value will be printed from the method
        // (in this case, it should be object)
    }

    public List<Categories> getAllCategories() throws SQLException {
        try (Connection connection = DriverManager.getConnection
                ("jdbc:mysql://85.28.108.212:33062/suengho", "suengho123", "suengho123")) {
            System.out.println("connection successful");
            Statement statement = connection.createStatement();
            String select = "SELECT * FROM Categories";
            ResultSet resultSet = statement.executeQuery(select);
            List<Categories> categoriesList = new ArrayList<>();

            while (resultSet.next()) {
                Categories category = new Categories();
                category.setId(resultSet.getInt("id"));
                category.setCategory(resultSet.getString("Category"));
                categoriesList.add(category);
            }
            //We are using a whole fields of object, therefore ResultSet class
            return categoriesList;
        }
    }
    public void createCategory (Categories category) throws SQLException {
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://85.28.108.212:33062/suengho", "suengho123", "suengho123");
        System.out.println("connection successful");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Categories(id, Category) VALUES (?,?)");
        preparedStatement.setInt(1, category.getId()); //we have to set ID in first method
        preparedStatement.setString(2, category.getCategory());
        preparedStatement.executeUpdate();
    }

    public void updateCategory (Categories category, int id) throws SQLException {
        PreparedStatement preparedStatement = ConnectionClass
                .getConnection()
                .prepareStatement("UPDATE Categories SET category = ?, id = ? WHERE id = ? ");
        preparedStatement.setInt(1, category.getId()); //we have to set ID in first method
        preparedStatement.setString(2, category.getCategory());
        preparedStatement.executeUpdate();
    }

    public void deleteCategory (int id) throws SQLException {
        PreparedStatement preparedStatement = ConnectionClass
                .getConnection()
                .prepareStatement("DELETE FROM Categories WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
