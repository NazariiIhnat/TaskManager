package Task;

import Database.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Task {
    private String date;
    private String taskDescription;
    private String taskPriority;

    public static void main(String[] args) throws SQLException {
        Task task = new Task();
    }

    public Task() throws SQLException {
        DatabaseInitializer databaseInitializer = new DatabaseInitializer();
        Scanner scanner = new Scanner(System.in);
        TaskDatabaseModifier taskDatabaseModifier = new TaskDatabaseModifier();

        System.out.println("Set the start day of your task.");
        date = scanner.nextLine();
        System.out.println("Describe your task.");
        taskDescription = scanner.nextLine();
        System.out.println("Set priority of task from A to D");
        taskPriority = scanner.nextLine();
        scanner.close();
        taskDatabaseModifier.addTaskToDatabase(this);
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
