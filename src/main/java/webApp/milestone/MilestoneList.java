package webApp.milestone;

import java.util.ArrayList;
import java.util.List;

public class MilestoneList {

    private static List<Milestone> milestones = new ArrayList<Milestone>();

    //static constructor for testing
    static {
//        milestones.add(new Milestone("Test Milestone", "Amazing","It is for project Amazing", "2019-09-01"));
//        milestones.add(new Milestone("Another Test Milestone", "Music","It is for project Music", "2019-06-01"));
    }

    //adding a milestone
    public void addMilestone(Milestone milestone){
        milestones.add(milestone);
    }

    //deleting a milestone
    public void deleteMilestone (Milestone milestone){
        milestones.remove(milestone);
    }

    //retrieving milestones
    public List<Milestone> retrieveMilestones(){
        return milestones;
    }

}
