package Task;

import java.util.Scanner;

public class Task {
    private String date;
    private String taskDescription;
    private String taskPriority;
    private Scanner scanner;

    public Task(){
        scanner = new Scanner(System.in);
        System.out.println("Set the start day of your task.");
        date = scanner.nextLine();
        System.out.println("Describe your task.");
        taskDescription = scanner.nextLine();
        System.out.println("Set priority of task from A to D");
        taskPriority = scanner.nextLine();
    }

    public String getDate() {
        return date;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskPriority() {
        return taskPriority;
    }
}
