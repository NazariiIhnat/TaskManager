package Task;

import Database.DatabaseInitializer;
import Utilites.LoopScanner;

import java.sql.*;

public class TaskSearcher {
    private  DatabaseInitializer databaseInitializer = new DatabaseInitializer();
    private  LoopScanner loopScanner = new LoopScanner();

    public void searchTasksByDate() throws SQLException {
        String subQuery = "start_date = '" + loopScanner.readDate() + "';";
        searchTasks(subQuery);
    }

    public void searchTasksByPriority() throws SQLException {
        String subQuery = "priority = '" + loopScanner.readPriority() + "';";
        searchTasks(subQuery);
    }

    public void searchTasksByPartOfDescription() throws SQLException {
        String subQuery = "description LIKE '%" + loopScanner.readDescription() + "%';";
        searchTasks(subQuery);
    }

    public void searchTasksByRangeOfDate() throws SQLException {
        String subQuery = "start_date BETWEEN '" + loopScanner.readDate() + "' AND '" + loopScanner.readDate() + "';";
        searchTasks(subQuery);
    }

    public void showTaskByID() throws SQLException {
        String subQuery = "rowid = " + loopScanner.readID() + ";";
        searchTasks(subQuery);
    }

    private void searchTasks(String subQuery) throws SQLException {
        String query = "SELECT rowid, start_date, description, priority FROM task " +
                "WHERE " + subQuery;

        Statement statement = databaseInitializer.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        showTasks(resultSet, resultSetMetaData);
    }

    private void showTasks(ResultSet resultSet, ResultSetMetaData resultSetMetaData) throws SQLException {

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
