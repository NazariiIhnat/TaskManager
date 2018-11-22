package TaskManagement;

import Utilites.LoopScanner;

import java.sql.*;

public class TasksSearcher extends AbstractManager {
    private  LoopScanner loopScanner = new LoopScanner();

    public static void main(String[] args) throws SQLException {
        TasksSearcher tasksSearcher = new TasksSearcher();
        tasksSearcher.showAllTasks();
    }

    public void searchTasksByDate() throws SQLException {
        String subQuery = " WHERE start_date = '" + loopScanner.readDate() + "';";
        searchTasks(subQuery);
    }

    public void searchTasksByPriority() throws SQLException {
        String subQuery = " WHERE priority = '" + loopScanner.readPriority() + "';";
        searchTasks(subQuery);
    }

    public void searchTasksByPartOfDescription() throws SQLException {
        String subQuery = " WHERE description LIKE '%" + loopScanner.readDescription() + "%';";
        searchTasks(subQuery);
    }

    public void searchTasksByRangeOfDate() throws SQLException {
        String subQuery = " WHERE start_date BETWEEN '" + loopScanner.readDate() + "' AND '" + loopScanner.readDate() + "';";
        searchTasks(subQuery);
    }

    public void searchTaskByID() throws SQLException {
        String subQuery = " WHERE rowid = " + loopScanner.readID() + ";";
        searchTasks(subQuery);
    }

    public void showAllTasks() throws  SQLException {
        String subQuery = ";";
        searchTasks(subQuery);
    }
}
