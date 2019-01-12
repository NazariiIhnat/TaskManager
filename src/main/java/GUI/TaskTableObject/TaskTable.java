package GUI.TaskTableObject;

import GUI.TaskDeletingComponents.DeleteButton;
import GUI.TaskModifyingComponents.UpdateButton;
import TaskManagement.TasksSearcher;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.SQLException;

public class TaskTable {
    private static JTable taskTable = new JTable();
    private static String lastSearchingValue = null;
    private static String nameOfLastSearchingMethod = "all";
    private static JScrollPane taskTableScrollPane = new JScrollPane(taskTable);
    private TasksSearcher tasksSearcher = new TasksSearcher();
    private DeleteButton deleteButton = new DeleteButton();
    private UpdateButton updateButton = new UpdateButton();

    public TaskTable() throws SQLException {
        taskTableScrollPane.setPreferredSize(new Dimension(350, 300));
        taskTable.getTableHeader().setReorderingAllowed(false);
        taskTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        disableModifyAndDeleteButtonsWhenTaskIsNotSelected();
        refreshTable();
    }

    private void disableModifyAndDeleteButtonsWhenTaskIsNotSelected() {
        taskTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(taskTable.getSelectedRow() > -1) {
                    updateButton.getUpdateButton().setEnabled(true);
                    deleteButton.getDeleteButton().setEnabled(true);
                } else {
                    updateButton.getUpdateButton().setEnabled(false);
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
        setCellsSize();
        disableColumnResizing();
        taskTable.getColumnModel().getColumn(2).setCellRenderer(new DescriptionColumnRenderer());
        taskTable.setDefaultRenderer(Object.class, new PriorityColumnRenderer());
        taskTable.getColumnModel().getColumn(4).setCellRenderer(new ColorRenderer());
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

    private void setCellsSize() {
        TableColumnModel columnModel = taskTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(33);
        columnModel.getColumn(1).setPreferredWidth(75);
        columnModel.getColumn(2).setPreferredWidth(187);
        columnModel.getColumn(3).setPreferredWidth(40);
    }

    private void disableColumnResizing() {
        for (int i = 0; i < taskTable.getColumnCount(); i++)
            taskTable.getColumnModel().getColumn(i).setResizable(false);
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


