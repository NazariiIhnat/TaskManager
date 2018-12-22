package GUI.TaskModifyingComponents.SecondFrameComponents;

import Utilites.ComboBoxUtils;

import javax.swing.*;

public class PrioritySelector {
    private static JComboBox <String> prioritySelectorComboBox = new JComboBox<>();

    public PrioritySelector() {
        if(prioritySelectorComboBox.getItemCount() == 0)
            ComboBoxUtils.addPriorityLetters(prioritySelectorComboBox);
    }

    public JComboBox<String> getPrioritySelectorComboBox() {
        return prioritySelectorComboBox;
    }
}
