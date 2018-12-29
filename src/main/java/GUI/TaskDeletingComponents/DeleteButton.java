package GUI.TaskDeletingComponents;

import GUI.TaskTableObject.TaskTable;
import TaskManagement.TasksUpdater;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteButton {
    private static JButton deleteButton = new JButton("Delete");
    private TasksUpdater tasksUpdater = new TasksUpdater();

    public DeleteButton() {
        if(deleteButton.getActionListeners().length == 0) {
            ActionListener deleteButtonActionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        tasksUpdater.deleteTaskFromDatabase(Integer.parseInt(TaskTable.getSelectedTaskID()));
                        new TaskTable().refreshTable();
                    } catch (SQLException e1) {
                            e1.printStackTrace();
                    }
                }
            };
            deleteButton.addActionListener(deleteButtonActionListener);
        }
        deleteButton.setEnabled(false);
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

}
