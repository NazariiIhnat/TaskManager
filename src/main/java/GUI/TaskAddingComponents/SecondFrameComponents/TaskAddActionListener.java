package GUI.TaskAddingComponents.SecondFrameComponents;

import GUI.MainValueReaders.ColoredLabel;
import GUI.MainValueReaders.GUICalendar;
import GUI.MainValueReaders.DescriptionTextArea;
import GUI.MainValueReaders.PriorityComboBox;
import GUI.TaskTableObject.TaskTable;
import TaskObject.Task;
import Utilites.DataVerifier;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
class TaskAddActionListener implements ActionListener{
    private DescriptionTextArea descriptionTextArea = MainAddingComponents.getDescriptionTextArea();
    private GUICalendar guiCalendar = MainAddingComponents.getGuiCalendar();
    private ColoredLabel resultLabel = MainAddingComponents.getColoredLabel();
    private PriorityComboBox priorityComboBox = MainAddingComponents.getPriorityComboBox();
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
        usersDescription = descriptionTextArea.getText();
        if(DataVerifier.isEmptyInput(usersDescription)) {
            resultLabel.setColoredText("Description couldn't be empty", Color.red);
            return true;
        } else return false;
    }
}
