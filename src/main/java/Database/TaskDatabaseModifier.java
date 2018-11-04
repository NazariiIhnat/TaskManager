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
    }
}
