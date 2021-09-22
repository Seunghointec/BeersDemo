package Dao;

import Model.Beer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BeerDao {
    //In this class it's job is handle all the database task
    //There should be five task that connect database and java
    //First - get object by ID (reading) - we are querying one field (doing something with one field)
    //Second - get all object field (reading)
    // no parameters in second because we are going to return all the object field
    //Third - create new object (i.e. beer) in our database (no return for now)
    //fourth - update old object and fields (id) in our database
    //fifth - delete old object and fields (id) in our database
    //There could be more - say we wat filter out certain things in our field then this would be another method


    public Beer getBeerById(int id) throws SQLException {
        PreparedStatement preparedStatement = ConnectionClass
                .getConnection()
                .prepareStatement("SELECT * FROM Beers WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Beer beer = new Beer();
        if(resultSet.next()){ // we only require one field. if we have one field then others not required
            beer.setId(resultSet.getInt("id"));
            beer.setName(resultSet.getString("name"));
            beer.setAlcohol(resultSet.getInt("alcohol"));
            beer.setBrewerId(resultSet.getInt("BrewerId"));
            beer.setCategoryId(resultSet.getInt("CategoryId"));
            beer.setPrice(resultSet.getDouble("price"));
            beer.setStock(resultSet.getInt("stock"));
        }
        return beer;
    }

    public List<Beer> getAllBeers() throws SQLException {
        Statement statement = ConnectionClass.getConnection().createStatement();
        //we have connect, but rather than repeating, we could have a class of connection
        String select = "SELECT * FROM Beers";
        ResultSet resultSet = statement.executeQuery(select);
        List<Beer> beers = new ArrayList<>();
        while (resultSet.next()){
            Beer beer = new Beer();
            beer.setId(resultSet.getInt("id"));
            beer.setName(resultSet.getString("name"));
            beer.setAlcohol(resultSet.getInt("alcohol"));
            beer.setBrewerId(resultSet.getInt("BrewerId"));
            beer.setCategoryId(resultSet.getInt("CategoryId"));
            beer.setPrice(resultSet.getDouble("price"));
            beer.setStock(resultSet.getInt("stock"));
            beers.add(beer);
        }
        return beers;
    }

    //statement: executeQuery -> SELECT ; UpdateQuery -> INSERT, UPDATE, DELETE
    //preparedstatement: executeQuery -> SELECT ; executeUpdate -> INSERT, UPDATE, DELETE

    public void createBeer(Beer beer) throws SQLException {
        PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("INSERT INTO Beers(Id, Name, price, stock, alcohol) VALUES (?,?,?,?,?)");
        preparedStatement.setInt(1,beer.getId());
        preparedStatement.setString(2, beer.getName());
        preparedStatement.setDouble(3, beer.getPrice());
        preparedStatement.setInt(4,beer.getStock());
        preparedStatement.setInt(5, beer.getAlcohol());
        preparedStatement.execute();

    }

    public void updateBeer (Beer beer, int id) throws SQLException {
        PreparedStatement preparedStatement = ConnectionClass.getConnection().prepareStatement("UPDATE Beers SET id = ?,name = ?, price =?, stock = ?, alcohol =? WHERE id = ? ");
        preparedStatement.setInt(1,beer.getId());
        preparedStatement.setString(2, beer.getName());
        preparedStatement.setDouble(3, beer.getPrice());
        preparedStatement.setInt(4,beer.getStock());
        preparedStatement.setInt(5, beer.getAlcohol());
        preparedStatement.setInt(6,id);
        preparedStatement.executeUpdate();
    }

    public void deleteBeer (int id) throws SQLException {
        PreparedStatement preparedStatement = ConnectionClass
                .getConnection()
                .prepareStatement("DELETE FROM Beers WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}

