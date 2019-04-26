package webApp.db;

import webApp.login.LoginService;
import webApp.register.RegisterService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasswordDB implements AutoCloseable  {

    //JDBC driver name and url

    static final String JDBC_Driver = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/milestonedb";


    //database credentials
    static final String USER = "";
    static final String PASS = "";

    private Connection connection;
    Statement stmt = null;

    static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName(JDBC_Driver);
        return DriverManager.getConnection(DB_URL, USER,PASS);

    }

    // initializing the database  - table needs to be created once.
    public PasswordDB(){
        try{

            System.out.println("creating connection....");
            connection = getConnection();

            //creating table
            System.out.println("Checking if table exists.....");
            System.out.println("Creating table.....");

            stmt = connection.createStatement();

            String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS userInfo"+
                    "(id int NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(30)," +
                    "hashPassword VARCHAR(255)," +
                    "PRIMARY KEY(id))";

            stmt.executeUpdate(CREATE_TABLE_QUERY);

        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close(){
        try{
            if(connection != null){
                connection.close();
                connection = null;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void addHashedPasswords(RegisterService registerService){
        final String ADD_HASH_PASSWORD = "INSERT INTO userInfo (name, hashPassword) VALUES (?,?)";

        try(PreparedStatement ps = connection.prepareStatement(ADD_HASH_PASSWORD)) {
            System.out.println("Hashed passwords are being added");
            ps.setString(1, registerService.getName());
            ps.setString(2, registerService.getHashPassword());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String confirmUser(LoginService loginService) {
        final String CONFIRM_PASSWORD = "SELECT * FROM userInfo WHERE name = ?";
        String dbName = null;
        String dbPassword = null;
        try (PreparedStatement ps = connection.prepareStatement(CONFIRM_PASSWORD)) {
            System.out.println("Confirming if user is in the database");
            ps.setString(1, loginService.getName());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dbName = rs.getString("name");
                dbPassword = rs.getString("hashPassword");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (loginService.getName().equals(dbName)) {
            return dbPassword;
        }
        return dbPassword;
    }
}
