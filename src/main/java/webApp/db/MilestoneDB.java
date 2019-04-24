package webApp.db;

import webApp.login.LoginService;
import webApp.login.PasswordHash;
import webApp.milestone.Milestone;
import webApp.register.RegisterService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MilestoneDB implements AutoCloseable {

    //JDBC driver name and url

    static final String JDBC_Driver = "org.h2.Driver";
<<<<<<< HEAD
    static final String DB_URL = "jdbc:h2:C:/Users/Administrator/Desktop/wpd2_cw_group5/milestonedb";

=======
    static final String DB_URL = "jdbc:h2:~/milestonedb";
>>>>>>> 68b855c866331d606f59ca080f1ee635a7bdad99


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
    public MilestoneDB(){
        try{

            System.out.println("creating connection....");
            connection = getConnection();

            //creating table
            System.out.println("Checking if table exists.....");
            System.out.println("Creating table.....");

            stmt = connection.createStatement();
            String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS milestonelist" +
                    "(id int NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(30)," +
                    "project VARCHAR(30)," +
                    "description VARCHAR(255)," +
                    "duedate VARCHAR(30)," +
                    "PRIMARY KEY(id))";

            stmt.executeUpdate(CREATE_TABLE_QUERY);

            String CREATE_TABLE_2_QUERY = "CREATE TABLE IF NOT EXISTS validateList"+
                    "(id int NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(30)," +
                    "hashPassword VARCHAR(255)," +
                    "PRIMARY KEY(id))";

            stmt.executeUpdate(CREATE_TABLE_2_QUERY);

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

    public List<Milestone> getMilestones(){
        final String LIST_MILESTONES_QUERY = "SELECT name, project, description,duedate FROM milestonelist";
        List<Milestone> milestonesFound = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement(LIST_MILESTONES_QUERY)){
            System.out.println("Milestones are being retrieved");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                milestonesFound.add(new Milestone(rs.getString(1), rs.getString(2), rs.getString(3),
                rs.getString(4)));
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return milestonesFound;
    }

    /**
     *  deleteMilestone() - Deletes milestones using their name and project title.
     * */

    public void deleteMilestone(Milestone milestone){
        final String REMOVE_MILESTONE_QUERY = "DELETE FROM milestonelist WHERE name=? AND project=?";
        try(PreparedStatement ps = connection.prepareStatement(REMOVE_MILESTONE_QUERY)){
            System.out.println("Deleting milestone...");
            ps.setString(1, milestone.getName());
            ps.setString(2,milestone.getProject());
            ps.executeUpdate();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void addMilestone(Milestone milestone){
        final String ADD_MILESTONE_QUERY = "INSERT INTO milestonelist (name, project, description, duedate) VALUES (?,?,?,?)";

        try(PreparedStatement ps = connection.prepareStatement(ADD_MILESTONE_QUERY)){
            System.out.println("Milestones are being added");
            ps.setString(1, milestone.getName());
            ps.setString(2, milestone.getProject());
            ps.setString(3, milestone.getDescription());
            ps.setString(4, milestone.getDueDate());
            ps.execute();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void addHashedPasswords(RegisterService registerService){
        final String ADD_HASH_PASSWORD = "INSERT INTO validateList (name, hashPassword) VALUES (?,?)";

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
        final String CONFIRM_PASSWORD = "SELECT * FROM validateList WHERE name = ?";
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
