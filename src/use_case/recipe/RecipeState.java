package use_case.recipe;

import entity.Food;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RecipeState {
    private String recipeName = "";

    private LinkedHashMap<Food, Integer> ingredients;

    private Integer kCal = 0;

    private HashMap<String, Float> totalNutrients;

    public RecipeState(RecipeState copy) {
        recipeName = copy.recipeName;
        ingredients = copy.ingredients;
        kCal = copy.kCal;
        totalNutrients = copy.totalNutrients;
    }

    public RecipeState() {}

    public String getRecipeName() {return recipeName;}

    public LinkedHashMap<Food, Integer> getIngredients() {return ingredients;}

    public Integer getkCal() {return kCal;}

    public HashMap<String, Float> getTotalNutrients() {return totalNutrients;}

    public void setRecipeName(String recipeName) {this.recipeName = recipeName;}

    public void setIngredients(LinkedHashMap<Food, Integer> ingredients) {this.ingredients = ingredients;}

    public void setkCal(Integer kCal) {this.kCal = kCal;}

    public void setTotalNutrients(HashMap<String, Float> totalNutrients) {this.totalNutrients = totalNutrients;}

}
