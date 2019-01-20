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
class OkButton {
    private JButton okButton = new JButton("OK");
    private TaskDescriptionTextArea taskDescriptionTextArea = MainAddingComponents.getTaskDescriptionTextArea();
    private GUICalendar guiCalendar = MainAddingComponents.getGuiCalendar();
    private TaskPriorityComboBox taskPriorityComboBox = MainAddingComponents.getTaskPriorityComboBox();
    private ColoredLabel resultLabel = MainAddingComponents.getColoredLabel();
    private String usersDate = null;
    private String usersDescription = null;
    private String usersPriority = null;

    OkButton() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.nullifyColoredLabel();
                if(isSelectedDate() && !isEmptyDescription()) {
                    try {
                        new Task(usersDate, usersDescription, usersPriority);
                        resultLabel.setColoredText("Task was successfully added", Color.green);
                        new TaskTable().refreshTable();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
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

    JButton getOkButton() {
        return okButton;
    }
}
