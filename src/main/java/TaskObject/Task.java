package TaskObject;

import TaskManagement.TasksUpdater;
import Utilites.DataVerifier;
import Utilites.LoopScanner;
import java.sql.SQLException;

public class Task {
    private LoopScanner loopScanner = new LoopScanner();
    private DataVerifier dataVerifier = new DataVerifier();
    private TasksUpdater tasksUpdater = new TasksUpdater();
    private String id;
    private String date;
    private String taskDescription;
    private String taskPriority;

    public Task() throws SQLException {
        do {
            date = loopScanner.readDate();
        }while (dataVerifier.isPastDay(date));
        taskDescription = loopScanner.readDescription();
        taskPriority = loopScanner.readPriority();
        tasksUpdater.addTaskToDatabase(this);
    }

    public Task(String id, String date, String taskDescription, String taskPriority) {
        this.id = id;
        this.date = date;
        this.taskDescription = taskDescription;
        this.taskPriority = taskPriority;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setTaskPriority(String taskPriority) {
        this.taskPriority = taskPriority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskPriority='" + taskPriority + '\'' +
                '}';
    }
}
