package webApp.milestone;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Milestone{

    private String name;
    private String project;
    private String description;
    private String dueDate;

    //Setting automatic completion date
    String pattern = "yyyy-MM-dd";
    DateFormat dateFormat = new SimpleDateFormat(pattern);
    Date date = new Date();

    private String completionDate = dateFormat.format(date);

    //Constructors
    public Milestone(String name, String project, String description, String dueDate){
        this.name = name;
        this.project = project;
        this.description = description;
        this.dueDate = dueDate;
    }

    //Getters and setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    //Getters and setters for completionDate

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    @Override
    public String toString() {
        return "Milestone{" +
                "name='" + name + '\'' +
                ", project='" + project + '\'' +
                ", description='" + description + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", completionDate='" + completionDate + '\'' +
                '}';
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
