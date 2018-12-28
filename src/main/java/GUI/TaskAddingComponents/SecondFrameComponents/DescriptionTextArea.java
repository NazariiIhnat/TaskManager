package GUI.TaskAddingComponents.SecondFrameComponents;

import Utilites.TextAreaUtils;

import javax.swing.*;
import java.awt.*;
public class DescriptionTextArea {
    private static JTextArea descriptionTextArea = new JTextArea();
    private static JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextArea);

    DescriptionTextArea() {
        TextAreaUtils.setTextMaxLength(descriptionTextArea, 300);
        descriptionTextArea.setPreferredSize(new Dimension(300, 246));
        descriptionScrollPane.setPreferredSize(new Dimension(300, 110));
        descriptionScrollPane.setWheelScrollingEnabled(true);
        descriptionScrollPane.setAutoscrolls(true);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
    }

    public void nullifyDescriptionTextField() {
        descriptionTextArea.setText(null);
    }

    JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    JScrollPane getDescriptionScrollPane() {
        return descriptionScrollPane;
    }
}
