package use_case.signup;

public class SignupOutputData {
    private String username;

    public SignupOutputData(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }
}
