package TaskManagement;

import TaskObject.Task;
import Utilites.LoopScanner;

import java.sql.SQLException;

public class TasksUpdater extends AbstractTaskManager {
    private LoopScanner loopScanner = new LoopScanner();

    public static void main(String[] args) throws SQLException {
        TasksUpdater tasksUpdater = new TasksUpdater();
        tasksUpdater.updateTaskDescription();
    }

    public void addTaskToDatabase(Task task) throws SQLException {
        super.addTask(task);
    }

    public void deleteTaskFromDatabase() throws SQLException {
        super.deleteTask();
    }

    public void updateTaskDate() throws SQLException {
        updateTask("start_date", loopScanner.readDate(), loopScanner.readID());
    }

    public void updateTaskDescription() throws SQLException {
        updateTask("description", loopScanner.readDescription(), loopScanner.readID());
    }

    public void updateTaskPriority() throws SQLException {
        updateTask("priority", loopScanner.readPriority(), loopScanner.readID());
    }
}
