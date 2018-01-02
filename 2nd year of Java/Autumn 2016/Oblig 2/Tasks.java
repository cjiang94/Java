import java.util.ArrayList;

public class Tasks {
  int task_ID, est_Time, manpower, earliestStart, earliestFinish, latestStart, latestFinish, slack;
  String task_name, status;
  ArrayList<Integer> dep_edges;
  ArrayList<Tasks> in_edges;
  ArrayList<Tasks> out_edges;
  boolean crit = false;



  public Tasks(int task_ID, String task_name, int est_Time, int manpower, ArrayList<Integer> dep_edges) {
    this.task_ID = task_ID;
    this.task_name = task_name;
    this.est_Time = est_Time;
    this.manpower = manpower;
    this.dep_edges = dep_edges;
    in_edges = new ArrayList<Tasks>();
    out_edges = new ArrayList<Tasks>();
    status = "unseen";

  }

  public void print_info() {
    System.out.println("=========Task " + task_ID + "=========");
    System.out.println("Task name: " + task_name);
    System.out.println("Estimated time: " + est_Time);
    System.out.println("Manpower: " + manpower);
    System.out.println("Earlier starting time: " + earliestStart);
    System.out.println("Earlier finishing time: " + earliestFinish);
    System.out.println("Latest starting time: " + latestStart);
    System.out.println("Latest finishing time: " + latestFinish);
    System.out.println("Crit: " + crit);
    System.out.println("Slack: " + slack);
    System.out.print("Dependency edges for task " + task_ID + " is: ");
    for(Tasks task: in_edges) {
      System.out.print(task.task_ID + ", ");
    }
    System.out.println("\n");
  }


}
