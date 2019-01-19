package GUI.TaskModifyingComponents;

import GUI.GUIComponents.GUICalendar;
import GUI.GUIComponents.TaskDescriptionTextArea;
import GUI.TaskModifyingComponents.SecondFrameComponents.*;
import GUI.TaskTableObject.TaskTable;
import TaskObject.Status;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class UpdateButton {
    private static JButton updateButton = new JButton("Update");
    private GUICalendar guiCalendar = ModifyingComponents.getGuiCalendar();
    private TaskDescriptionTextArea taskDescriptionTextArea = ModifyingComponents.getTaskDescriptionTextArea();
    private Frame secondFrame;

    {
        try {
            secondFrame = new Frame();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private PrioritySelector prioritySelector = new PrioritySelector();

    {
        if(updateButton.getActionListeners().length == 0) {
            ActionListener modifyButtonActionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    guiCalendar.nullifyCalendar();
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
        taskDescriptionTextArea.setText(TaskTable.getSelectedTaskDescription());
    }

    private void setDateToCalendar() {
        guiCalendar.setDate(Date.valueOf(TaskTable.getSelectedTaskStartDate()));
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
