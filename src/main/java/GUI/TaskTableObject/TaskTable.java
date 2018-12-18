package GUI.TaskTableObject;

import TaskManagement.TasksSearcher;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class TaskTable {
    private TasksSearcher tasksSearcher = new TasksSearcher();
    private static String lastSearchingValue = null;
    private static String nameOfLastSearchingMethod = "all";
    private static JTable taskTable = new JTable();
    private static JScrollPane taskTableScrollPane = new JScrollPane(taskTable);

    public TaskTable() throws SQLException {
        taskTable.setSize(new Dimension(100, 400));
        refreshTable();
    }

    public void refreshTable() throws SQLException {
        doLastSearch();
        taskTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskTable.setModel(new TaskTableModel());
    }

    private void doLastSearch() throws SQLException {
        switch (nameOfLastSearchingMethod){
            case "date" : tasksSearcher.searchTasksByDate(lastSearchingValue); break;
            case "priority" : tasksSearcher.searchTasksByPriority(lastSearchingValue); break;
            case "description" : tasksSearcher.searchTasksByDescription(lastSearchingValue); break;
            case "range of dates" : String [] firstAndLAstSelectedDays = lastSearchingValue.split(" ");
            tasksSearcher.searchTasksByRangeOfDate(firstAndLAstSelectedDays[0], firstAndLAstSelectedDays[1]);
            break;
            case "id" : tasksSearcher.searchTaskByID(lastSearchingValue); break;
            case "all" : tasksSearcher.searchAllTasks();
        }
    }

    public JScrollPane getTaskTableScrollPane() {
        return taskTableScrollPane;
    }

    public static void setLastSearchingValue(String lastSearchingValue) {
        TaskTable.lastSearchingValue = lastSearchingValue;
    }

    public static void setNameOfLastSearchingMethod(String nameOfLastSearchingMethod) {
        TaskTable.nameOfLastSearchingMethod = nameOfLastSearchingMethod;
    }
}
