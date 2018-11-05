package Task;

import Database.*;
import Utilites.LoopScanner;
import java.sql.SQLException;
import java.util.Scanner;

public class Task {
    private LoopScanner loopScanner = new LoopScanner();
    private String date;
    private String taskDescription;
    private String taskPriority;

    public static void main(String[] args) throws SQLException {
        Task task = new Task();
    }

    public Task() throws SQLException {
        DatabaseInitializer databaseInitializer = new DatabaseInitializer();
        TaskDatabaseModifier taskDatabaseModifier = new TaskDatabaseModifier();

        System.out.println("Set the start day of your task.");
        date = loopScanner.readDate();
        System.out.println("Describe your task.");
        taskDescription = loopScanner.readDescription();
        System.out.println("Set priority of task from A to D");
        taskPriority = loopScanner.readPriority();
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
