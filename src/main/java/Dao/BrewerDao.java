package Dao;

import Model.Brewers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrewerDao {

    public Brewers getBrewerById(int id) throws SQLException {
        PreparedStatement preparedStatement = ConnectionClass
                .getConnection()
                .prepareStatement("SELECT * FROM Brewers WHERE id =?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet =preparedStatement.executeQuery();
        Brewers brewers = new Brewers();
        if (resultSet.next()) {
            brewers.setId(resultSet.getInt("id"));
            brewers.setName(resultSet.getString("name"));
            brewers.setZipcode(resultSet.getInt("ZipCode"));
            brewers.setAddress(resultSet.getString("Address"));
            brewers.setCity(resultSet.getString("City"));
            brewers.setTurnover(resultSet.getInt("Turnover"));
        }
        return brewers;
    }

    public List<Brewers> getAllBrewers() throws SQLException {
        PreparedStatement preparedStatement = ConnectionClass
                .getConnection()
                .prepareStatement("SELECT * FROM Brewers");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Brewers> brewer= new ArrayList<>();

        while (resultSet.next()) {
            Brewers brewers = new Brewers();
            brewers.setId(resultSet.getInt("id"));
            brewers.setName(resultSet.getString("name"));
            brewers.setZipcode(resultSet.getInt("ZipCode"));
            brewers.setAddress(resultSet.getString("Address"));
            brewers.setCity(resultSet.getString("City"));
            brewers.setTurnover(resultSet.getInt("Turnover"));
            brewer.add(brewers);
        }
        return brewer;
    }

    public void updateBrewer(Brewers brewer, int id) throws SQLException {
        PreparedStatement preparedStatement = ConnectionClass
                .getConnection()
                .prepareStatement("UPDATE Brewers " +
                        "SET id =?, Name =?, ZipCode =?, Address =?, City =?, Turnover =?");
        preparedStatement.setInt(1, brewer.getId());
        preparedStatement.setString(2, brewer.getName());
        preparedStatement.setInt(3, brewer.getZipcode());
        preparedStatement.setString(4, brewer.getAddress());
        preparedStatement.setString(5, brewer.getCity());
        preparedStatement.setInt(6, brewer.getTurnover());
        preparedStatement.execute();
    }

    public void createBrewer(Brewers brewer) throws SQLException {
        PreparedStatement preparedStatement = ConnectionClass
                .getConnection()
                .prepareStatement
                        ("INSERT INTO Brewers (id, Name, ZipCode, Address, City, Turnover)" +
                                "VALUES (?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, brewer.getId());
        preparedStatement.setString(2, brewer.getName());
        preparedStatement.setInt(3, brewer.getZipcode());
        preparedStatement.setString(4, brewer.getAddress());
        preparedStatement.setString(5, brewer.getCity());
        preparedStatement.setInt(6, brewer.getTurnover());
        preparedStatement.executeUpdate();
    }

    public void deleteBrewer(int id) throws SQLException {
        PreparedStatement preparedStatement = ConnectionClass
                .getConnection()
                .prepareStatement("DELETE FROM Brewers WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
