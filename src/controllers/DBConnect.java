package controllers;

import models.Recipe;

import java.sql.*;
import java.util.ArrayList;

public class DBConnect {

    private String dbName;
    private String url;

    public DBConnect(String dbName) {
        this.dbName = dbName;
        this.url = "jdbc:sqlite:" + dbName;
    }

    public void createNewDatabase() {

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addTables(){

        String sql = "CREATE TABLE IF NOT EXISTS recipes (\n"
                + "	id integer PRIMARY KEY,\n"
                + " time text,\n"
                + "	title text,\n"
                + " ingredients text,\n"
                + " directions text\n"
                + ");";

        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            statement.execute(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addData(String time, String title, String ingredients, String directions){

        String sql = "INSERT INTO recipes(time, title, ingredients, directions) VALUES ('" + time + "', '" + title + "', '" + ingredients + "', '" + directions + "');";

        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            statement.execute(sql);
            System.out.println("Data added");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM recipes WHERE id = " + "'" + id + "';";
        System.out.println(sql);

        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            statement.execute(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Recipe> getData(){
        String sql = "SELECT id, time, title, ingredients, directions FROM recipes";
        ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

        try(Connection conn = DriverManager.getConnection(url)){
            Statement statement = conn.createStatement();
            ResultSet recipes = statement.executeQuery(sql);
            while(recipes.next())
            {
                int id = recipes.getInt("id");
                String time = recipes.getString("time");
                String title = recipes.getString("title");
                String ingredients = recipes.getString("ingredients");
                String directions = recipes.getString("directions");
                Recipe recipe = new Recipe(id, time, title, ingredients, directions);
                recipeList.add(recipe);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return recipeList;
    }
}
