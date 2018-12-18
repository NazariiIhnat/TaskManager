package Utilites;

import javax.swing.*;
import java.util.Objects;

public class ComboBoxUtils {
    public static String getSelectedPriorityLetter(JComboBox comboBox) {
        return Objects.requireNonNull(comboBox.getSelectedItem()).toString();
    }

    public static JComboBox addPriorityLetters(JComboBox<String> comboBox) {
        comboBox.addItem("A");
        comboBox.addItem("B");
        comboBox.addItem("C");
        comboBox.addItem("D");
        return comboBox;
    }
}
