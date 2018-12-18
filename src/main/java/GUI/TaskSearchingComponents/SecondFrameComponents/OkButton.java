package GUI.TaskSearchingComponents.SecondFrameComponents;

import GUI.TaskTableObject.TaskTable;
import TaskManagement.TasksSearcher;
import Utilites.ComboBoxUtils;
import Utilites.DateUtils;

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

    void searchTasks() throws SQLException {
        String usersInput = valueReader.getSearchingValueTextField().getText();
        switch(dataTypeSelector.getGroupOfSelectors().getSelection().getActionCommand()){
            case "today's" : tasksSearcher.searchTasksByDate(String.valueOf(LocalDate.now()));
            TaskTable.setLastSearchingValue(String.valueOf(LocalDate.now()));
            break;
            case "all" : tasksSearcher.searchAllTasks();
            TaskTable.setLastSearchingValue(null);
            break;
            case "id" : tasksSearcher.searchTaskByID(usersInput);
            TaskTable.setLastSearchingValue(usersInput);
            break;
            case "date" :
                if(Calendar.getJxDatePicker().getMonthView().getSelection().size() == 1) {
                    tasksSearcher.searchTasksByDate(DateUtils.getDate(Calendar.getJxDatePicker()));
                    TaskTable.setLastSearchingValue(DateUtils.getDate(Calendar.getJxDatePicker()));
                }
                else {
                    String[] firstAndLastSelectedDays = DateUtils.getRangeOfDates(Calendar.getJxDatePicker());
                    tasksSearcher.searchTasksByRangeOfDate(firstAndLastSelectedDays[0], firstAndLastSelectedDays[1]);
                    TaskTable.setLastSearchingValue(firstAndLastSelectedDays[0] + " " + firstAndLastSelectedDays [1]);
                }
                break;
            case "description" : tasksSearcher.searchTasksByDescription(usersInput);
            TaskTable.setLastSearchingValue(usersInput);
            break;
            case "priority" : tasksSearcher.searchTasksByPriority
                    (ComboBoxUtils.getSelectedPriorityLetter(PrioritySelector.getPrioritySelector()));
            TaskTable.setLastSearchingValue
                    (ComboBoxUtils.getSelectedPriorityLetter(PrioritySelector.getPrioritySelector()));
            break;
        }
        new TaskTable().refreshTable();
    }

    JButton getOkButton() {
        return okButton;
    }
}
