package Database;

import Task.Task;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDatabaseModifier {
    private DatabaseInitializer databaseInitializer = new DatabaseInitializer();

    public void addTaskToDatabase(Task task) throws SQLException {
        String query = "INSERT INTO task VALUES" +
                "(?," +
                "?," +
                "?);";
        PreparedStatement preparedStatement = databaseInitializer.connection.prepareStatement(query);
        preparedStatement.setString(1, task.getDate());
        preparedStatement.setString(2, task.getTaskDescription());
        preparedStatement.setString(3, task.getTaskPriority());
        preparedStatement.executeUpdate();
        System.out.println("Task was added");
    }
    //delete task from db method
}
