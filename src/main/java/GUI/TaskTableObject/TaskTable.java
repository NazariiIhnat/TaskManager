package GUI.TaskTableObject;

import GUI.TaskDeletingComponents.DeleteButton;
import GUI.TaskModifyingComponents.UpdateButton;
import TaskManagement.TasksSearcher;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.sql.SQLException;

public class TaskTable {
    private TasksSearcher tasksSearcher = new TasksSearcher();
    private static String lastSearchingValue = null;
    private static String nameOfLastSearchingMethod = "all";
    private static JTable taskTable = new JTable();
    private static JScrollPane taskTableScrollPane = new JScrollPane(taskTable);
    private DeleteButton deleteButton = new DeleteButton();

    public TaskTable() throws SQLException {
        taskTable.setSize(new Dimension(100, 400));
        taskTable.getTableHeader().setReorderingAllowed(false);
        taskTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        refreshTable();
        disableModifyAndDeleteButtonsWhenTaskIsNotSelected();
    }

    private void disableModifyAndDeleteButtonsWhenTaskIsNotSelected() {
        taskTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(taskTable.getSelectedRow() > -1) {
                    UpdateButton.getModifyButton().setEnabled(true);
                    deleteButton.getDeleteButton().setEnabled(true);
                } else {
                    UpdateButton.getModifyButton().setEnabled(false);
                    deleteButton.getDeleteButton().setEnabled(false);
                }
            }
        });
    }

    public void refreshTable() throws SQLException {
        int numberOfSelectedRowBeforeTableRefreshing = taskTable.getSelectedRow();
        doLastSearch();
        taskTable.setModel(new TaskTableModel());
        refreshRowSelection(numberOfSelectedRowBeforeTableRefreshing);
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

    private void refreshRowSelection(int row) {
        taskTable.getSelectionModel().addSelectionInterval(row, row);
    }

    public static String getSelectedTaskID() {
        return (String) taskTable.getValueAt(taskTable.getSelectedRow(), 0);
    }

    public static String getSelectedTaskStartDate() {
        return (String) taskTable.getValueAt(taskTable.getSelectedRow(), 1);
    }

    public static String getSelectedTaskDescription() {
        return (String) taskTable.getValueAt(taskTable.getSelectedRow(), 2);
    }

    public static String getSelectedTaskPriority() {
        return (String) taskTable.getValueAt(taskTable.getSelectedRow(), 3);
    }

    public static void setLastSearchingValue(String lastSearchingValue) {
        TaskTable.lastSearchingValue = lastSearchingValue;
    }

    public static void setNameOfLastSearchingMethod(String nameOfLastSearchingMethod) {
        TaskTable.nameOfLastSearchingMethod = nameOfLastSearchingMethod;
    }

    public JScrollPane getTaskTableScrollPane() {
        return taskTableScrollPane;
    }
}


