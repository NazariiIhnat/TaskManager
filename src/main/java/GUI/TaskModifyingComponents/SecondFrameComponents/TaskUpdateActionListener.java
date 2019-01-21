package GUI.TaskModifyingComponents.SecondFrameComponents;

import GUI.MainGUIComponents.*;
import GUI.TaskTableObject.TaskTable;
import TaskManagement.TasksUpdater;
import TaskObject.Status;
import Utilites.DataVerifier;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class TaskUpdateActionListener implements ActionListener{
    private TaskDescriptionTextArea taskDescriptionTextArea = MainUpdatingComponents.getTaskDescriptionTextArea();
    private GUICalendar guiCalendar = MainUpdatingComponents.getGuiCalendar();
    private TaskPriorityComboBox taskPriorityComboBox = MainUpdatingComponents.getTaskPriorityComboBox();
    private TasksUpdater tasksUpdater = new TasksUpdater();
    private ColoredLabel resultLabel = MainUpdatingComponents.getColoredLabel();
    private StatusUpdater statusUpdater = MainUpdatingComponents.getStatusUpdater();
    private SecondFrame secondFrame = MainUpdatingComponents.getSecondFrame();
    private static TaskTable taskTable;
    private int selectedTaskIDBeforeSave;
    static {
        try {
            taskTable = new TaskTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            saveUpdates();
            taskTable.refreshTable();
            statusUpdater.refreshCheckBoxEnabled();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            closeUpdateFrameIfSelectedAnotherTaskAfterSave();
        }
    }

    private void saveUpdates() throws SQLException {
        selectedTaskIDBeforeSave = Integer.parseInt(TaskTable.getSelectedTaskID());
        if(isCorrectDescription() && isCorrectDate()) {
            tasksUpdater.updateTaskDate(selectedTaskIDBeforeSave, guiCalendar.getStringDate());
            tasksUpdater.updateTaskDescription(selectedTaskIDBeforeSave, taskDescriptionTextArea.getText());
            tasksUpdater.updateTaskPriority(selectedTaskIDBeforeSave, taskPriorityComboBox.getSelectedPriorityLetter());
            if(statusUpdater.isSelected())
                tasksUpdater.updateTaskStatus(selectedTaskIDBeforeSave, Status.DONE);
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
                secondFrame.setVisible(true);
        } catch (IndexOutOfBoundsException e) {
            secondFrame.setVisible(false);
        }
    }

    TaskUpdateActionListener getSaveButtonActionListener() {
        return this;
    }
}
