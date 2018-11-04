package Database;

import Task.Task;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDatabaseModifier {

    public void addTaskToDatabase(Task task) throws SQLException {
        String query = "INSERT INTO task VALUES" +
                "(?," +
                "?," +
                "?);";
        PreparedStatement preparedStatement = DatabaseInitializer.CONNECTION.prepareStatement(query);
        preparedStatement.setString(1, task.getDate());
        preparedStatement.setString(2, task.getTaskDescription());
        preparedStatement.setString(3, task.getTaskPriority());
        preparedStatement.executeUpdate();
        System.out.println("Task was added");
    }

    public void deleteTaskFromDatabase(Task task) throws SQLException {
        String query = "DELETE FROM task WHERE " +
                "date = ? AND " +
                "description = ? AND " +
                "priority = ?;";
        PreparedStatement preparedStatement = DatabaseInitializer.CONNECTION.prepareStatement(query);
        preparedStatement.setString(1, task.getDate());
        preparedStatement.setString(2, task.getTaskDescription());
        preparedStatement.setString(3, task.getTaskPriority());
        preparedStatement.executeUpdate();
        System.out.println("Task was deleted");
    }
}
