package GUI.TaskModifyingComponents.SecondFrameComponents;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

class ComponentsPanels {
    private static JPanel textAreaPanel = new JPanel();
    private static JPanel calendarAndPrioritySelectorPanel = new JPanel();
    private static JPanel saveButtonPanel = new JPanel();
    private static JPanel labelsPanel = new JPanel();
    private DescriptionTextArea descriptionTextArea = new DescriptionTextArea();
    private Calendar calendar = new Calendar();
    private PrioritySelector prioritySelector = new PrioritySelector();
    private SaveButton saveButton = new SaveButton();
    private ResultLabel label = new ResultLabel();

    ComponentsPanels(){
        addTextAreaOnPanel();
        addCalendarOnPanel();
        addPrioritySelectorOnPanel();
        addCheckBoxOnPanel();
        addSaveButtonOnPanel();
        addLabelOnPanel();
    }

    private void addTextAreaOnPanel() {
        textAreaPanel.setPreferredSize(new Dimension(300, 110));
        textAreaPanel.setLayout(new BorderLayout());
        textAreaPanel.add(descriptionTextArea.getDescriptionTextAreaScrollPane(), BorderLayout.CENTER);
    }

    private void addCalendarOnPanel() {
        calendarAndPrioritySelectorPanel.setLayout(new GridLayout(1, 3));
        calendarAndPrioritySelectorPanel.add(calendar.getCalendar());
    }

    private void addPrioritySelectorOnPanel() {
        calendarAndPrioritySelectorPanel.add(prioritySelector.getPrioritySelectorComboBox());
    }

    private void addCheckBoxOnPanel() {
        calendarAndPrioritySelectorPanel.add(StatusUpdater.getCheckBox());
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
