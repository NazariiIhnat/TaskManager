package GUI.TaskTableObject;

import javax.swing.*;

public class TaskTable {
    private static JTable taskTable = new JTable();
    private static JScrollPane taskTableScrollPane = new JScrollPane(taskTable);

    public TaskTable(){
        taskTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void refreshTable() {
        taskTable.setModel(new TaskTableModel());
    }

    public JScrollPane getTaskTableScrollPane() {
        return taskTableScrollPane;
    }
}
