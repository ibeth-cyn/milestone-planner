//package webApp.db;
//import webApp.milestone.Milestone;
//import java.util.List;
//
//public class Runner {
//
//    public static void main (String[] args){
//
//        MilestoneDB db = new MilestoneDB();
//        Milestone milestone1 = new Milestone("Review code", "Programming", "Complete the WPD assignment", "2019-10-20", "true");
//        Milestone milestone2 = new Milestone("Listen to MOTS", "Support BTS", "Listen to their most recent album", "2019-05-13", "false");
//        Milestone milestone3 = new Milestone("Peer Meeting", "Big Data", "Go get support lol.", "2019-07-05", "true");
//
//
//        db.addMilestone(milestone1);
//        db.addMilestone(milestone2);
//        db.addMilestone(milestone3);
//
//        List<Milestone> milestones = db.getMilestones();
//
//        System.out.println();
//        System.out.println();
//        System.out.println("YOUR LIST OF MILESTONES:");
//        System.out.println("-------------------");
//        System.out.println();
//        for(int i=0; i<milestones.size(); i++){
//            System.out.println(milestones.get(i).toString());
//        }
//
//        int id = milestone1.getId();
//        milestone1 = new Milestone(id,"UPDATE - Review code", "Programming", "Completmilestonedbe the WPD assignment", "2019-10-20", "false");
//        db.updateMilestone(milestone1);
//
//        milestones = db.getMilestones();
//
//        System.out.println();
//        System.out.println();
//        System.out.println("YOUR NEW LIST OF MILESTONES:");
//        System.out.println("-------------------");
//        System.out.println();
//        for(int i=0; i<milestones.size(); i++) {
//            System.out.println(milestones.get(i).toString());
//        }
//
//    }
//}
