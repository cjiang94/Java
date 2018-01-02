import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Oblig2 {
  public static void main(String[] args) throws Exception{

    String filename = args[0];
    File new_File = new File(filename);
    Scanner in = new Scanner(new_File);

    ArrayList<Tasks> arrayList_of_tasks = new ArrayList<Tasks>();

    int number_of_tasks = Integer.parseInt(in.nextLine());

    // Blank line
    in.nextLine();

    for(int i = 0; i < number_of_tasks; i++) {
      int task_ID, est_Time, manpower;
      String task_name;

      String whole_line = in.nextLine();

      String[] parts = whole_line.split("\\s+");

      ArrayList<Integer> dep_edges = new ArrayList<Integer>();
      task_ID = Integer.parseInt(parts[0]);
      task_name = parts[1];
      est_Time = Integer.parseInt(parts[2]);
      manpower = Integer.parseInt(parts[3]);

      for(int j = 4; j < parts.length-1; j++) {
        dep_edges.add(Integer.parseInt(parts[j]));
      }

      arrayList_of_tasks.add(new Tasks(task_ID, task_name, est_Time, manpower, dep_edges));

    }

    for(Tasks task : arrayList_of_tasks) {
      for(int i : task.dep_edges) {
        task.in_edges.add(arrayList_of_tasks.get(i-1));
        arrayList_of_tasks.get(i-1).out_edges.add(task);
      }
    }

    for(Tasks task : arrayList_of_tasks) {
      // Checks if we don't have a loop. If we have a loop the program executes.
      if(start_loop != null) {
        return;
      }
      search_loop(task);
      // Resets every task status so next recursive call will work on every task
      for(int i = 0; i < number_of_tasks; i++) {
        arrayList_of_tasks.get(i).status = "unseen";
      }
    }

    print_all(arrayList_of_tasks);

    for(Tasks task : arrayList_of_tasks) {
      task.print_info();
    }

  } // End main


  // Method to print the timeline
  public static void print_all(ArrayList<Tasks> arrayList_of_tasks) {
    int crit_time = calculate_time(arrayList_of_tasks);

    System.out.println("\n\n   ~~ Listing output for graph ~~");
      int manpower_sum = 0;
      for (int i = 0; i <= crit_time; i++) {
        boolean changed = false;
        ArrayList<Tasks> start = new ArrayList<Tasks>();
        ArrayList<Tasks> finish = new ArrayList<Tasks>();

        for(Tasks task : arrayList_of_tasks) {
          if(task.earliestStart == i) {
            start.add(task);
            manpower_sum += task.manpower;
            changed = true;
          } else if(task.earliestFinish == i) {
            finish.add(task);
            manpower_sum -= task.manpower;
            changed = true;
          }

        }
        if(changed) {
        System.out.println("Time: " + i);
        for(Tasks t : finish) {
          System.out.println("     Finished: " + t.task_ID);
        }
        for(Tasks t : start) {
          System.out.println("     Starting: " + t.task_ID);
        }

        System.out.println("     Current staff: " + manpower_sum);

        }

    }

    System.out.println("\n**** Shortest possible project execution is " + crit_time + " ****\n\n");
  }

  /* A method to set earliestStart, earliestFinish, latestStart, latestFinish for each task
  * Does it by having two arraylists "queue" and "finished_queue". Queue contains all tasks and is moved into finished_queue
  * when all it's in_edges is finished
  */
  public static int calculate_time(ArrayList<Tasks> arrayList_of_tasks) {
    ArrayList<Tasks> queue = new ArrayList<Tasks>(arrayList_of_tasks);
    ArrayList<Tasks> finished_queue = new ArrayList<Tasks>();

    Tasks tempTask = null;
    int time_counter = 0;
    int opposite_time_counter = 0;
    while(!queue.isEmpty()) {
      tempTask = queue.remove(0);
      if(finished_queue.containsAll(tempTask.in_edges)){
        time_counter = 0;

        for(Tasks task : tempTask.in_edges) {
          if(task.earliestFinish > time_counter) {
            time_counter = task.earliestFinish;
          }
        }
        tempTask.earliestStart = time_counter;
        tempTask.earliestFinish = tempTask.est_Time + time_counter;
        if(tempTask.earliestFinish > opposite_time_counter) {
        opposite_time_counter = tempTask.earliestFinish;
        }
        finished_queue.add(tempTask);

        } else {
          queue.add(tempTask);
        }
    }

    Tasks temp_task = null;
    int counter = 0;

    for(int i = finished_queue.size()-1; i >= 0; i--) {
      temp_task = finished_queue.get(i);
      counter = opposite_time_counter;
      for(Tasks out_tasks : temp_task.out_edges) {
        if(out_tasks.latestStart < counter) {
          counter = out_tasks.latestStart;
        }
      }
        temp_task.latestFinish = counter;
        temp_task.latestStart = temp_task.latestFinish - temp_task.est_Time;
        temp_task.slack = temp_task.latestStart - temp_task.earliestStart;

        if(temp_task.latestStart == temp_task.earliestStart) {
          temp_task.crit = true;
        }

    }

    return opposite_time_counter;
  }

  static Tasks start_loop = null;
  static ArrayList<Tasks> loop_list = new ArrayList<Tasks>();
  static private int counter = 0;


  // A method to search if there's a loop in the graph by using recursion
  public static void search_loop(Tasks v) {
    int nr = counter;
    counter++;

      if (v.status.equals("unseen")) {
        v.status = "running";
        loop_list.add(v);
        for (Tasks out_task : v.out_edges) {
          if(start_loop != null) {
            return;
          }
            search_loop(out_task);
        }

        if(start_loop != null) {
          return;
        }
        loop_list.remove(nr);
        v.status = "finished";
      } else if(v.status.equals("running")) {
        start_loop = v;
        loop_list.add(v);
        System.out.print("\n\nThis graph contains a loop: ");

        int search_start_loop = 0;
        for(int i = 0; i < loop_list.size(); i++) {
          if(loop_list.get(i).task_ID == v.task_ID) {
            search_start_loop = i;
            break;
          }
        }

        for(int j = search_start_loop; j < loop_list.size(); j++) {
          System.out.print(loop_list.get(j).task_ID + ", ");

        }
        // Empty new line
        System.out.println();
      }

    counter--;
  }

}
