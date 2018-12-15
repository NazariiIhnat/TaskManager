package GUI.TaskSearchingComponents.SecondFrameComponents;

import GUI.CalendarObject.GUICalendar;
import GUI.PrioritySelectorObject.PrioritySelector;
import GUI.TaskTableObject.TaskTable;
import TaskManagement.TasksSearcher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;

class OkButton {
    private JButton okButton = new JButton("OK");
    private DataTypeSelector dataTypeSelector = new DataTypeSelector();
    private ValueReader valueReader = new ValueReader();
    private TasksSearcher tasksSearcher = new TasksSearcher();
    private GUICalendar calendar = new GUICalendar();
    private PrioritySelector prioritySelector = new PrioritySelector();

    OkButton() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    searchTasks();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void searchTasks() throws SQLException {
        String usersInput = valueReader.getSearchingValueTextField().getText();
        switch(dataTypeSelector.getGroupOfSelectors().getSelection().getActionCommand()){
            case "today's" : tasksSearcher.searchTasksByDate(String.valueOf(LocalDate.now())); break;
            case "all" : tasksSearcher.searchAllTasks(); break;
            case "id" : tasksSearcher.searchTaskByID(usersInput); break;
            case "date" : tasksSearcher.searchTasksByDate(GUICalendar.getDate()); break;
            case "description" : tasksSearcher.searchTasksByDescription(usersInput); break;
            case "priority" : tasksSearcher.searchTasksByPriority(prioritySelector.getSelectedPriorityLetter()); break;
        }
        new TaskTable().refreshTable();
    }

    JButton getOkButton() {
        return okButton;
    }
}
