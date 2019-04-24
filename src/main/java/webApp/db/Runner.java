package webApp.db;
import webApp.milestone.Milestone;
import java.util.List;

public class Runner {

    public static void main (String[] args){
        MilestoneDB db = new MilestoneDB();
        Milestone milestone1 = new Milestone("Review code", "Programming", "Complete the WPD assignment", "20-10-2019");
        Milestone milestone2 = new Milestone("Listen to MOTS", "Support BTS", "Listen to their most recent album", "13-05-2019");
        Milestone milestone3 = new Milestone("Peer Meeting", "Big Data", "Go get support lol.", "05-07-2019");


        db.addMilestone(milestone1);
        db.addMilestone(milestone2);
        db.addMilestone(milestone3);

        List<Milestone> milestones = db.getMilestones();

        System.out.println();
        System.out.println();
        System.out.println("YOUR LIST OF MILESTONES:");
        System.out.println("-------------------");
        System.out.println();
        for(int i=0; i<milestones.size(); i++){
            System.out.println(milestones.get(i).toString());
        }

        db.deleteMilestone(milestone1);

        milestones = db.getMilestones();

        System.out.println();
        System.out.println();
        System.out.println("YOUR NEW LIST OF MILESTONES:");
        System.out.println("-------------------");
        System.out.println();
        for(int i=0; i<milestones.size(); i++) {
            System.out.println(milestones.get(i).toString());
        }

    }
}
