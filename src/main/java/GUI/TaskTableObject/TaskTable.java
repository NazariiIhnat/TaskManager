package GUI.TaskTableObject;

import TaskManagement.TasksSearcher;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class TaskTable {
    private static JTable taskTable = new JTable();
    private static JScrollPane taskTableScrollPane = new JScrollPane(taskTable);

    public TaskTable() throws SQLException {
        taskTable.setSize(new Dimension(100, 400));
        refreshTable();
    }

    public void refreshTable() throws SQLException {
        taskTable.setModel(new TaskTableModel());
    }

    public JScrollPane getTaskTableScrollPane() {
        return taskTableScrollPane;
    }
}
