package GUI.TaskTableObject;

import GUI.TaskDeletingComponents.DeleteButton;
import GUI.TaskUpdatingComponents.UpdateButton;
import Database.TaskManagement.TasksSearcher;
import TaskObject.Status;

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
    private static int updatingTaskID = 0;
    private TasksSearcher tasksSearcher = new TasksSearcher();
    private DeleteButton deleteButton = new DeleteButton();
    private UpdateButton updateButton = new UpdateButton();

    public TaskTable() throws SQLException {
        taskTableScrollPane.setPreferredSize(new Dimension(455, 300));
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
        doLastSearch();
        taskTable.setModel(new TaskTableModel());
        setCellsSize();
        disableColumnResizing();
        taskTable.getColumnModel().getColumn(2).setCellRenderer(new DescriptionColumnRenderer());
        taskTable.setDefaultRenderer(Object.class, new PriorityColumnRenderer());
        taskTable.getColumnModel().getColumn(4).setCellRenderer(new ColorStatusRenderer());
        if(taskTable.isShowing())
            refreshSelection();
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

    private void setCellsSize() {
        TableColumnModel columnModel = taskTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(23);
        columnModel.getColumn(1).setPreferredWidth(75);
        columnModel.getColumn(2).setPreferredWidth(199);
        columnModel.getColumn(3).setPreferredWidth(38);
        columnModel.getColumn(4).setPreferredWidth(90);
    }

    private void refreshSelection() {
        int comparingID;
        for(int i = 0; i < taskTable.getRowCount(); i++) {
            comparingID = Integer.parseInt(taskTable.getValueAt(i, 0).toString());
            if (comparingID == updatingTaskID) {
                taskTable.setRowSelectionInterval(i, i);
            }
        }
    }

    private void disableColumnResizing() {
        for (int i = 0; i < taskTable.getColumnCount(); i++)
            taskTable.getColumnModel().getColumn(i).setResizable(false);
    }

    public static void setLastSearchingValue(String lastSearchingValue) {
        TaskTable.lastSearchingValue = lastSearchingValue;
    }

    public static void setNameOfLastSearchingMethod(String nameOfLastSearchingMethod) {
        TaskTable.nameOfLastSearchingMethod = nameOfLastSearchingMethod;
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

    public static String getSelectedTaskStatus() {
        Status status = (Status) taskTable.getValueAt(taskTable.getSelectedRow(), 4);
        return status.name();
    }

    public static void setUpdatingTaskID(int id) {
        updatingTaskID = id;
    }

    public JScrollPane getTaskTableScrollPane() {
        return taskTableScrollPane;
    }
}


