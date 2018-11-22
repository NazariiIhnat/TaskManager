package GUI.Buttons;

import GUI.ActionListeners.AddButtonActionListener;

import javax.swing.*;

public class AddButton {
    public JButton getAddButton() {
        return addButton;
    }

    private JButton addButton = new JButton("Add");
    private AddButtonActionListener addButtonActionListener = new AddButtonActionListener();

    public AddButton() {
        setAddButtonParameters();
    }

   private void setAddButtonParameters(){
        addButton.addActionListener(addButtonActionListener.getAddButtonActionListener());
    }
}
