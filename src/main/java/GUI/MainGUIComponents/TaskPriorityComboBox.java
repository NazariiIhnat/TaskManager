package GUI.MainGUIComponents;

import javax.swing.*;
import java.util.Objects;

public class TaskPriorityComboBox extends JComboBox<String> {
    private static final String[] arrayOfPriorityLetters = {"A", "B", "C", "D"};

    public TaskPriorityComboBox() {
        addPriorityLettersToComboBox();
        setToolTipText("Priority");
    }

    public String getSelectedPriorityLetter() {
        return Objects.requireNonNull(this.getSelectedItem()).toString();
    }

    private void addPriorityLettersToComboBox() {
        for(String priorityLetter : arrayOfPriorityLetters)
            addItem(priorityLetter);
    }
}
