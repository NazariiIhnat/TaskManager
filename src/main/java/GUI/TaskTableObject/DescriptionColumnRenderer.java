package GUI.TaskTableObject;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

class DescriptionColumnRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JTextArea tableTextArea = new JTextArea();
        tableTextArea.setText((String) table.getValueAt(row, 2));
        tableTextArea.setLineWrap(true);
        tableTextArea.setToolTipText(getMultilineTaskDescriptionToolTipText(tableTextArea.getText()));
        if (isSelected) {
            tableTextArea.setBackground(table.getSelectionBackground());
            tableTextArea.setForeground(table.getSelectionForeground());
        } else {
            tableTextArea.setBackground(table.getBackground());
            tableTextArea.setForeground(table.getForeground());
        }
        return tableTextArea;
    }

    private String getMultilineTaskDescriptionToolTipText(String text) {
        String[] arrayOfDescriptionTextAreaText = text.split("\n");
        StringBuilder toolTipTextBuilder = new StringBuilder("<html>");
        for(String eachLine : arrayOfDescriptionTextAreaText){
            toolTipTextBuilder.append(eachLine).append("<br>");
        }
        toolTipTextBuilder.append("<html>");
        return toolTipTextBuilder.toString();
    }
}