package data_access;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import entity.Food;
import use_case.recipe.RecipeDataAccessInterface;

class EdamamApiAccess implements RecipeDataAccessInterface {
    private static final String APP_ID = "64984032"; //this is for food lookup
    private static final String APP_KEY = "47ecdbab5b1aa48bcbd2c622f83c8006"; //this is for food lookup

    //IMPORTANT: THESE API KEYS ARE FOR RECIPE API
    //Application ID: cd905d5f
    //Key: 19dbdd026906aa90c7a5ca301942a30d

    public static JSONObject apiHelper(Food identifier) {
        String foodName = identifier.getName();
        OkHttpClient client = new OkHttpClient();

        try {
            // Build correct URL with appropriate parameters, in this case I'm using the API to find the nutritional
            // content of rice.
            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.edamam.com/api/nutrition-data").newBuilder();
            urlBuilder.addQueryParameter("app_id", APP_ID);
            urlBuilder.addQueryParameter("app_key", APP_KEY);
            urlBuilder.addQueryParameter("ingr", foodName);
            String apiURL = urlBuilder.build().toString();

            // Making the actual request
            Request request = new Request.Builder()
                    .url(apiURL)
                    .build();

            // Getting the response
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            return responseBody;
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getCalories(Food identifier) {
        String foodName = identifier.getName();
        OkHttpClient client = new OkHttpClient();

        try {
            // Build correct URL with appropriate parameters, in this case I'm using the API to find the nutritional
            // content of rice.
            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.edamam.com/api/nutrition-data").newBuilder();
            urlBuilder.addQueryParameter("app_id", APP_ID);
            urlBuilder.addQueryParameter("app_key", APP_KEY);
            urlBuilder.addQueryParameter("ingr", foodName);
            String apiURL = urlBuilder.build().toString();

            // Making the actual request
            Request request = new Request.Builder()
                    .url(apiURL)
                    .build();

            // Getting the response
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            return (Integer) responseBody.get("calories");
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<String, Double> getTotalNutrients(Food identifier) {
        String foodName = identifier.getName();
        OkHttpClient client = new OkHttpClient();

        try {
            // Build correct URL with appropriate parameters, in this case I'm using the API to find the nutritional
            // content of rice.
            HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.edamam.com/api/nutrition-data").newBuilder();
            urlBuilder.addQueryParameter("app_id", APP_ID);
            urlBuilder.addQueryParameter("app_key", APP_KEY);
            urlBuilder.addQueryParameter("ingr", foodName);
            String apiURL = urlBuilder.build().toString();

            // Making the actual request
            Request request = new Request.Builder()
                    .url(apiURL)
                    .build();

            // Getting the response
            Response response = client.newCall(request).execute();
            JSONObject responseBody = new JSONObject(response.body().string());
            Map<String, Object> totalNutrients = responseBody.getJSONObject("totalNutrients").toMap();
            HashMap<String, Double> nutrients = new HashMap<String, Double>();

            Set<String> nutrientNames = totalNutrients.keySet();
            for (String nutrient : nutrientNames) {
                Double doubleNutrient = (Double) totalNutrients.get(nutrient);
                nutrients.put(nutrient, doubleNutrient);
            }
            return nutrients;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    public static tuple getFoodData(String food, String Quantity){
//
//    }


}