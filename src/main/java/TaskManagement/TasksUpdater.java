package TaskManagement;

import TaskObject.Task;
import Utilites.LoopScanner;

import java.sql.SQLException;

public class TasksUpdater extends AbstractTaskManager {

    public void addTaskToDatabase(Task task) throws SQLException {
        super.addTask(task);
    }

    public void deleteTaskFromDatabase() throws SQLException {
        super.deleteTask();
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
}
