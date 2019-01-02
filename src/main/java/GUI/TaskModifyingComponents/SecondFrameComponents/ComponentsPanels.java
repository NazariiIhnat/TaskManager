package GUI.TaskModifyingComponents.SecondFrameComponents;

import javax.swing.*;
import java.awt.*;

class ComponentsPanels {
    private DescriptionTextArea descriptionTextArea = new DescriptionTextArea();
    private Calendar calendar = new Calendar();
    private PrioritySelector prioritySelector = new PrioritySelector();
    private SaveButton saveButton = new SaveButton();
    private ResultLabel label = new ResultLabel();
    private static JPanel textAreaPanel = new JPanel();
    private static JPanel calendarAndPrioritySelectorPanel = new JPanel();
    private static JPanel saveButtonPanel = new JPanel();
    private static JPanel labelsPanel = new JPanel();

    ComponentsPanels() {
        addTextAreaOnPanel();
        addCalendarOnPanel();
        addPrioritySelectorOnPanel();
        addSaveButtonOnPanel();
        addLabelOnPanel();
    }

    private void addTextAreaOnPanel() {
        textAreaPanel.setPreferredSize(new Dimension(300, 110));
        textAreaPanel.setLayout(new BorderLayout());
        textAreaPanel.add(descriptionTextArea.getDescriptionTextAreaScrollPane(), BorderLayout.CENTER);
    }

    private void addCalendarOnPanel() {
        calendarAndPrioritySelectorPanel.setLayout(new GridLayout(1, 2));
        calendarAndPrioritySelectorPanel.add(calendar.getCalendar());
    }

    private void addPrioritySelectorOnPanel() {
        calendarAndPrioritySelectorPanel.add(prioritySelector.getPrioritySelectorComboBox());
    }

    private void addSaveButtonOnPanel() {
        saveButtonPanel.setLayout(new FlowLayout());
        saveButtonPanel.add(saveButton.getSaveButton());
    }

    private void addLabelOnPanel() {
        labelsPanel.setLayout(new GridLayout(1, 1));
        labelsPanel.add(label.getLabel());
    }

    JPanel getTextAreaPanel() {
        return textAreaPanel;
    }

    JPanel getCalendarAndPrioritySelectorPanel() {
        return calendarAndPrioritySelectorPanel;
    }

    JPanel getSaveButtonPanel() {
        return saveButtonPanel;
    }

    JPanel getLabelsPanel() {
        return labelsPanel;
    }
}
