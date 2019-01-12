package TaskManagement;

import TaskObject.Status;
import TaskObject.Task;

import java.sql.SQLException;

public class TasksUpdater extends AbstractTaskManager {

    public void addTaskToDatabase(Task task) throws SQLException {
        super.addTask(task);
    }

    public void deleteTaskFromDatabase(int rowid) throws SQLException {
        super.deleteTask(rowid);
    }

    public void updateTaskDate(int taskID, String date) throws SQLException {
        updateTask("start_date", date, taskID);
    }

    public void updateTaskDescription(int taskID, String description) throws SQLException {
        updateTask("description", description, taskID);
    }

    public void updateTaskPriority(int taskID, String priority) throws SQLException {
        updateTask("priority", priority, taskID);
    }

    public void updateTaskStatus(int taskID, Status status) throws SQLException {
        updateTask("status", status.name(), taskID);
    }
}
