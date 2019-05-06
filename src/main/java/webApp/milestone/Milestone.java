package webApp.milestone;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Milestone{

    private int milestoneId;
    private String milestoneName;
    private String project;
    private String description;
    private String dueDate;
    private String isComplete;

    //Setting automatic completion date
    String pattern = "yyyy-MM-dd";
    DateFormat dateFormat = new SimpleDateFormat(pattern);
    Date date = new Date();

    private String completionDate = dateFormat.format(date);
    private int userId;


    //Constructor that takes an isComplete argument
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


    //Getters and setters for name
    public String getName() {
        return milestoneName;
    }

    public void setName(String name) {
        this.milestoneName = name;
    }

    //Getters and setters for project
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    //Getters and setters for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Getters and setters for dueDate

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    //Getters and setters for isComplete

    public String getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(String isComplete) {
        this.isComplete = isComplete;
    }

    //Getters and setters for completionDate

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate){
        this.completionDate = completionDate;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Milestone milestone = (Milestone) o;
        return Objects.equals(getName(), milestone.getName()) &&
                Objects.equals(getProject(), milestone.getProject()) &&
                Objects.equals(getDescription(), milestone.getDescription()) &&
                Objects.equals(getDueDate(), milestone.getDueDate()) &&
                Objects.equals(getCompletionDate(), milestone.getCompletionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getProject(), getDescription(), getDueDate(), getCompletionDate());
    }
}
