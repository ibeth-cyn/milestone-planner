package webApp.login;

import java.util.Objects;

public class LoginService {

    private String name;
    private String password;

    public LoginService(String name){
        this.name = name;
        this.password = password;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    //Validate user webApp.login
//    public boolean isUserValid(String name, String password){
//        if(name.equals("Group5") && password.equals("enter"))
//            return true;
//        return false;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginService that = (LoginService) o;
        return getName().equals(that.getName()) &&
                getPassword().equals(that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassword());
    }

}
