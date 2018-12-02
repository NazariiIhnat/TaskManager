package GUI.TaskAddingComponents.SecondFrameComponents;

import javax.swing.*;

class Labels {
    private JLabel dateLabel = new JLabel("Date: ");
    private JLabel descriptionLabel = new JLabel("Description: ");
    private JLabel priorityLabel = new JLabel("Priority: ");
    private static JLabel taskAddResultLabel = new JLabel();

    JLabel getDateLabel() {
        return dateLabel;
    }

    JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    JLabel getPriorityLabel() {
        return priorityLabel;
    }

    JLabel getTaskAddResultLabel() {
        return taskAddResultLabel;
    }
}
