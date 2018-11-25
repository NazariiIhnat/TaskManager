package TaskManagement;
import Database.DatabaseInitializer;
import GUI.TaskTableObject.TaskTable;
import GUI.TaskTableObject.TaskTableModel;
import TaskObject.Task;
import Utilites.LoopScanner;

import java.sql.*;
import java.util.ArrayList;

abstract class AbstractManager {
    private LoopScanner loopScanner = new LoopScanner();
    private DatabaseInitializer databaseInitializer = new DatabaseInitializer();
    private ArrayList<Task> listOfTasks = new ArrayList<>();
    private TaskTableModel taskTableModel;

    final void addTask(Task task) throws SQLException {
        String query = "INSERT INTO task VALUES" +
                "(?," +
                "?," +
                "?);";
        PreparedStatement preparedStatement = databaseInitializer.getConnection().prepareStatement(query);
        preparedStatement.setString(1, task.getDate());
        preparedStatement.setString(2, task.getDescription());
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
        importFoundedTasksToArrayListOfTaskObjects(query, resultSet);
    }

    public final void importFoundedTasksToArrayListOfTaskObjects(String query, ResultSet resultSet) throws SQLException {
        Statement statement = databaseInitializer.getConnection().createStatement();
        resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            String rowid = resultSet.getString("rowid");
            String date = resultSet.getString("start_date");
            String description = resultSet.getString("description");
            String priority = resultSet.getString("priority");
            listOfTasks.add(new Task(rowid, date, description, priority));
        }
        taskTableModel = new TaskTableModel();
        taskTableModel.setListOfTasks(listOfTasks);
    }
}
