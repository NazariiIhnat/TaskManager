package Task;

import Database.DatabaseInitializer;
import Utilites.LoopScanner;

import java.sql.*;

public class TaskSearcher {
    private  DatabaseInitializer databaseInitializer = new DatabaseInitializer();
    private  LoopScanner loopScanner = new LoopScanner();

    public static void main(String[] args) throws SQLException {
        TaskSearcher taskSearcher = new TaskSearcher();
        taskSearcher.searchTasksByDate();
        taskSearcher.searchTasksByPriority();
        taskSearcher.searchTasksByPartOfDescription();
        taskSearcher.searchTasksByRangeOfDate();
    }

    public void searchTasksByDate() throws SQLException {
        String subQuery = "date = '" + loopScanner.readDate() + "';";
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
        String subQuery = "date BETWEEN '" + loopScanner.readDate() + "' AND '" + loopScanner.readDate() + "';";
        searchTasks(subQuery);
    }

    private void searchTasks(String subQuery) throws SQLException {
        String query = "SELECT * FROM task " +
                "WHERE " + subQuery;

        Statement statement = databaseInitializer.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

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
