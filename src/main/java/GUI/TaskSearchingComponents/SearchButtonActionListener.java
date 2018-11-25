package GUI.TaskSearchingComponents;

import GUI.TaskTableObject.TaskTable;
import GUI.TextFieldsObject.TextField;
import TaskManagement.TasksSearcher;

import java.awt.event.ActionListener;
import java.sql.SQLException;

class SearchButtonActionListener {
    private TasksSearcher tasksSearcher = new TasksSearcher();
    private TaskTable taskTable = new TaskTable();
    private ActionListener searchButtonActionListener = e -> {
        try {
            tasksSearcher.searchTasksByPriority(TextField.getSerchByPriorityTextField().getText().toUpperCase());
            taskTable.refreshTable();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    };

    ActionListener getSearchButtonActionListener() {
        return searchButtonActionListener;
    }
}
