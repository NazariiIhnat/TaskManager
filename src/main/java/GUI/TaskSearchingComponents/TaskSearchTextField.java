package GUI.TaskSearchingComponents;

import javax.swing.*;

public class TaskSearchTextField {
    private static JTextField searchByPriorityTextField = new  JTextField("Put here");

    public TaskSearchTextField() {
        searchByPriorityTextField.setSize(150, 40);
    }

    public static JTextField getSearchByPriorityTextField() {
        return searchByPriorityTextField;
    }
}
