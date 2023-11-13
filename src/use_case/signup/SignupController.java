package use_case.signup;

import java.util.ArrayList;

public class SignupController {
    final SignupInputBoundary interactor;
    public SignupController(SignupInputBoundary interactor){
        this.interactor = interactor;
    }
    
    public void execute(String username,
                        String password,
                        String name,
                        String gender,
                        int age,
                        Double height,
                        ArrayList<String> dietaryRestrictions,
                        Double weight){
        SignupInputData inputData = new SignupInputData(username, password, name, gender, age, height, dietaryRestrictions,weight);
        interactor.execute(inputData);
    }


}
