package GUI.TaskModifyingComponents.SecondFrameComponents;

import Utilites.TextAreaUtils;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class DescriptionTextArea extends PlainDocument {
    private static JTextArea descriptionTextArea = new JTextArea();
    private static JScrollPane descriptionTextAreaScrollPane = new JScrollPane(descriptionTextArea);

    public DescriptionTextArea() {
        descriptionTextArea.setPreferredSize(new Dimension(300, 246));
        descriptionTextAreaScrollPane.setPreferredSize(new Dimension(300, 110));
        descriptionTextAreaScrollPane.setWheelScrollingEnabled(true);
        descriptionTextAreaScrollPane.setAutoscrolls(true);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        TextAreaUtils.setTextMaxLength(descriptionTextArea, 300);
    }

    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    JScrollPane getDescriptionTextAreaScrollPane() {
        return descriptionTextAreaScrollPane;
    }
}
