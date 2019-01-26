package GUI.MainValueReaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class ComponentsPanels {
    private JPanel textAreaPanel = new JPanel();
    private JPanel calendarPriorityAndStatusSelectorsPanel = new JPanel();
    private JPanel saveButtonPanel = new JPanel();
    private JPanel labelsPanel = new JPanel();
    private DescriptionTextArea descriptionTextArea;
    private GUICalendar guiCalendar;
    private PriorityComboBox priorityComboBox;
    private JButton button;
    private ColoredLabel resultLabel;
    private StatusUpdater statusUpdater;

    ComponentsPanels(DescriptionTextArea descriptionTextArea, GUICalendar guiCalendar,
                     PriorityComboBox priorityComboBox, String buttonName, ActionListener buttonActionListener,
                     ColoredLabel resultLabel, StatusUpdater statusUpdater){
        this.descriptionTextArea = descriptionTextArea;
        addTextAreaOnPanel();
        this.guiCalendar = guiCalendar;
        addCalendarOnPanel();
        this.priorityComboBox = priorityComboBox;
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
        textAreaPanel.add(descriptionTextArea.getScrollPane(), BorderLayout.CENTER);
    }

    private void addCalendarOnPanel() {
        calendarPriorityAndStatusSelectorsPanel.setLayout(new GridLayout(1, 3));
        calendarPriorityAndStatusSelectorsPanel.add(guiCalendar);
    }

    private void addPrioritySelectorOnPanel() {
        calendarPriorityAndStatusSelectorsPanel.add(priorityComboBox);
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
