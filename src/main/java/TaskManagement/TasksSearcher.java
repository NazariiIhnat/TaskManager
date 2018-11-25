package TaskManagement;

import TaskObject.Task;
import Utilites.LoopScanner;

import java.sql.*;
import java.util.ArrayList;

public class TasksSearcher extends AbstractTaskManager {
    private  LoopScanner loopScanner = new LoopScanner();

    public void searchTasksByDate() throws SQLException {
        String subQuery = " WHERE start_date = '" + loopScanner.readDate() + "';";
        searchTasks(subQuery);
    }

    public void searchTasksByPriority(String priorityLetter) throws SQLException {
        String subQuery = " WHERE priority = '" + priorityLetter + "';";
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

    public static ArrayList<Task> getListOfFoundedTaskObjects() {
        return listOfFoundedTaskObjects;
    }
}
