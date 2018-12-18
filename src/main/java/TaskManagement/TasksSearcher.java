package TaskManagement;

import GUI.TaskTableObject.TaskTable;
import TaskObject.Task;
import Utilites.LoopScanner;

import java.sql.*;
import java.util.ArrayList;

public class TasksSearcher extends AbstractTaskManager {

    public void searchTasksByDate(String date) throws SQLException {
        String subQuery = " WHERE start_date = '" + date + "';";
        searchTasks(subQuery);
        TaskTable.setNameOfLastSearchingMethod("date");
    }

    public void searchTasksByPriority(String priorityLetter) throws SQLException {
        String subQuery = " WHERE priority = '" + priorityLetter + "';";
        searchTasks(subQuery);
        TaskTable.setNameOfLastSearchingMethod("priority");
    }

    public void searchTasksByDescription(String description) throws SQLException {
        String subQuery = " WHERE description LIKE '%" + description + "%';";
        searchTasks(subQuery);
        TaskTable.setNameOfLastSearchingMethod("description");
    }

    public void searchTasksByRangeOfDate(String from, String to) throws SQLException {
        String subQuery = " WHERE start_date >= '" + from + "' AND start_date <= '" + to + "';";
        searchTasks(subQuery);
        TaskTable.setNameOfLastSearchingMethod("range of dates");
    }

    public void searchTaskByID(String id) throws SQLException {
        String subQuery = " WHERE rowid = '" + id + "';";
        searchTasks(subQuery);
        TaskTable.setNameOfLastSearchingMethod("id");
    }

    public void searchAllTasks() throws  SQLException {
        String subQuery = ";";
        searchTasks(subQuery);
        TaskTable.setNameOfLastSearchingMethod("all");
    }

    public static ArrayList<Task> getListOfFoundedTaskObjects() {
        return listOfFoundedTaskObjects;
    }
}
