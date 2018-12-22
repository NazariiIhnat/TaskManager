package GUI.TaskModifyingComponents.SecondFrameComponents;

import GUI.TaskTableObject.TaskTable;
import TaskManagement.TasksUpdater;
import Utilites.ComboBoxUtils;
import Utilites.DateUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SaveButton {
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

    public SaveButton() {
        if (saveButton.getActionListeners().length == 0)
            saveButton.addActionListener(new ActionListener() {
                @Override
                public synchronized void actionPerformed(ActionEvent e) {
                    int id = Integer.parseInt(TaskTable.getSelectedTaskID());
                    try {
                        tasksUpdater.updateTaskDate(id, DateUtils.getDate(calendar.getCalendar()));
                        tasksUpdater.updateTaskDescription(id, descriptionTextArea.getDescriptionTextArea().getText());
                        tasksUpdater.updateTaskPriority(id,
                                ComboBoxUtils.getSelectedPriorityLetter(prioritySelector.getPrioritySelectorComboBox()));
                        taskTable.refreshTable();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                }
            });
    }

    public JButton getSaveButton() {
        return saveButton;
    }
}
