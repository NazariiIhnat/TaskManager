package GUI.TaskUpdatingComponents.SecondFrameComponents;

import GUI.MainFrame.Frame;
import GUI.MainValueReaders.*;
import GUI.TaskTableObject.TaskTable;
import Database.TaskManagement.TasksUpdater;
import TaskObject.Status;
import Utilites.DataVerifier;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class TaskUpdateSaveActionListener implements ActionListener{
    private DescriptionTextArea descriptionTextArea = MainUpdatingComponents.getDescriptionTextArea();
    private GUICalendar guiCalendar = MainUpdatingComponents.getGuiCalendar();
    private PriorityComboBox priorityComboBox = MainUpdatingComponents.getPriorityComboBox();
    private TasksUpdater tasksUpdater = new TasksUpdater();
    private ColoredLabel resultLabel = MainUpdatingComponents.getColoredLabel();
    private StatusUpdater statusUpdater = MainUpdatingComponents.getStatusUpdater();
    private static TaskTable taskTable;
    private static int selectedTaskIDBeforeSave;
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
            Frame.setEnabled(true);
        }
    }

    private void saveUpdates() throws SQLException {
        selectedTaskIDBeforeSave = Integer.parseInt(TaskTable.getSelectedTaskID());
        if(isCorrectDescription() && isCorrectDate()) {
            tasksUpdater.updateTaskDate(selectedTaskIDBeforeSave, guiCalendar.getStringDate());
            tasksUpdater.updateTaskDescription(selectedTaskIDBeforeSave, descriptionTextArea.getText());
            tasksUpdater.updateTaskPriority(selectedTaskIDBeforeSave, priorityComboBox.getSelectedPriorityLetter());
            if(statusUpdater.isSelected())
                tasksUpdater.updateTaskStatus(selectedTaskIDBeforeSave, Status.DONE);
            else
                tasksUpdater.updateTaskStatus(selectedTaskIDBeforeSave, Status.IN_PROGRESS);
            resultLabel.setColoredText("\n", Color.WHITE);
            MainUpdatingComponents.getSecondFrame().setVisible(false);
        }
    }

    private boolean isCorrectDescription() {
        if(DataVerifier.isEmptyInput(descriptionTextArea.getText())) {
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
                MainUpdatingComponents.getSecondFrame().setVisible(false);
        } catch (IndexOutOfBoundsException e) {
            MainUpdatingComponents.getSecondFrame().setVisible(true);
        }
    }
}

