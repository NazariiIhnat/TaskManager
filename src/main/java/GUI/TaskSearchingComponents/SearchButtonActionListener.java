package GUI.TaskSearchingComponents;

import GUI.TaskTableObject.TaskTable;
import TaskManagement.TasksSearcher;

import java.awt.event.ActionListener;
import java.sql.SQLException;

class SearchButtonActionListener {
    private TasksSearcher tasksSearcher = new TasksSearcher();
    private ActionListener searchButtonActionListener = e -> {
        try {
            tasksSearcher.searchTasksByPriority(TaskSearchTextField.getSearchByPriorityTextField().getText().toUpperCase());
            new TaskTable().refreshTable();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    };

    ActionListener getSearchButtonActionListener() {
        return searchButtonActionListener;
    }
}
