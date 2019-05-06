package webApp.milestone;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Milestone{

    private int milestoneId;
    private String milestoneName;
    private String project;
    private String description;
    private String dueDate;
    private String isComplete;

    private int userId;

    //Setting automatic completion date
    String pattern = "yyyy-MM-dd";
    DateFormat dateFormat = new SimpleDateFormat(pattern);
    Date date = new Date();

    private String completionDate = dateFormat.format(date);


    //Constructor that does not take a milestoneId argument
    public Milestone(String milestoneName, String project, String description, String dueDate, String isComplete){

        this.milestoneId = getRandomId();
        System.out.println("the random id is: "+ this.milestoneId);
        this.milestoneName = milestoneName;
        this.project = project;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = isComplete;

        if(this.isComplete == "true"){
            this.completionDate = getCompletionDate();
        }else{
            this.completionDate = null;
        }
    }

    //Constructor that takes in an id
    public Milestone(int milestoneId ,String milestoneName, String project, String description, String dueDate, String isComplete){

        this.milestoneId = milestoneId;
        this.milestoneName = milestoneName;
        this.project = project;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = isComplete;

        if(this.isComplete == "true"){
            this.completionDate = getCompletionDate();
        }else{
            this.completionDate = null;
        }
    }


    //Getter for name
    public String getName() {
        return milestoneName;
    }

    //Getter for project
    public String getProject() {
        return project;
    }

    //Getter for description
    public String getDescription() {
        return description;
    }

    //Getter for dueDate

    public String getDueDate() {
        return dueDate;
    }

    //Getter for isComplete

    public String getIsComplete() {
        return isComplete;
    }

    //Getter for completionDate

    public String getCompletionDate() {
        return completionDate;
    }

    //Getter for milestoneId
    public int getId() {
        return milestoneId++;
    }

    //Method to generate unique integer id's

    public int getRandomId() {

        UUID uuid = UUID.randomUUID();
        String str=""+uuid;
        int uid = str.hashCode();
        String filterStr=""+uid;
        str = filterStr.replaceAll("-", "");
        return Integer.parseInt(str);

    }

    @Override
    public String toString() {
        return "Milestone: \n" +
                "\tMilestone id: " + milestoneId + "\n" +
                "\tMilestone name: " + milestoneName + "\n" +
                "\tProject: " + project + "\n" +
                "\tDescription: " + description + "\n" +
                "\tDue Date: " + dueDate + "\n" +
                "\tCompleted: " + isComplete + "\n" +
                "\tCompletion Date: " + completionDate + "\n";
    }

}
