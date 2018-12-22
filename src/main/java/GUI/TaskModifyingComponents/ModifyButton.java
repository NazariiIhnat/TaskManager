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

public class ModifyButton {
    private JButton modifyButton = new JButton("Update");
    private Frame secondFrame = new Frame();
    private DescriptionTextArea descriptionTextArea = new DescriptionTextArea();
    private Calendar calendar = new Calendar();
    private PrioritySelector prioritySelector = new PrioritySelector();

    public ModifyButton() {
        ActionListener modifyButtonActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondFrame.getSecondFrame().setVisible(true);
                setTextToDescriptionTextArea();
                setDateToCalendar();
                setPriorityLetterToPrioritySelector();
            }
        };
        modifyButton.addActionListener(modifyButtonActionListener);
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

    public JButton getModifyButton() {
        return modifyButton;
    }
}
