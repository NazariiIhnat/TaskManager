package GUI.TaskSearchingComponents.SecondFrameComponents;

import GUI.MainValueReaders.GUICalendar;
import GUI.MainValueReaders.PriorityComboBox;
import GUI.TaskTableObject.TaskTable;
import Database.TaskManagement.TasksSearcher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;

class OkButton {
    private JButton okButton = new JButton("OK");
    private DataTypeSelector dataTypeSelector = new DataTypeSelector();
    private DescriptionAndIDReader descriptionAndIDReader = new DescriptionAndIDReader();
    private TasksSearcher tasksSearcher = new TasksSearcher();
    private GUICalendar guiCalendar = MainSearchingComponents.getGUICalendar();
    private PriorityComboBox priorityComboBox = MainSearchingComponents.getPriorityComboBox();

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
        String usersInput = descriptionAndIDReader.getSearchingValueTextField().getText();
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
                if(guiCalendar.getStringDate() != null) {
                    if (guiCalendar.getMonthView().getSelection().size() == 1) {
                        tasksSearcher.searchTasksByDate(guiCalendar.getStringDate());
                        TaskTable.setLastSearchingValue(guiCalendar.getStringDate());
                    } else {
                        String[] firstAndLastSelectedDays = guiCalendar.getRangeOfDates();
                        tasksSearcher.searchTasksByRangeOfDate(firstAndLastSelectedDays[0], firstAndLastSelectedDays[1]);
                        TaskTable.setLastSearchingValue(firstAndLastSelectedDays[0] + " " + firstAndLastSelectedDays[1]);
                    }
                }
                break;
            case "description" : tasksSearcher.searchTasksByDescription(usersInput);
            TaskTable.setLastSearchingValue(usersInput);
            break;
            case "priority" : tasksSearcher.searchTasksByPriority
                    (priorityComboBox.getSelectedPriorityLetter());
            TaskTable.setLastSearchingValue
                    (priorityComboBox.getSelectedPriorityLetter());
            break;
        }
        new TaskTable().refreshTable();
    }

    JButton getOkButton() {
        return okButton;
    }
}
