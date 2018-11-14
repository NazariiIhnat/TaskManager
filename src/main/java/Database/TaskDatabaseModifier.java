package Database;

import Task.Task;
import Utilites.LoopScanner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskDatabaseModifier {
    private DatabaseInitializer databaseInitializer = new DatabaseInitializer();
    private LoopScanner loopScanner = new LoopScanner();

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

    public void deleteTaskFromDatabase() throws SQLException {
        int rowid = loopScanner.readID();
        if (isExistingID(rowid)) {
            String query = "DELETE FROM task WHERE rowid = " + rowid + ";";
            PreparedStatement preparedStatement = databaseInitializer.connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            System.out.println("Task was deleted.");
        }
    }

    private boolean isExistingID(int rowid) {
        String query = "SELECT rowid FROM task " +
                "WHERE rowid = " + rowid +";";
        try {
            Statement statement = databaseInitializer.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.getInt(1);
            return true;
        } catch (SQLException e) {
            System.out.println("Task with id " + rowid + " doesn't exist.");
            return false;
        }
    }

    //методи для зміни даних завдання
}
