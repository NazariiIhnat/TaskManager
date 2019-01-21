package GUI.MainGUIComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class ComponentsPanels {
    private JPanel textAreaPanel = new JPanel();
    private JPanel calendarPriorityAndStatusSelectorsPanel = new JPanel();
    private JPanel saveButtonPanel = new JPanel();
    private JPanel labelsPanel = new JPanel();
    private TaskDescriptionTextArea taskDescriptionTextArea;
    private GUICalendar guiCalendar;
    private TaskPriorityComboBox taskPriorityComboBox;
    private JButton button;
    private ColoredLabel resultLabel;
    private StatusUpdater statusUpdater;

    ComponentsPanels(TaskDescriptionTextArea taskDescriptionTextArea, GUICalendar guiCalendar,
                     TaskPriorityComboBox taskPriorityComboBox, String buttonName, ActionListener buttonActionListener,
                     ColoredLabel resultLabel, StatusUpdater statusUpdater){
        this.taskDescriptionTextArea = taskDescriptionTextArea;
        addTextAreaOnPanel();
        this.guiCalendar = guiCalendar;
        addCalendarOnPanel();
        this.taskPriorityComboBox = taskPriorityComboBox;
        addPrioritySelectorOnPanel();
        this.resultLabel = resultLabel;
        button = new JButton(buttonName);
        addSaveButtonOnPanel();
        button.addActionListener(buttonActionListener);
        this.statusUpdater = statusUpdater;
        if(this.statusUpdater != null)
            addStatusUpdaterComboBoxOnPanel();
        addLabelOnPanel();
    }

    private void addTextAreaOnPanel() {
        textAreaPanel.setPreferredSize(new Dimension(300, 110));
        textAreaPanel.setLayout(new BorderLayout());
        textAreaPanel.add(taskDescriptionTextArea.getScrollPane(), BorderLayout.CENTER);
    }

    private void addCalendarOnPanel() {
        calendarPriorityAndStatusSelectorsPanel.setLayout(new GridLayout(1, 3));
        calendarPriorityAndStatusSelectorsPanel.add(guiCalendar);
    }

    private void addPrioritySelectorOnPanel() {
        calendarPriorityAndStatusSelectorsPanel.add(taskPriorityComboBox);
    }

    private void addStatusUpdaterComboBoxOnPanel() {
        calendarPriorityAndStatusSelectorsPanel.add(statusUpdater);
    }

    private void addSaveButtonOnPanel() {
        saveButtonPanel.setLayout(new FlowLayout());
        saveButtonPanel.add(button);
    }

    private void addLabelOnPanel() {
        labelsPanel.setLayout(new GridLayout(1, 1));
        labelsPanel.add(resultLabel);
    }

    JPanel getTextAreaPanel() {
        return textAreaPanel;
    }

    JPanel getCalendarPriorityAndStatusSelectorsPanel() {
        return calendarPriorityAndStatusSelectorsPanel;
    }

    JPanel getSaveButtonPanel() {
        return saveButtonPanel;
    }

    JPanel getLabelsPanel() {
        return labelsPanel;
    }
}
