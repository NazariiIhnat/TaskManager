package GUI.MainValueReaders;

import javax.swing.*;
import java.util.Objects;

public class PriorityComboBox extends JComboBox<String> {
    private static final String[] arrayOfPriorityLetters = {"A", "B", "C", "D"};

    public PriorityComboBox() {
        addPriorityLettersToComboBox();
    }

    public String getSelectedPriorityLetter() {
        return Objects.requireNonNull(this.getSelectedItem()).toString();
    }

    private void addPriorityLettersToComboBox() {
        for(String priorityLetter : arrayOfPriorityLetters)
            addItem(priorityLetter);
    }
}
