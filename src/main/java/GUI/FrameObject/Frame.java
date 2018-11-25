package GUI.FrameObject;

import GUI.TaskAddingComponents.AddButton;
import GUI.TaskSearchingComponents.SearchButton;
import GUI.TaskTableObject.TaskTable;
import GUI.TextFieldsObject.TextField;
import TaskManagement.TasksSearcher;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Frame {
    private JFrame frame = new JFrame("Task manager");
    private TaskTable taskTable = new TaskTable();
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private static SearchButton searchButton;
    private static AddButton guiAddButtons;

    public static void main(String[] args) throws SQLException {
        new TasksSearcher().showAllTasks();
        new TaskTable().refreshTable();
        guiAddButtons = new AddButton();
        Frame guiFrame = new Frame();
        guiFrame.setAddButton();
        guiFrame.setFrameParameters();
        guiFrame.setTaskTable();
        searchButton = new SearchButton();
        guiFrame.setSearchButton();
    }

    public void setFrameParameters() {
        frame.setLayout(new GridBagLayout());
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        setTextFields();
        frame.pack();
    }

    private void setAddButton() {
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        frame.add(guiAddButtons.getAddButton());
    }

    public void setTextFields() {
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        frame.add(TextField.getDateInputTextField(), gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        frame.add(TextField.getDescriptionInputTextField(), gridBagConstraints);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        frame.add(TextField.getPriorityInputTextField(), gridBagConstraints);
        frame.add(TextField.getSerchByPriorityTextField());
    }

    public void setTaskTable() {
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 100;
        gridBagConstraints.gridwidth = 100;
        frame.add(taskTable.getTaskTableScrollPane());
    }

    public void setSearchButton() {
        frame.add(searchButton.getSearchButton());
    }
}
