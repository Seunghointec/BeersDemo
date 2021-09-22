

import Dao.BeerDao;
import Dao.BrewerDao;
import Dao.CategoriesDao;
import Model.Beer;
import Model.Brewers;
import Model.Categories;


import java.sql.*;



public class MainApp {
    public static void main(String[] args) {

        try {
            Categories category = new Categories(100, "yes_beers");
            CategoriesDao categoriesDao = new CategoriesDao();
            //categoriesDao.createCategory(category);
            //category.setCategory("no_beer");
            //categoriesDao.updateCategory(category,100);
            categoriesDao.deleteCategory(100);
            //System.out.println(category);
            System.out.println(categoriesDao.getCategoriesById(100));
            categoriesDao.getAllCategories().forEach(System.out::println);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
}

 /*Categories category = new Categories(100, "yes_beers");
            CategoriesDao categoriesDao = new CategoriesDao();
            categoriesDao.createCategory(category);
            category.setCategory("no_beer");
            categoriesDao.updateCategory(category,100);
            categoriesDao.deleteCategory(100);
            //System.out.println(category);
            System.out.println(categoriesDao.getCategoriesById(100));
            categoriesDao.getAllCategories().forEach(System.out::println);*/


/*          Beer beer = new Beer(6000,"Seungho's_beer", 0,0,2.56,2,7);
            BeerDao beerDao = new BeerDao();
            //beerDao.deleteBeer(7000);
            //beerDao.deleteBeer(6000);
            //beerDao.createBeer(beer);
            beer.setBrewerId(12);
            beer.setName("no_beer");
            beerDao.updateBeer(beer,6000);
            System.out.println(beerDao.getBeerById(6000));
            beerDao.getAllBeers().forEach(System.out::println);*/



/*    Brewers brewer = new
            Brewers(200, "Seungho", "Seungho's_way", 0, "Kang",2000);
    BrewerDao brewerDao = new BrewerDao();
            brewerDao.getBrewerById(100);
                    //brewerDao.createBrewer(brewer);
                    brewer.setName("No_way");
                    brewerDao.updateBrewer(brewer, 200);
                    brewerDao.getAllBrewers().forEach(System.out::println);*/


        /*Prepared statement usage without DAO class
        //There is so much interaction going on between codes and
        // main app duties is to run (not ideal situation in here)
        // (high cohesion)= every class has a role therefore these code should be somewhere else
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Give me Max alcohol");
        int alcohol = keyboard.nextInt();
        System.out.println("Give me a price");
        double price = keyboard.nextDouble();

        try (Connection connection = DriverManager.getConnection
        ("jdbc:mysql://85.28.108.212:33062/suengho", "suengho123", "suengho123")) {
        System.out.println("connection successful");

        String select ="SELECT * FROM Beers WHERE alcohol < ? AND price < ?";
        Statement sqlAsking = connection.createStatement(); //creating connection
        PreparedStatement preparedStatement = connection.prepareStatement(select);
        /*with connection, we can enter the query allows you to get user to set query without repeating
        Instead of building a separate query statement every time
        the user launches such a query, we can prepare a query with a host variable and
        use it many times, each time filling in a different string for the variable.

        //preparedStatement.setString(1,name); //parameter index has to start 0
        preparedStatement.setInt(1, alcohol);
        preparedStatement.setDouble(2, price);
        //we need to set how many query we have (in case of name, we have one field)

        ResultSet resultSet = preparedStatement.executeQuery();
        //we need to have result to show the query result
        List<Beer> beers = new ArrayList<>();
        //going to create some beers in java objects into SQL database (or recall all the beers)

        while (resultSet.next()) { //using this while loop we are going to use iteration to create/recall
        Beer beer = new Beer(); //first beer to create/recall
        beer.setId(resultSet.getInt("id"));
        beer.setName(resultSet.getString("Name"));
        beer.setBrewerId(resultSet.getInt("BrewerId"));
        beer.setPrice(resultSet.getDouble("Price"));
        beer.setCategoryId(resultSet.getInt("CategoryId"));
        beer.setStock(resultSet.getInt("stock"));
        beers.add(beer); //to add newly created/recalled beer into the list
        }
        for (Beer beer : beers) {
        System.out.println(beer);
        }*/


        /* Another way of doing user query without hard code
        Scanner keyboard = new Scanner(System.in);
        //System.out.println("give me a name");
        //String name = keyboard.next();
        System.out.println("Give me Max alcohol");
        int alcohol = keyboard.nextInt();
        System.out.println("Give me a price");
        double price = keyboard.nextInt();

        try (Connection connection = DriverManager.getConnection
           ("jdbc:mysql://85.28.108.212:33062/suengho", "suengho123", "suengho123")) {
        System.out.println("connection successful");

        Statement sqlAsking = connection.createStatement(); //creating connection

        String select ="SELECT * FROM Beers WHERE name like '%" + name + "%'";
        String select ="SELECT * FROM Beers WHERE alcohol < " + alcohol "AND price <" + price;
        String insert ="INSERT INTO Beers (name, alcohol) VALUES ('Seungho_Beer', '7,5')
        //SQL query of selecting whole table
        //'%" + name + "%'" identical to WHERE name like '%io%'
        //one way of asking user to entry their own entry

        ResultSet resultSet = sqlAsking.executeQuery(select); //result of SQL squery


        //to print out result SQL query -iteration
        while (resultSet.next()) {
        System.out.println(resultSet.getString("name"));
        }

        */