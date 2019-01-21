package GUI.MainGUIComponents;

import GUI.TaskTableObject.TaskTable;
import TaskObject.Status;

import javax.swing.*;

public class StatusUpdater extends JCheckBox{

    public StatusUpdater() {
        setText("DONE");
    }

    public void refreshCheckBoxEnabled() {
        try {
            if (TaskTable.getSelectedTaskStatus().equals(Status.UNDONE.name()))
                setEnabled(false);
            else
                setEnabled(true);
        } catch (IndexOutOfBoundsException e) {
            setEnabled(true);
        }
    }
}
