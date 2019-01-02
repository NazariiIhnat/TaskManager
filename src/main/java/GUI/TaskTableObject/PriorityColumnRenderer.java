package GUI.TaskTableObject;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class PriorityColumnRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        JLabel label = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, 3);
        label.setToolTipText(getPriorityLettersExplanationToolTipText(value.toString()));
        return label;
    }

    private String getPriorityLettersExplanationToolTipText(String letter) {
        String letterDescription = null;
        switch (letter) {
            case "A":
                letterDescription = "Important and urgent";
                break;
            case "B":
                letterDescription = "Important and not urgent";
                break;
            case "C":
                letterDescription = "Not important and urgent";
                break;
            case "D":
                letterDescription = "Not important and not urgent";
                break;
        }
        return letterDescription;
    }
}
