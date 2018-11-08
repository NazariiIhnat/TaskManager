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
        taskSearcher.searchTasksByDescription();
        taskSearcher.searchTasksByPriority();
        taskSearcher.searchTasksByKeyWord();
        taskSearcher.searchTasksByRangeOfDate();
    }

    public void searchTasksByDate() throws SQLException {
        String query = "SELECT * FROM task " +
                "WHERE date = '" + loopScanner.readDate() + "';";
        searchTasks(query);
    }

    public void searchTasksByDescription() throws SQLException {
        String query = "SELECT * FROM task " +
                "WHERE description = '" + loopScanner.readDescription() + "';";
        searchTasks(query);
    }

    public void searchTasksByPriority() throws SQLException {
        String query = "SELECT * FROM task " +
                "WHERE priority = '" + loopScanner.readPriority() + "';";
        searchTasks(query);
    }

    public void searchTasksByKeyWord() throws SQLException {
        String query = "SELECT * FROM task " +
                "WHERE description LIKE '%" + loopScanner.readDescription() + "%';";
        searchTasks(query);
    }

    public void searchTasksByRangeOfDate() throws SQLException {
        String query = "SELECT * FROM task " +
                "WHERE date BETWEEN '" + loopScanner.readDate() + "' AND '" + loopScanner.readDate() + "';";
        searchTasks(query);
    }

    private void searchTasks(String query) throws SQLException {

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
