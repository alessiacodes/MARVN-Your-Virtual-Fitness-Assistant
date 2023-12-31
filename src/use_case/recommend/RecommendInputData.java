package use_case.recommend;

import java.util.ArrayList;

public class RecommendInputData {

    //diet and health are arrays so that the user may input more than one tag for each as per use case
    private final ArrayList<String> diet;

    private final ArrayList<String> health;

    private final String mealType;


    public RecommendInputData(ArrayList<String> diet, ArrayList<String> health, String mealType){
        this.diet = diet;
        this.health = health;
        this.mealType = mealType;

    }

    public ArrayList<String> getDiet(){
        return diet;
    }

    public ArrayList<String> getHealth(){
        return health;
    }

    public String getMealType(){
        return mealType;
    }



}
