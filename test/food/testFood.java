package food;

import use_case.food.FoodDataAccessInterface;

import java.util.HashMap;

public class testFood {
    public static void main(String[] args) {
        ;
    }

}

class FakeDAO implements FoodDataAccessInterface{

    @Override
    public HashMap<String, Double> getFoodNutritionalValues(String foodName, Float quantity) {
        return null;
    }

    @Override
    public Integer getFoodCalories(String foodName, Float quantity) {
        return null;
    }
}