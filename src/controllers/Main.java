package controllers;
import models.Recipe;
import views.CmdLineView;

import java.util.ArrayList;

public class Main {
    static CmdLineView view = new CmdLineView();
    static boolean go = true;

    static DBConnect db = new DBConnect("recipes.db");


    public static void main(String[] args) throws Exception {
        db.createNewDatabase();
        db.addTables();

        menu();
    }

    public static void addRecipe() {
        System.out.println("addRecipe");

        String title = view.titleInput();

        String time = view.timeInput();

        String ingredientList = "";
        while(view.getContinue().equals("y")) {
            ingredientList += view.ingredientInput() + "\n";
        }

        String directions = view.directionsInput();

        db.addData(time, title, ingredientList, directions);

        menu();
    }


    public static void showRecipes() {
        ArrayList<Recipe> theRecipes = db.getData();
        int i = 0;
        for(Recipe recipe : theRecipes){
            view.printDatabase(i, recipe);
            i++;
        }
        // select recipe by ID number to view
        view.showRecipeMenu();

        // view or delete recipe
        int x = view.getIntInput();
        switch(x) {
            case 1: view.showRecipe(theRecipes.get(view.getIntInput()));
                break;
            case 2: db.delete(view.getIntInput());
                break;
            case 3: menu();
                break;
            case 4: System.exit(0);
            default: System.out.println("Error");
        }
        menu();
    }

    public static void menu() {
        System.out.println("1. Add recipe\n2. Show recipes\n3. Exit");
        switch(view.getIntInput()) {
            case 1: addRecipe();
                break;
            case 2: showRecipes();
                break;
            case 3: System.exit(0);
                break;
            default: System.out.println("Error");
       }
    }
}