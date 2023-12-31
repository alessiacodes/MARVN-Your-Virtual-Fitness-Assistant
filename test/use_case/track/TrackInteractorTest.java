package use_case.track;

import entity.*;
import org.junit.Test;
import use_case.food.FoodDataAccessInterface;
import use_case.login.LoginUserDataAccessInterface;
import use_case.recipe.RecipeDataAccessInterface;
import use_case.recommend.RecommendDataAccessInterface;
import use_case.signup.SignupDataAccessInterface;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TrackInteractorTest {

    /**
     * Test for a successful tracking scenario.
     */
    @Test
    public void successTest() {
        // Create a tracker and food
        Tracker tracker = new Tracker();
        Food food = new Food("TestFood", 1);
        TrackInputData inputData = new TrackInputData(food, tracker);

        // Create a fake DAO, mock presenter, and interactor
        FakeDAO dao = new FakeDAO();
        MockTrackPresenter presenter = new MockTrackPresenter();
        TrackInteractor interactor = new TrackInteractor(dao, presenter);

        // Execute the interactor
        interactor.execute(inputData);

        // Validate the results
        TrackOutputData outputData = presenter.getOutputData();

        // Validating Output Data
        assertEquals("TestFood", outputData.getFood().getName());

        // Validating that the tracker's food diary has the food
        assertTrue(tracker.getDiary().contains(food));
    }

    /**
     * Additional tests for checking various getters in TrackInteractor.
     */
    @Test
    public void gettersTest(){
        // Create a tracker and food
        Tracker tracker = new Tracker();
        Food food = new Food("TestFood", 1);
        TrackInputData inputData = new TrackInputData(food, tracker);

        // Create a fake DAO, mock presenter, and interactor
        FakeDAO dao = new FakeDAO();
        MockTrackPresenter presenter = new MockTrackPresenter();
        TrackInteractor interactor = new TrackInteractor(dao, presenter);

        // Execute the interactor
        interactor.execute(inputData);

        // Validate the results
        TrackOutputData outputData = presenter.getOutputData();

        // Validating the correct caloric content
        assertTrue(tracker.getTotalCalories()==300.0);

        // Validating that no water has been added to diary
        assertTrue(tracker.getWaterDiary().isEmpty());

        // Checking that getDiary() method works
        assertTrue(!tracker.getDiary().isEmpty());

        // Validating that getNutritionalContent works
        assertTrue(tracker.getTotalNutrition().get("Protein") == 5.0F);

        tracker.addWater(100);
        assertTrue(tracker.getWaterDiary().size() == 1);

    }
}

/**
 * Mock presenter for testing purposes.
 */
class MockTrackPresenter implements TrackOutputBoundary {
    private TrackOutputData outputData;

    @Override
    public void prepareSuccessView(TrackOutputData outputData) {
        System.out.println("Successfully tracked food: " + outputData.getFood().getName());
        this.outputData = outputData;
    }
    @Override
    public void prepareFailView(String error) {
        System.out.println("Error: " + error);
    }
    TrackOutputData getOutputData() {
        return outputData;
    }
}

/**
 * Fake DAO class implementing various data access interfaces.
 */
class FakeDAO implements SignupDataAccessInterface, RecommendDataAccessInterface, FoodDataAccessInterface, TrackDataAccessInterface, LoginUserDataAccessInterface, RecipeDataAccessInterface {

    @Override
    public boolean existsByName(String identifier) {
        return true;
    }

    @Override
    public void saveNewUser(User user) {
        System.out.println("User saved.");
    }

    @Override
    public User get(String username) {
        return new BasicUser("Natalia", "Tabja", "Natalia Tabja", null, null, 21, null, null);
    }
    @Override
    public String getRecommendLink(Recommend identifier) {
        return null;
    }

    @Override
    public HashMap<String, Float> getFoodNutritionalValues(String foodName, Float quantity) {
        System.out.println("Entered fake dao");
        HashMap<String, Float> nutritionalValues = new HashMap<>();
        nutritionalValues.put("Carbs", 10.0f);
        nutritionalValues.put("Protein", 5.0f);
        nutritionalValues.put("Fat", 7.0f);
        nutritionalValues.put("Calories", 300.0f);
        System.out.println(nutritionalValues);
        return nutritionalValues;
    }

    @Override
    public Integer getFoodCalories(String foodName, Float quantity) {
        return 300;
    }
}
