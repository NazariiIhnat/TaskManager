package GUI.TaskAddingComponents.SecondFrameComponents;

import GUI.GUIComponents.GUICalendar;
import GUI.TaskTableObject.TaskTable;
import TaskObject.Task;
import Utilites.ComboBoxUtils;
import Utilites.DataVerifier;
import Utilites.DateUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
class OkButton {
    private JButton okButton = new JButton("OK");
    private DescriptionTextArea descriptionTextArea = new DescriptionTextArea();
    private GUICalendar guiCalendar = AddingComponents.getGuiCalendar();
    private Labels labels = new Labels();
    private String usersDate = null;
    private String usersDescription = null;
    private String usersPriority = null;

    OkButton() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labels.getTaskAddResultLabel().setText(null);
                if(isSelectedDate() && !isEmptyDescription() && isSelectedPriority()) {
                    try {
                        new Task(usersDate, usersDescription, usersPriority);
                        labels.getTaskAddResultLabel().setForeground(Color.green);
                        labels.getTaskAddResultLabel().setText("Task was successfully added");
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
            labels.getTaskAddResultLabel().setForeground(Color.red);
            labels.getTaskAddResultLabel().setText("Date hasn't been selected. ");
            return false;
        } return true;
    }

    private boolean isEmptyDescription(){
        usersDescription = descriptionTextArea.getDescriptionTextArea().getText();
        if(DataVerifier.isEmptyInput(usersDescription)) {
            labels.getTaskAddResultLabel().setForeground(Color.red);
            labels.getTaskAddResultLabel().setText("Description couldn't be empty. ");
            return true;
        } else return false;
    }

    private boolean isSelectedPriority() {
        try{
            usersPriority = ComboBoxUtils.getSelectedPriorityLetter(PrioritySelector.getPrioritySelector());
            return true;
        } catch (NullPointerException e) {
            System.out.println(usersPriority);
            labels.getTaskAddResultLabel().setForeground(Color.red);
            labels.getTaskAddResultLabel().setText("Chose priority letter");
            return false;
        }
    }

    JButton getOkButton() {
        return okButton;
    }
}
