package GUI.TaskModifyingComponents.SecondFrameComponents;

import GUI.TaskTableObject.TaskTable;
import TaskObject.Status;

import javax.swing.*;

public class StatusUpdater {
    private static JCheckBox checkBox = new JCheckBox("Fulfilled");

    public static void setCheckBoxValue(boolean flag){
        checkBox.setSelected(flag);
    }

    static boolean getCheckBoxSelection() {
        return checkBox.isSelected();
    }

    static JCheckBox getCheckBox() {
        return checkBox;
    }

    public static void refreshCheckBoxEnabled() {
        try {
            if (TaskTable.getSelectedTaskStatus().equals(Status.NOT_FULFILLED.name()))
                checkBox.setEnabled(false);
            else
                checkBox.setEnabled(true);
        } catch (IndexOutOfBoundsException e) {
            checkBox.setEnabled(true);
        }
    }
}
