package Database.TaskManagement;

import GUI.TaskTableObject.TaskTable;
import TaskObject.Task;

import java.sql.*;
import java.util.ArrayList;

public class TasksSearcher extends AbstractTaskManager {

    public void searchTasksByDate(String date) throws SQLException {
        String subQuery = " WHERE start_date = '" + date + "' ";
        searchTasks(subQuery);
        TaskTable.setNameOfLastSearchingMethod("date");
    }

    public void searchTasksByPriority(String priorityLetter) throws SQLException {
        String subQuery = " WHERE priority = '" + priorityLetter + "' ";
        searchTasks(subQuery);
        TaskTable.setNameOfLastSearchingMethod("priority");
    }

    public void searchTasksByDescription(String description) throws SQLException {
        String subQuery = " WHERE description LIKE '%" + generateCorrectSearchingValue(description) + "%' ";
        searchTasks(subQuery);
        TaskTable.setNameOfLastSearchingMethod("description");
    }

    public void searchTasksByRangeOfDate(String from, String to) throws SQLException {
        String subQuery = " WHERE start_date >= '" + from + "' AND start_date <= '" + to + "' ";
        searchTasks(subQuery);
        TaskTable.setNameOfLastSearchingMethod("range of dates");
    }

    public void searchTaskByID(String id) throws SQLException {
        String subQuery = " WHERE rowid = '" + generateCorrectSearchingValue(id) + "' ";
        searchTasks(subQuery);
        TaskTable.setNameOfLastSearchingMethod("id");
    }

    public void searchAllTasks() throws  SQLException {
        String subQuery = "";
        searchTasks(subQuery);
        TaskTable.setNameOfLastSearchingMethod("all");
    }

    // if searching value has apostrophe(like in a word it's) this method will return it''s
    // it's necessary for correct DB query
    private String generateCorrectSearchingValue(String value) {
        StringBuilder stringBuilder = new StringBuilder(value);
        char apostrophe = '\'';
        for(int position = 0; position < stringBuilder.length(); position++){
            if(stringBuilder.charAt(position) == apostrophe) {
                stringBuilder.insert(position, apostrophe);
                position++;
            }
        }
        return stringBuilder.toString();
    }

    public static ArrayList<Task> getListOfFoundedTaskObjects() {
        return listOfFoundedTaskObjects;
    }
}
