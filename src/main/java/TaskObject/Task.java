package TaskObject;

import TaskManagement.TasksUpdater;

import java.sql.SQLException;

public class Task {
    private String id;
    private String startDate;
    private String description;
    private String priority;
    private TasksUpdater tasksUpdater;

    public Task(String startDate, String description, String priority) throws SQLException {
        tasksUpdater = new TasksUpdater();
        this.startDate = startDate;
        this.description = description;
        this.priority = priority;
        tasksUpdater.addTaskToDatabase(this);
    }

    public Task(String id, String date, String taskDescription, String taskPriority) {
        this.id = id;
        this.startDate = date;
        this.description = taskDescription;
        this.priority = taskPriority;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", date='" + startDate + '\'' +
                ", description='" + description + '\'' +
                ", taskPriority='" + priority + '\'' +
                '}';
    }
}
