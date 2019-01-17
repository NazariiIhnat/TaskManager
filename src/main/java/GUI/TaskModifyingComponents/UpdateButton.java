package GUI.TaskModifyingComponents;

import GUI.TaskModifyingComponents.SecondFrameComponents.*;
import GUI.TaskTableObject.TaskTable;
import TaskObject.Status;
import Utilites.DateUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class UpdateButton {
    private static JButton updateButton = new JButton("Update");
    private Frame secondFrame;

    {
        try {
            secondFrame = new Frame();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DescriptionTextArea descriptionTextArea = new DescriptionTextArea();
    private Calendar calendar = new Calendar();
    private PrioritySelector prioritySelector = new PrioritySelector();

    {
        if(updateButton.getActionListeners().length == 0) {
            ActionListener modifyButtonActionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DateUtils.nullifyCalendar(calendar.getCalendar());
                    Frame.setFrameVisible(true);
                    setTextToDescriptionTextArea();
                    setDateToCalendar();
                    setPriorityLetterToPrioritySelector();
                    setCheckBoxSelection();
                    StatusUpdater.refreshCheckBoxEnabled();
                }
            };
            updateButton.addActionListener(modifyButtonActionListener);
        }
        updateButton.setEnabled(false);
    }

    private void setTextToDescriptionTextArea() {
        descriptionTextArea.getDescriptionTextArea().setText(TaskTable.getSelectedTaskDescription());
    }

    private void setDateToCalendar() {
        calendar.getCalendar().setDate(Date.valueOf(TaskTable.getSelectedTaskStartDate()));
    }

    private void setPriorityLetterToPrioritySelector() {
        prioritySelector.getPrioritySelectorComboBox().setSelectedItem(TaskTable.getSelectedTaskPriority());
    }

    private void setCheckBoxSelection() {
        if(TaskTable.getSelectedTaskStatus().equals(Status.FULFILLED.name()))
            StatusUpdater.setCheckBoxValue(true);
        else
            StatusUpdater.setCheckBoxValue(false);
    }

    public JButton getUpdateButton() {
        return updateButton;
    }
}
