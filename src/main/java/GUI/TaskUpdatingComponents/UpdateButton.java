package GUI.TaskUpdatingComponents;

import GUI.MainFrame.Frame;
import GUI.MainValueReaders.*;
import GUI.TaskUpdatingComponents.SecondFrameComponents.*;
import GUI.TaskTableObject.TaskTable;
import TaskObject.Status;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class UpdateButton {
    private static JButton updateButton = new JButton("Update");
    private GUICalendar guiCalendar = MainUpdatingComponents.getGuiCalendar();
    private DescriptionTextArea descriptionTextArea = MainUpdatingComponents.getDescriptionTextArea();
    private PriorityComboBox priorityComboBox = MainUpdatingComponents.getPriorityComboBox();
    private static SecondFrame secondFrame = MainUpdatingComponents.getSecondFrame();
    private StatusUpdater statusUpdater = MainUpdatingComponents.getStatusUpdater();

    {
        if(updateButton.getActionListeners().length == 0) {
            ActionListener modifyButtonActionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Frame.setEnabled(false);
                    TaskTable.setUpdatingTaskID(Integer.parseInt(TaskTable.getSelectedTaskID()));
                    guiCalendar.nullifyCalendar();
                    secondFrame.setVisible(true);
                    setTextToDescriptionTextArea();
                    setDateToCalendar();
                    setPriorityLetterToPrioritySelector();
                    setCheckBoxSelection();
                    statusUpdater.refreshCheckBoxEnabled();
                }
            };
            updateButton.addActionListener(modifyButtonActionListener);
        }
        updateButton.setEnabled(false);
    }

    private void setTextToDescriptionTextArea() {
        descriptionTextArea.setText(TaskTable.getSelectedTaskDescription());
    }

    private void setDateToCalendar() {
        guiCalendar.setDate(Date.valueOf(TaskTable.getSelectedTaskStartDate()));
    }

    private void setPriorityLetterToPrioritySelector() {
        priorityComboBox.setSelectedItem(TaskTable.getSelectedTaskPriority());
    }

    private void setCheckBoxSelection() {
        if(TaskTable.getSelectedTaskStatus().equals(Status.DONE.name()))
            statusUpdater.setSelected(true);
        else
            statusUpdater.setSelected(false);
    }

    public JButton getUpdateButton() {
        return updateButton;
    }
}
