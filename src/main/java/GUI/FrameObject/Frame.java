package GUI.FrameObject;

import GUI.Buttons.AddButton;
import GUI.TextFieldsObject.TextField;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private JFrame frame = new JFrame("Task manager");
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    static AddButton guiAddButtons;

    public static void main(String[] args) {
        guiAddButtons = new AddButton();
        Frame guiFrame = new Frame();
        guiFrame.setFrameParameters();
    }

    public void setFrameParameters() {
        frame.setLayout(new GridBagLayout());
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(guiAddButtons.getAddButton());
        setTextFields();
        frame.pack();
    }

    public void setTextFields() {
        frame.add(TextField.getDateInputTextField(), gridBagConstraints);
        gridBagConstraints.gridy = 1;
        frame.add(TextField.getDescriptionInputTextField(), gridBagConstraints);
        gridBagConstraints.gridy = 2;
        frame.add(TextField.getPriorityInputTextField(), gridBagConstraints);
    }
}
