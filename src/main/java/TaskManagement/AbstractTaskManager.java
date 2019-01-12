package TaskManagement;
import Database.DatabaseInitializer;
import GUI.TaskTableObject.TaskTable;
import TaskObject.Status;
import TaskObject.Task;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

abstract class AbstractTaskManager {
    private DatabaseInitializer databaseInitializer = new DatabaseInitializer();
    static ArrayList<Task> listOfFoundedTaskObjects = new ArrayList<>();

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
        System.out.println("Task was added");
    }

    final void deleteTask(int rowid) throws SQLException {
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
        String query = "SELECT rowid, start_date, description, priority, status FROM task" + subQuery;
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
            String status;
            if(isNotFulFilledTask(date))
                status = Status.NOT_FULFILLED.name();
            else
                status = resultSet.getString("status");
            listOfFoundedTaskObjects.add(new Task(rowid, date, description, priority, Status.valueOf(status)));
        }
    }

    private boolean isNotFulFilledTask(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate taskDate = LocalDate.parse(date, dateTimeFormatter);
        return taskDate.isBefore(LocalDate.now());
    }
}
