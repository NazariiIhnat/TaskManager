package GUI.TaskTableObject;

import TaskManagement.TasksUpdater;
import TaskObject.Status;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ColorRenderer extends DefaultTableCellRenderer {
    private TasksUpdater tasksUpdater = new TasksUpdater();

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column){
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        switch ((Status)table.getValueAt(row, 4)){
            case IN_PROGRESS: setBackground(Color.WHITE); break;
            case FULFILLED: setBackground(Color.GREEN); break;
            case NOT_FULFILLED: setBackground(Color.RED); break;
        }

        return this;
    }
}
