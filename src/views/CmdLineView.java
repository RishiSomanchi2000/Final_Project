package views;
import java.util.Scanner;
import models.Recipe;

public class CmdLineView {


    public int getIntInput() {
        Scanner input = new Scanner(System.in);
            int x = input.nextInt();
            return x;
    }

    public void showMainMenu() {
        System.out.println("1. View saved recipes");
        System.out.println("2. Create new recipe");
        System.out.println("3. Exit");
    }

    public void showRecipeMenu() {
        System.out.println("\n1. Enter entry number to view recipe");
        System.out.println("2. Enter entry number to delete recipe");
        System.out.println("3. Return to main menu");
        System.out.println("4. Exit program");

    }

    public String getStringInput() {
        Scanner input = new Scanner(System.in);
            String x = input.nextLine();
            return x;
    }

    public String getContinue() {
        Scanner input = new Scanner(System.in);
            System.out.println("Enter y to add an ingredient, or press any other character to exit");
            String x = input.next();
            return x.toLowerCase();
    }

    // print out list of recipes
    public void printDatabase(int i, Recipe recipe) {
        System.out.println(i + ": " + recipe.toString());
    }

    // print out selected recipe details
    public void showRecipe(Recipe recipe) {
        System.out.println(recipe.out());
    }

    public String timeInput() {
        Scanner input = new Scanner(System.in);
            System.out.println("time:");
            String time = input.nextLine();
            return time;
    }

    public String titleInput() {
        Scanner input = new Scanner(System.in);
            System.out.println("title:");
            String title = input.nextLine();
            return title;
    }

    public String ingredientInput() {
        Scanner input = new Scanner(System.in);
            System.out.println("ingredient:");
            String ingredients = input.nextLine();
            return ingredients;
    }

    public String directionsInput() {
        Scanner input = new Scanner(System.in);
            System.out.println("directions:");
            String ingredients = input.nextLine();
            return ingredients;
    }
}