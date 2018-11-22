package TaskManagement;
import Database.DatabaseInitializer;
import TaskObject.Task;
import Utilites.LoopScanner;

import java.sql.*;

abstract class AbstractManager {
    private LoopScanner loopScanner = new LoopScanner();
    private DatabaseInitializer databaseInitializer = new DatabaseInitializer();

    final void addTask(Task task) throws SQLException {
        String query = "INSERT INTO task VALUES" +
                "(?," +
                "?," +
                "?);";
        PreparedStatement preparedStatement = databaseInitializer.getConnection().prepareStatement(query);
        preparedStatement.setString(1, task.getDate());
        preparedStatement.setString(2, task.getTaskDescription());
        preparedStatement.setString(3, task.getTaskPriority());
        preparedStatement.executeUpdate();
        System.out.println("Task was added");
    }

    final void deleteTask() throws SQLException {
        int rowid = loopScanner.readID();
        if (isExistingID(rowid)) {
            String query = "DELETE FROM task WHERE rowid = " + rowid + ";";
            PreparedStatement preparedStatement = databaseInitializer.getConnection().prepareStatement(query);
            preparedStatement.executeUpdate();
            System.out.println("Task was deleted.");
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
        String query = "UPDATE task SET " + columnName + " = '" + value + "' WHERE rowid = " + rowid+";";
        if(isExistingID(rowid)) {
            Statement statement = databaseInitializer.getConnection().createStatement();
            statement.execute(query);
        }
    }


    final void searchTasks(String subQuery) throws SQLException {
        String query = "SELECT rowid, start_date, description, priority FROM task" + subQuery;

        Statement statement = databaseInitializer.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        showFoundedTasks(resultSet, resultSetMetaData);
    }

    private void showFoundedTasks(ResultSet resultSet, ResultSetMetaData resultSetMetaData) throws SQLException {
        int columnsNumber = resultSetMetaData.getColumnCount();
        int counter = 1;
        while (resultSet.next()){
            System.out.print(counter++ + ". ");
            for(int i = 1; i<= columnsNumber; i++)
                System.out.print(resultSet.getString(i) + " ");
            System.out.println();
        }
        System.out.println();
    }
}
