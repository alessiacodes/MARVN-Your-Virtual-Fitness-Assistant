package entity;
import java.util.ArrayList;
import entity.Tracker;

public class BasicUser implements User{
    private String username;
    private String password;
    private String name;

    private String gender;

    private Double weight;

    private int age;

    private Double height;

    private ArrayList<String> dietaryRestrictions;

    private Tracker tracker;



    public BasicUser(String username, String password, String name, String gender, Double weight, int age,
                     Double height, ArrayList<String> dietaryRestrictions){
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.age = age;
        this.height = height;
        this.dietaryRestrictions = dietaryRestrictions;
        this.tracker = new Tracker();

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public User getUser(){
        return this;
    }

    public String getName(){
        return name;
    }

    public String getGender(){
        return gender;
    }

    public int getAge(){
        return age;
    }

    public Double getHeight(){
        return height;
    }

    public ArrayList<String> getRestrictions(){
        return dietaryRestrictions;
    }

    public Double getWeight(){
        return weight;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setHeight(Double height){
        this.height = height;
    }

    public void setRestrictions(ArrayList<String> dietaryRestrictions){
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public void setWeight(Double weight){
        this.weight = weight;
    }

    public Tracker getTracker(){return this.tracker;};

}
