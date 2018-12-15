package GUI.TaskAddingComponents;

import GUI.CalendarObject.GUICalendar;
import GUI.TaskAddingComponents.SecondFrameComponents.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButton {
    private JButton addButton = new JButton("Add");
    private Frame secondFrame = new Frame();

    public AddButton() {

        ActionListener addButtonActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondFrame.getSecondFrame().setVisible(true);
            }
        };
        addButton.addActionListener(addButtonActionListener);
    }

    public JButton getAddButton() {
        return addButton;
    }
}
