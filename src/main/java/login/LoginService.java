package login;

public class LoginService {
    //Validate user login
    public boolean isUserValid(String user, String password){
        if(user.equals("Group5") && password.equals("enter"))
            return true;
        return false;
    }
}
