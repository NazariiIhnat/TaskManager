package GUI.TaskAddingComponents.SecondFrameComponents;

import javax.swing.*;
import java.util.Objects;

class ComboBox {
    private static JComboBox <String> priorityComboBox;

    ComboBox() {
        priorityComboBox = new JComboBox<>();
        priorityComboBox.addItem("A");
        priorityComboBox.addItem("B");
        priorityComboBox.addItem("C");
        priorityComboBox.addItem("D");
        priorityComboBox.setSelectedItem(null);
    }

    String getSelectedPriorityLetter() {
        return Objects.requireNonNull(priorityComboBox.getSelectedItem()).toString();
    }

    JComboBox<String> getPriorityComboBox() {
        return priorityComboBox;
    }
}
