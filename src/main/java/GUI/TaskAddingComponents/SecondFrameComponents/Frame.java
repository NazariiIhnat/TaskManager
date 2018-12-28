package GUI.TaskAddingComponents.SecondFrameComponents;

import javax.swing.*;
import java.awt.*;
public class Frame {
    private JFrame secondFrame = new JFrame("Add");
    private JPanel componentsPanel = new JPanel();
    private DescriptionTextArea textArea = new DescriptionTextArea();
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
        //secondFrame.pack();
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
        PrioritySelector.getPrioritySelector().setEnabled(true);
        componentsPanel.add(PrioritySelector.getPrioritySelector(), new GridBagConstraints(1, 2, 2, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
    }

    private void addTextAreaOnPanel() {
        componentsPanel.add(textArea.getDescriptionScrollPane(), new GridBagConstraints(1, 1, 2, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
    }

    private void addCalendarOnPanel() {
        componentsPanel.add(Calendar.getJxDatePicker(), new GridBagConstraints(1, 0, 2, 1, 0, 0,
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
