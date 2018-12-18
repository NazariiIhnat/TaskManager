package GUI.TaskAddingComponents.SecondFrameComponents;

import Utilites.ComboBoxUtils;

import javax.swing.*;

class PrioritySelector {

    private static JComboBox <String> prioritySelector = new JComboBox<>();

    static {
        ComboBoxUtils.addPriorityLetters(prioritySelector);
    }

    static JComboBox<String> getPrioritySelector() {
        return prioritySelector;
    }
}
