package GUI.PrioritySelectorObject;

import javax.swing.*;
import java.util.Objects;

public class PrioritySelector {
    private static JComboBox <String> priorityComboBox;

    public PrioritySelector() {
        priorityComboBox = new JComboBox<>();
        priorityComboBox.addItem("A");
        priorityComboBox.addItem("B");
        priorityComboBox.addItem("C");
        priorityComboBox.addItem("D");
    }

    public String getSelectedPriorityLetter() {
        return Objects.requireNonNull(priorityComboBox.getSelectedItem()).toString();
    }

    public JComboBox<String> getPrioritySelector() {
        return priorityComboBox;
    }
}
