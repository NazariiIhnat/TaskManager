package GUI.TaskModifyingComponents.SecondFrameComponents;

import GUI.GUIComponents.GUICalendar;
import GUI.TaskTableObject.TaskTable;
import TaskManagement.TasksUpdater;
import TaskObject.Status;
import Utilites.ComboBoxUtils;
import Utilites.DataVerifier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class SaveButton {
    private static JButton saveButton = new JButton("Save");
    private DescriptionTextArea descriptionTextArea = new DescriptionTextArea();
    private GUICalendar guiCalendar = ModifyingComponents.getGuiCalendar();
    private PrioritySelector prioritySelector = new PrioritySelector();
    private TasksUpdater tasksUpdater = new TasksUpdater();
    private static TaskTable taskTable;
    private int selectedTaskIDBeforeSave;

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
                    try {
                        saveUpdates();
                        taskTable.refreshTable();
                        StatusUpdater.refreshCheckBoxEnabled();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } finally {
                        closeUpdateFrameIfSelectedAnotherTaskAfterSave();
                    }
                }
            });
    }

    private void saveUpdates() throws SQLException {
        selectedTaskIDBeforeSave = Integer.parseInt(TaskTable.getSelectedTaskID());
        if(isCorrectDescription() && isCorrectDate()) {
            tasksUpdater.updateTaskDate(selectedTaskIDBeforeSave, guiCalendar.getStringDate());
            tasksUpdater.updateTaskDescription(selectedTaskIDBeforeSave, descriptionTextArea.getDescriptionTextArea().getText());
            tasksUpdater.updateTaskPriority(selectedTaskIDBeforeSave,
                    ComboBoxUtils.getSelectedPriorityLetter(prioritySelector.getPrioritySelectorComboBox()));
            if(StatusUpdater.getCheckBoxSelection())
                tasksUpdater.updateTaskStatus(selectedTaskIDBeforeSave, Status.FULFILLED);
            else
                tasksUpdater.updateTaskStatus(selectedTaskIDBeforeSave, Status.IN_PROGRESS);
        }
    }

    private boolean isCorrectDescription() {
        if(DataVerifier.isEmptyInput(descriptionTextArea.getDescriptionTextArea().getText())) {
            ResultLabel.setMessage("Description couldn't be empty", Color.red);
            return false;
        }
        else {
            ResultLabel.setMessage(null, Color.BLACK);
            return true;
        }
    }

    private boolean isCorrectDate() {
        if(DataVerifier.isEmptyInput(guiCalendar.getStringDate())){
            ResultLabel.setMessage("Choose date", Color.red);
            return false;
        } else {
            ResultLabel.setMessage(null, Color.BLACK);
            return true;
        }
    }

    private void closeUpdateFrameIfSelectedAnotherTaskAfterSave() {
        try{
            int selectedTaskIdAfterSave = Integer.parseInt(TaskTable.getSelectedTaskID());
            if(selectedTaskIDBeforeSave != selectedTaskIdAfterSave)
                Frame.setFrameVisible(false);
        } catch (IndexOutOfBoundsException e) {
            Frame.setFrameVisible(false);
        }
    }

    JButton getSaveButton() {
        return saveButton;
    }
}
