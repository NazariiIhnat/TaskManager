package TaskMenegment;

import Database.DatabaseInitializer;
import TaskObject.Task;
import Utilites.DataVerifier;
import Utilites.LoopScanner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TasksUpdater {
    private DatabaseInitializer databaseInitializer = new DatabaseInitializer();
    private LoopScanner loopScanner = new LoopScanner();
    private DataVerifier dataVerifier = new DataVerifier();

    public static void main(String[] args) throws SQLException {
        TasksUpdater taskDatabaseModifier = new TasksUpdater();
        taskDatabaseModifier.updateTaskDescription();
    }

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
        System.out.println("TaskObject was added");
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
            System.out.println("Task with ID " + rowid + " doesn't exist.");
            return false;
        }
    }

    public void updateTaskDate() throws SQLException {
        String columnName = "start_date";
        String value;
        int rowid;
        System.out.println("Set new start date");
        do {
            value = loopScanner.readDate();
        } while (dataVerifier.isPastDay(value));
        System.out.println("of task ID");
        rowid = loopScanner.readID();
        if(isExistingID(rowid))
            updateTask(columnName, value, rowid);
    }

    public void updateTaskDescription() throws SQLException {
        String columnName = "description";
        String value;
        int rowid;
        System.out.println("Set new description ");
        value = loopScanner.readDescription();
        System.out.println("of task ID ");
        rowid = loopScanner.readID();
        if(isExistingID(rowid))
            updateTask(columnName, value, rowid);
    }

    private void updateTask(String columnName, String value, int rowid) throws SQLException {
        String query = "UPDATE task SET " + columnName + " = '" + value + "' WHERE rowid = " + rowid;

        PreparedStatement preparedStatement = databaseInitializer.connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }
}
