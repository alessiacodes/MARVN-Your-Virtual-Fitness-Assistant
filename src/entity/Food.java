package entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Food {

    private String name;
    private float quantity;
    private Float kcal;

    private float protein;
    private float fat;
    private float carbs;

    private HashMap<String, Float> nutritionalValues;


    public Food(String name, float quantity){
        this.name = name;
        this.quantity = quantity;
        this.nutritionalValues = new HashMap<String, Float>();

        this.kcal = 0.0F;
        this.protein = 0.0F;
        this.fat = 0.0F;
        this.carbs = 0.0F;

        // Create Nutritional Values HashMap
        this.nutritionalValues.put("Calories", (float) this.kcal);
        this.nutritionalValues.put("Protein", this.protein);
        this.nutritionalValues.put("Fat", this.fat);
        this.nutritionalValues.put("Carbs", this.carbs);
    }

    public String getName() {return name;}

    public float getQuantity() {return quantity;}

    public Float getCalories(){
        return kcal;
    }

    public void updateQuantity(float amount){
        this.quantity = amount;
    }

    public HashMap<String, Float> getNutritionalValues() {
        return nutritionalValues;
    }

    public Float getProtein() {
        return this.protein;
    }

    public Float getFat() {
        return this.fat;
    }

    public Float getCarbs() {
        return this.carbs;
    }

    /**
     * Sets the nutritional values for the food item.
     * @param nutritionalValues A map containing nutritional values.
     *                          Keys: "Calories", "Protein", "Fat", "Carbs".
     */
    public void setNutritionalValues(HashMap<String, Float> nutritionalValues) {
        this.nutritionalValues.put("Calories", nutritionalValues.get("Calories"));
        this.kcal = nutritionalValues.get("Calories");
        this.nutritionalValues.put("Protein", nutritionalValues.get("Protein"));
        this.protein = nutritionalValues.get("Protein");
        this.nutritionalValues.put("Fat", nutritionalValues.get("Fat"));
        this.fat = nutritionalValues.get("Fat");
        this.nutritionalValues.put("Carbs", nutritionalValues.get("Carbs"));
        this.carbs = nutritionalValues.get("Carbs");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        if (Float.compare(food.quantity, quantity) != 0) return false;
        return name != null ? name.equals(food.name) : food.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (quantity != +0.0f ? Float.floatToIntBits(quantity) : 0);
        return result;
    }

}