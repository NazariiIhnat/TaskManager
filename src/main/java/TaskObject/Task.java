package TaskObject;

import Database.TaskManagement.TasksUpdater;

import java.sql.SQLException;

public class Task {
    private String id;
    private String startDate;
    private String description;
    private String priority;
    private Status status;
    private TasksUpdater tasksUpdater;

    public Task(String startDate, String description, String priority) throws SQLException {
        tasksUpdater = new TasksUpdater();
        this.startDate = startDate;
        this.description = description;
        this.priority = priority;
        this.status = Status.IN_PROGRESS;
        tasksUpdater.addTaskToDatabase(this);
    }

    public Task(String id, String date, String taskDescription, String taskPriority, Status taskStatus) {
        this.id = id;
        this.startDate = date;
        this.description = taskDescription;
        this.priority = taskPriority;
        this.status = taskStatus;
    }

    public String getDate() {
        return startDate;
    }

    public String getDescription() {
        return description;
    }

    public String getTaskPriority() {
        return priority;
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }
}