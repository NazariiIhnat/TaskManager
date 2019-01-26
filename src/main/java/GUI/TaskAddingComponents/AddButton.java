package GUI.TaskAddingComponents;

import GUI.MainValueReaders.SecondFrame;
import GUI.TaskAddingComponents.SecondFrameComponents.MainAddingComponents;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButton {
    private JButton addButton = new JButton("Add");
    private SecondFrame secondFrame = MainAddingComponents.getSecondFrame();

    public AddButton() {

        ActionListener addButtonActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondFrame.setVisible(true);
            }
        };
        addButton.addActionListener(addButtonActionListener);
    }

    public JButton getAddButton() {
        return addButton;
    }
}
