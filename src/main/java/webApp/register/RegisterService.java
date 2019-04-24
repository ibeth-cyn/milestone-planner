package webApp.register;

import java.util.Objects;

public class RegisterService {

    private String name;
    private String hashPassword;


    public RegisterService(String name, String hashPassword){
        this.name = name;
        this.hashPassword = hashPassword;
    }
    public void setHashPassword(String hashPassword){
        this.hashPassword = hashPassword;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Username and password: \n" +
                "\tUsername: " + name + "\n" +
                "\tHashedpassword: " + hashPassword + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterService that = (RegisterService) o;
        return getName().equals(that.getName()) &&
                getHashPassword().equals(that.getHashPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHashPassword());
    }
}
