package GUI.TaskModifyingComponents.SecondFrameComponents;

import GUI.MainGUIComponents.GUICalendar;
import GUI.MainGUIComponents.TaskDescriptionTextArea;

import javax.swing.*;
import java.awt.*;

class ComponentsPanels {
    private static JPanel textAreaPanel = new JPanel();
    private static JPanel calendarAndPrioritySelectorPanel = new JPanel();
    private static JPanel saveButtonPanel = new JPanel();
    private static JPanel labelsPanel = new JPanel();
    private TaskDescriptionTextArea taskDescriptionTextArea = ModifyingComponents.getTaskDescriptionTextArea();
    private GUICalendar guiCalendar = ModifyingComponents.getGuiCalendar();
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
        textAreaPanel.add(taskDescriptionTextArea.getScrollPane(), BorderLayout.CENTER);
    }

    private void addCalendarOnPanel() {
        calendarAndPrioritySelectorPanel.setLayout(new GridLayout(1, 3));
        calendarAndPrioritySelectorPanel.add(guiCalendar);
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
