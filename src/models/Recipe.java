package models;

public class Recipe {

    public String title;
    private String ingredients;
    private String directions;
    private String time; // deal with hour and minute formatting eventually.
    private String notes;
    public int id;
    

    public Recipe(int id, String time, String title, String ingredients, String directions) {
        this.title = title;
        this.id = id;
        this.time = time;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }


    public void setIngredient(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredient() {
        return ingredients;
    }


    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString(){
        return title;
    }

    public String out() {
        return title + "\n--------------------------\n" + "Time: " + time + "\n\nIngredients:\n" + ingredients + "\nDirections:\n" + directions;
    }
}