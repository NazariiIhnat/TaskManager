package Database.TaskManagement;
import Database.DatabaseInitializer;
import TaskObject.Status;
import TaskObject.Task;
import Utilites.DataVerifier;

import java.sql.*;
import java.util.ArrayList;

abstract class AbstractTaskManager {
    private DatabaseInitializer databaseInitializer = new DatabaseInitializer();
    static ArrayList<Task> listOfFoundedTaskObjects = new ArrayList<Task>();

    final void addTask(Task task) throws SQLException {
        String query = "INSERT INTO task VALUES" +
                "(?," +
                "?," +
                "?," +
                "?);";
        PreparedStatement preparedStatement = databaseInitializer.getConnection().prepareStatement(query);
        preparedStatement.setString(1, task.getDate());
        preparedStatement.setString(2, task.getDescription());
        preparedStatement.setString(3, task.getTaskPriority());
        preparedStatement.setString(4, task.getStatus().name());
        preparedStatement.executeUpdate();
    }

    final void deleteTask(int rowid) throws SQLException {
        if (isExistingID(rowid)) {
            String query = "DELETE FROM task WHERE rowid = " + rowid + ";";
            PreparedStatement preparedStatement = databaseInitializer.getConnection().prepareStatement(query);
            preparedStatement.executeUpdate();
        }
    }

    private boolean isExistingID(int rowid) {
        String query = "SELECT rowid FROM task " +
                "WHERE rowid = " + rowid +";";
        try {
            Statement statement = databaseInitializer.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.getInt(1);
            return true;
        } catch (SQLException e) {
            System.out.println("Task with ID " + rowid + " doesn't exist.");
            return false;
        }
    }

    final void updateTask(String columnName, String value, int rowid) throws SQLException {
        String query = "UPDATE task SET " + columnName + " = ? WHERE rowid = " + rowid + ";";
        if(isExistingID(rowid)) {
            PreparedStatement preparedStatement = databaseInitializer.getConnection().prepareStatement(query);
            preparedStatement.setString(1, value);
            preparedStatement.executeUpdate();
        }
    }

    final void searchTasks(String subQuery) throws SQLException {
        String query = "SELECT rowid, start_date, description, priority, status FROM task " + subQuery +
                "ORDER BY start_date, priority;";
        Statement statement = databaseInitializer.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        importFoundedTaskObjectsToArrayList(resultSet);
    }

    private void importFoundedTaskObjectsToArrayList(ResultSet resultSet) throws SQLException {
        listOfFoundedTaskObjects.clear();
        while (resultSet.next()){
            String rowid = resultSet.getString("rowid");
            String date = resultSet.getString("start_date");
            String description = resultSet.getString("description");
            String priority = resultSet.getString("priority");
            String status = resultSet.getString("status");
            if(!status.equals(Status.DONE.name()))
                if(DataVerifier.isUndoneTask(date))
                    status = Status.UNDONE.name();
            listOfFoundedTaskObjects.add(new Task(rowid, date, description, priority, Status.valueOf(status)));
        }
    }
}
