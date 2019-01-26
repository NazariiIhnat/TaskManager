package GUI.MainFrame;

import GUI.TaskAddingComponents.AddButton;
import GUI.TaskDeletingComponents.DeleteButton;
import GUI.TaskUpdatingComponents.UpdateButton;
import GUI.TaskSearchingComponents.SearchButton;
import GUI.TaskTableObject.TaskTable;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Frame {
    private JPanel tablePanel;
    private JPanel buttonsPanel;
    private static JFrame frame;
    private TaskTable taskTable = new TaskTable();
    private AddButton addButton = new AddButton();
    private SearchButton searchButton = new SearchButton();
    private DeleteButton deleteButton = new DeleteButton();
    private UpdateButton updateButton = new UpdateButton();


    public Frame() throws SQLException {

    }

    public static void main(String[] args) throws SQLException {
        Frame frame = new Frame();
        frame.start();
    }

    private void start() {
        tablePanel = new JPanel();
        buttonsPanel = new JPanel();
        frame = new JFrame("Task manager");
        setFrameParameters();
        addTableOnPanel();
        addButtonsOnPanel();
    }

    private void setFrameParameters() {
        frame.setMinimumSize(new Dimension(475, 380));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        setPanelsParameters();
        frame.add(tablePanel);
        frame.add(buttonsPanel, new GridBagConstraints(0, 1, 5, 1,
                0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0),
                0, 0));
    }

    private void setPanelsParameters() {
        tablePanel.setLayout(new GridBagLayout());
        buttonsPanel.setLayout(new GridLayout(1, 2));
    }

    private void addTableOnPanel() {
        tablePanel.add(taskTable.getTaskTableScrollPane(), new GridBagConstraints(0, 0, 5, 1,
                0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0),
                0, 0));
    }

    private void addButtonsOnPanel() {
        buttonsPanel.add(addButton.getAddButton());
        buttonsPanel.add(searchButton.getSearchButton());
        buttonsPanel.add(updateButton.getUpdateButton());
        buttonsPanel.add(deleteButton.getDeleteButton());
    }

    public static void setEnabled(boolean flag) {
        frame.setEnabled(flag);
    }
}
