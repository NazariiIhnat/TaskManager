package GUI.TaskModifyingComponents.SecondFrameComponents;

import GUI.TaskTableObject.TaskTable;
import TaskManagement.TasksUpdater;
import Utilites.ComboBoxUtils;
import Utilites.DataVerifier;
import Utilites.DateUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class SaveButton {
    private static JButton saveButton = new JButton("Save");
    private DescriptionTextArea descriptionTextArea = new DescriptionTextArea();
    private Calendar calendar = new Calendar();
    private PrioritySelector prioritySelector = new PrioritySelector();
    private TasksUpdater tasksUpdater = new TasksUpdater();
    private static TaskTable taskTable;

    static {
        try {
            taskTable = new TaskTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    SaveButton() {
        if (saveButton.getActionListeners().length == 0)
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (isCorrectDescription() && isCorrectDate()) {
                        int id = Integer.parseInt(TaskTable.getSelectedTaskID());
                        try {
                            tasksUpdater.updateTaskDate(id, DateUtils.getDate(calendar.getCalendar()));
                            tasksUpdater.updateTaskDescription(id, descriptionTextArea.getDescriptionTextArea().getText());
                            tasksUpdater.updateTaskPriority(id,
                                    ComboBoxUtils.getSelectedPriorityLetter(prioritySelector.getPrioritySelectorComboBox()));
                            taskTable.refreshTable();
                            ResultLabel.setColorMessage("Updates successfully saved", Color.green);
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }

                    }
                }
            });
    }

    private boolean isCorrectDescription() {
        if(DataVerifier.isEmptyInput(descriptionTextArea.getDescriptionTextArea().getText())) {
            ResultLabel.setColorMessage("Description couldn't be empty", Color.red);
            return false;
        }
        else {
            ResultLabel.setColorMessage(null, Color.BLACK);
            return true;
        }
    }

    private boolean isCorrectDate() {
        if(DataVerifier.isEmptyInput(calendar.getCalendar().getEditor().getText())){
            ResultLabel.setColorMessage("Choose date", Color.red);
            return false;
        } else {
            ResultLabel.setColorMessage(null, Color.BLACK);
            return true;
        }
    }

    JButton getSaveButton() {
        return saveButton;
    }
}
