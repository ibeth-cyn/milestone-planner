package webApp.db;


import webApp.milestone.Milestone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MilestoneDB implements AutoCloseable {

    //JDBC driver name and url

    static final String JDBC_Driver = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/milestonedb";
<<<<<<< HEAD
=======

>>>>>>> debbies_branch

    //database credentials
    static final String USER = "";
    static final String PASS = "";

    private Connection connection;
    Statement stmt = null;

    static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_Driver);
        return DriverManager.getConnection(DB_URL, USER, PASS);

    }

    // initializing the database  - table needs to be created once.
    public MilestoneDB() {
        try {

            System.out.println("creating connection....");
            connection = getConnection();

            //creating table
            System.out.println("Checking if table exists.....");
            System.out.println("Creating table.....");

            stmt = connection.createStatement();
            String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS milestonelist" +
                    "(id INT NOT NULL," +
                    "name VARCHAR(30)," +
                    "project VARCHAR(30)," +
                    "description VARCHAR(255)," +
                    "duedate VARCHAR(30)," +
                    "completeStatus VARCHAR(30)," +
                    "completionDate VARCHAR(30)," +
                    "PRIMARY KEY(id))";

            stmt.executeUpdate(CREATE_TABLE_QUERY);

        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Milestone> getMilestones() {
        final String LIST_MILESTONES_QUERY = "SELECT ID, name, project, description,duedate,completeStatus,completionDate FROM milestonelist";
        List<Milestone> milestonesFound = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(LIST_MILESTONES_QUERY)) {
            System.out.println("Milestones are being retrieved");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                milestonesFound.add(new Milestone(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return milestonesFound;
    }

    /**
     * deleteMilestone() - Deletes milestones using their name and project title.
     */

    public void deleteMilestone(Milestone milestone) {
        final String REMOVE_MILESTONE_QUERY = "DELETE FROM milestonelist WHERE name=? AND project=?";
        try (PreparedStatement ps = connection.prepareStatement(REMOVE_MILESTONE_QUERY)) {
            System.out.println("Deleting milestone...");
            ps.setString(1, milestone.getName());
            ps.setString(2, milestone.getProject());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMilestone(Milestone milestone) {
        final String ADD_MILESTONE_QUERY = "INSERT INTO milestonelist (" +
                "id,name, project, description, duedate, completeStatus, " +
                "completiondate) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement ps = connection.prepareStatement(ADD_MILESTONE_QUERY)) {
            System.out.println("Milestones are being added");

            ps.setInt(1, milestone.getId());
            ps.setString(2, milestone.getName());
            ps.setString(3, milestone.getProject());
            ps.setString(4, milestone.getDescription());
            ps.setString(5, milestone.getDueDate());
            ps.setString(6, milestone.getIsComplete());
            ps.setString(7, milestone.getCompletionDate());
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateMilestone(Milestone milestone, int id) {

        final String UPDATE_MILESTONE_QUERY = "UPDATE milestonelist SET " +
                "name = ?, " +
                "project = ?, " +
                "description = ?, " +
                "duedate = ?, " +
                "completeStatus = ?, " +
                
                "completiondate = ? " +
                "WHERE id= " + id;


        try (PreparedStatement ps = connection.prepareStatement(UPDATE_MILESTONE_QUERY)) {
            System.out.println("Milestone is being updated");
            ps.setString(1, milestone.getName());
            ps.setString(2, milestone.getProject());
            ps.setString(3, milestone.getDescription());
            ps.setString(4, milestone.getDueDate());
            ps.setString(5, milestone.getIsComplete());
            ps.setString(6, milestone.getCompletionDate());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
