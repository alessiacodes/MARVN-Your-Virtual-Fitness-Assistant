package use_case.login;

public class LoginOutputData {
    private final String username;

    private boolean useCaseFailed;

    public LoginOutputData(String username, boolean UseCaseFailed){
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {return username;}


    public boolean getUseCaseFailed(){
        return useCaseFailed;
    }
    
}
