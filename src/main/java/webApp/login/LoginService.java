package webApp.login;

import javax.validation.constraints.NotNull;

public class LoginService {

    //Validate user webApp.login
    public boolean isUserValid(String user, String password){
        if(user.equals("Group5") && password.equals("enter"))
            return true;
        return false;
    }
}
