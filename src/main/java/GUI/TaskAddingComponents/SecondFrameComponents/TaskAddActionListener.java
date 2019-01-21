package GUI.TaskAddingComponents.SecondFrameComponents;

import GUI.MainGUIComponents.ColoredLabel;
import GUI.MainGUIComponents.GUICalendar;
import GUI.MainGUIComponents.TaskDescriptionTextArea;
import GUI.MainGUIComponents.TaskPriorityComboBox;
import GUI.TaskTableObject.TaskTable;
import TaskObject.Task;
import Utilites.DataVerifier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
class TaskAddActionListener implements ActionListener{
    private TaskDescriptionTextArea taskDescriptionTextArea = MainAddingComponents.getTaskDescriptionTextArea();
    private GUICalendar guiCalendar = MainAddingComponents.getGuiCalendar();
    private ColoredLabel resultLabel = MainAddingComponents.getColoredLabel();
    private TaskPriorityComboBox priorityComboBox = MainAddingComponents.getTaskPriorityComboBox();
    private String usersDate = null;
    private String usersDescription = null;

    @Override
    public void actionPerformed(ActionEvent e) {
        resultLabel.nullifyColoredLabel();
        if(isSelectedDate() && !isEmptyDescription()) {
            try {
                new Task(usersDate, usersDescription, priorityComboBox.getSelectedPriorityLetter());
                resultLabel.setColoredText("Task was successfully added", Color.green);
                new TaskTable().refreshTable();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    private boolean isSelectedDate() {
        try {
            usersDate = guiCalendar.getStringDate();
        } catch (NullPointerException e) {
            resultLabel.setColoredText("Date hasn't been selected", Color.red);
            return false;
        } return true;
    }

    private boolean isEmptyDescription(){
        usersDescription = taskDescriptionTextArea.getText();
        if(DataVerifier.isEmptyInput(usersDescription)) {
            resultLabel.setColoredText("Description couldn't be empty", Color.red);
            return true;
        } else return false;
    }
}
