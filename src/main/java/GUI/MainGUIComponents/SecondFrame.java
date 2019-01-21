package GUI.MainGUIComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SecondFrame extends JFrame{
    private ComponentsPanels componentsPanels;

    public SecondFrame(TaskDescriptionTextArea taskDescriptionTextArea, GUICalendar guiCalendar,
                       TaskPriorityComboBox taskPriorityComboBox, String buttonName, ActionListener buttonActionListener,
                       ColoredLabel resultLabel){
        this(taskDescriptionTextArea, guiCalendar, taskPriorityComboBox, buttonName, buttonActionListener, resultLabel,
                null);
        setFrameParameters();
    }

    public SecondFrame(TaskDescriptionTextArea taskDescriptionTextArea, GUICalendar guiCalendar,
                       TaskPriorityComboBox taskPriorityComboBox, String buttonName, ActionListener buttonActionListener,
                       ColoredLabel resultLabel, StatusUpdater statusUpdater){
        componentsPanels = new ComponentsPanels(taskDescriptionTextArea, guiCalendar, taskPriorityComboBox, buttonName,
                buttonActionListener, resultLabel, statusUpdater);
        setFrameParameters();
    }

    private void setFrameParameters() {
        setLayout(new GridBagLayout());
        setVisible(false);
        addDescriptionTextAreasPanelOnFrame();
        addCalendarAndPrioritySelectorPanelOnFrame();
        addSaveButtonsPanelOnFrame();
        addLabelsPanelOnFrame();
        pack();
    }

    private void addDescriptionTextAreasPanelOnFrame() {
        add(componentsPanels.getTextAreaPanel(), new GridBagConstraints(0, 0,
                1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
    }

    private void addCalendarAndPrioritySelectorPanelOnFrame() {
        add(componentsPanels.getCalendarPriorityAndStatusSelectorsPanel(), new GridBagConstraints(0, 1,
                1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(1, 1, 1, 1), 0, 0));
    }

    private void addSaveButtonsPanelOnFrame() {
        add(componentsPanels.getSaveButtonPanel(), new GridBagConstraints(0, 2,
                1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(1, 1, 1, 1), 0, 0));
    }

    private void addLabelsPanelOnFrame() {
        add(componentsPanels.getLabelsPanel(), new GridBagConstraints(0, 3,
                1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(1, 1, 1, 1), 0, 0));
    }
}
