package GUI.TaskModifyingComponents.SecondFrameComponents;

import GUI.MainGUIComponents.ColoredLabel;
import GUI.MainGUIComponents.GUICalendar;
import GUI.MainGUIComponents.TaskDescriptionTextArea;
import GUI.MainGUIComponents.TaskPriorityComboBox;
import GUI.TaskTableObject.TaskTable;
import TaskManagement.TasksUpdater;
import TaskObject.Status;
import Utilites.DataVerifier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class SaveButton {
    private static JButton saveButton = new JButton("Save");
    private TaskDescriptionTextArea taskDescriptionTextArea = MainModifyingComponents.getTaskDescriptionTextArea();
    private GUICalendar guiCalendar = MainModifyingComponents.getGuiCalendar();
    private TaskPriorityComboBox taskPriorityComboBox = MainModifyingComponents.getTaskPriorityComboBox();
    private TasksUpdater tasksUpdater = new TasksUpdater();
    private ColoredLabel resultLabel = MainModifyingComponents.getColoredLabel();
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
            tasksUpdater.updateTaskDescription(selectedTaskIDBeforeSave, taskDescriptionTextArea.getText());
            tasksUpdater.updateTaskPriority(selectedTaskIDBeforeSave, taskPriorityComboBox.getSelectedPriorityLetter());
            if(StatusUpdater.getCheckBoxSelection())
                tasksUpdater.updateTaskStatus(selectedTaskIDBeforeSave, Status.FULFILLED);
            else
                tasksUpdater.updateTaskStatus(selectedTaskIDBeforeSave, Status.IN_PROGRESS);
            resultLabel.setColoredText("Task was updated", Color.GREEN);
        }
    }

    private boolean isCorrectDescription() {
        if(DataVerifier.isEmptyInput(taskDescriptionTextArea.getText())) {
            resultLabel.setColoredText("Description couldn't be empty", Color.red);
            return false;
        }
        else {
            resultLabel.setColoredText("\n", Color.BLACK);
            return true;
        }
    }

    private boolean isCorrectDate() {
        try{
            guiCalendar.getStringDate();
            resultLabel.setColoredText("\n", Color.BLACK);
            return true;
        } catch (NullPointerException e){
            resultLabel.setColoredText("Choose date", Color.red);
            return false;
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
