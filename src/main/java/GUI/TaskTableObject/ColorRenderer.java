package GUI.TaskTableObject;

import TaskObject.Status;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ColorRenderer extends DefaultTableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column){
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        switch ((Status)table.getValueAt(row, 4)){
            case IN_PROGRESS: setBackground(Color.WHITE); break;
            case DONE: setBackground(Color.GREEN); break;
            case UNDONE: setBackground(Color.RED); break;
        }

        return this;
    }
}
