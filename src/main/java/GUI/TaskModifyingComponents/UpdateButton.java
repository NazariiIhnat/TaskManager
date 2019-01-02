package GUI.TaskModifyingComponents;

import GUI.TaskModifyingComponents.SecondFrameComponents.Calendar;
import GUI.TaskModifyingComponents.SecondFrameComponents.DescriptionTextArea;
import GUI.TaskModifyingComponents.SecondFrameComponents.Frame;
import GUI.TaskModifyingComponents.SecondFrameComponents.PrioritySelector;
import GUI.TaskTableObject.TaskTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class UpdateButton {
    private static JButton updateButton = new JButton("Update");
    private Frame secondFrame = new Frame();
    private DescriptionTextArea descriptionTextArea = new DescriptionTextArea();
    private Calendar calendar = new Calendar();
    private PrioritySelector prioritySelector = new PrioritySelector();

    {
        if(updateButton.getActionListeners().length == 0) {
            ActionListener modifyButtonActionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    secondFrame.getSecondFrame().setVisible(true);
                    setTextToDescriptionTextArea();
                    setDateToCalendar();
                    setPriorityLetterToPrioritySelector();
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

    public JButton getUpdateButton() {
        return updateButton;
    }
}
