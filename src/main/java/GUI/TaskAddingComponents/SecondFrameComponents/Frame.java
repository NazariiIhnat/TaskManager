package GUI.TaskAddingComponents.SecondFrameComponents;

import GUI.MainGUIComponents.GUICalendar;
import GUI.MainGUIComponents.TaskDescriptionTextArea;
import GUI.MainGUIComponents.TaskPriorityComboBox;

import javax.swing.*;
import java.awt.*;
public class Frame {
    private GUICalendar guiCalendar = AddingComponents.getGuiCalendar();
    private TaskDescriptionTextArea taskDescriptionTextArea = AddingComponents.getTaskDescriptionTextArea();
    private TaskPriorityComboBox taskPriorityComboBox = AddingComponents.getTaskPriorityComboBox();
    private JFrame secondFrame = new JFrame("Add");
    private JPanel componentsPanel = new JPanel();
    private OkButton okButton = new OkButton();
    private Labels labels = new Labels();

    public Frame() {
        componentsPanel.setLayout(new GridBagLayout());
        secondFrame.add(componentsPanel);
        secondFrame.setPreferredSize(new Dimension(260, 175));
        addLabelsOnPanel();
        addPrioritySelectorOnPanel();
        addTextAreaOnPanel();
        addCalendarOnPanel();
        addOkButtonOnPanel();
        secondFrame.pack();
    }

    private void addLabelsOnPanel() {
        componentsPanel.add(labels.getDateLabel(), new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        componentsPanel.add(labels.getDescriptionLabel(), new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        componentsPanel.add(labels.getPriorityLabel(), new GridBagConstraints(0, 2, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        componentsPanel.add(labels.getTaskAddResultLabel(), new GridBagConstraints(0, 4, 3, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(1, 1, 1, 1), 0, 0));
    }

    private void addPrioritySelectorOnPanel() {
        taskPriorityComboBox.setEnabled(true);
        componentsPanel.add(taskPriorityComboBox, new GridBagConstraints(1, 2, 2, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
    }

    private void addTextAreaOnPanel() {
        componentsPanel.add(taskDescriptionTextArea.getScrollPane(), new GridBagConstraints(1, 1, 2, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
    }

    private void addCalendarOnPanel() {
        componentsPanel.add(guiCalendar, new GridBagConstraints(1, 0, 2, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
    }

    private void addOkButtonOnPanel() {
        componentsPanel.add(okButton.getOkButton(), new GridBagConstraints(0, 3, 3, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(1, 1, 1, 1), 0, 0));
    }

    public JFrame getSecondFrame() {
        return secondFrame;
    }
}
