package webApp.login;

import javax.validation.constraints.NotNull;

public class LoginService {
<<<<<<< HEAD:src/main/java/login/LoginService.java
    //Validate user login
    public boolean isUserValid(String user, String password) {
        if (user.equals("Group5") && password.equals("enter"))
=======
    //Validate user webApp.login
    public boolean isUserValid(String user, String password){
        if(user.equals("Group5") && password.equals("enter"))
>>>>>>> ec3b2b8aafd1f0f9a46837a6d897be97ccd0e312:src/main/java/webApp/login/LoginService.java
            return true;
        return false;
    }


}
