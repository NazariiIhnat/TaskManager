package GUI.TaskSearchingComponents.SecondFrameComponents;

import GUI.MainValueReaders.GUICalendar;
import GUI.MainValueReaders.PriorityComboBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DataTypeSelector {
    private static JRadioButton todayTasksRadioButton = new JRadioButton("Today's tasks", true);
    private static JRadioButton allTasksRadioButton = new JRadioButton("All tasks", false);
    private static JRadioButton idRadioButton = new JRadioButton("By id", false);
    private static JRadioButton dateRadioButton = new JRadioButton("By date/dates", false);
    private static JRadioButton descriptionRadioButton = new JRadioButton("By description",false);
    private static JRadioButton priorityRadioButton = new JRadioButton("By priority", false);
    private static ButtonGroup groupOfSelectors = new ButtonGroup();
    private DescriptionAndIDReader searchingDescriptionAndIDReader = new DescriptionAndIDReader();
    private GUICalendar guiCalendar = MainSearchingComponents.getGUICalendar();
    private PriorityComboBox priorityComboBox = MainSearchingComponents.getPriorityComboBox();

    DataTypeSelector() {
        disableAllValueReaders();
        groupRadioButtons();
        addRadioButtonsActionListener();
        setRadioButtonsActionCommands();
    }

    private void groupRadioButtons() {
        groupOfSelectors.add(todayTasksRadioButton);
        groupOfSelectors.add(allTasksRadioButton);
        groupOfSelectors.add(idRadioButton);
        groupOfSelectors.add(dateRadioButton);
        groupOfSelectors.add(descriptionRadioButton);
        groupOfSelectors.add(priorityRadioButton);
    }

    private void setRadioButtonsActionCommands() {
        todayTasksRadioButton.setActionCommand("today's");
        allTasksRadioButton.setActionCommand("all");
        idRadioButton.setActionCommand("id");
        dateRadioButton.setActionCommand("date");
        descriptionRadioButton.setActionCommand("description");
        priorityRadioButton.setActionCommand("priority");
    }

    private void addRadioButtonsActionListener() {
        ActionListener radioButtonsActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(dateRadioButton.isSelected()){
                    enableValueReader("date");
                } else if(priorityRadioButton.isSelected())
                    enableValueReader("priority");
                else if(descriptionRadioButton.isSelected() || idRadioButton.isSelected())
                    enableValueReader("text");
                else disableAllValueReaders();
            }
        };

        todayTasksRadioButton.addActionListener(radioButtonsActionListener);
        allTasksRadioButton.addActionListener(radioButtonsActionListener);
        idRadioButton.addActionListener(radioButtonsActionListener);
        dateRadioButton.addActionListener(radioButtonsActionListener);
        descriptionRadioButton.addActionListener(radioButtonsActionListener);
        priorityRadioButton.addActionListener(radioButtonsActionListener);
    }

    private void enableValueReader(String valueReader) {
        disableAllValueReaders();
        switch (valueReader) {
            case "date" : guiCalendar.setEnabled(true); break;
            case "priority" : priorityComboBox.setEnabled(true); break;
            case "text" : searchingDescriptionAndIDReader.getSearchingValueTextField().setEnabled(true); break;
        }
    }

    private void disableAllValueReaders() {
        guiCalendar.setEnabled(false);
        searchingDescriptionAndIDReader.getSearchingValueTextField().setEnabled(false);
        priorityComboBox.setEnabled(false);
    }

    JRadioButton getTodayTasksRadioButton() {
        return todayTasksRadioButton;
    }

    JRadioButton getAllRadioButton() {
        return allTasksRadioButton;
    }

    JRadioButton getIdRadioButton() {
        return idRadioButton;
    }

    JRadioButton getDescriptionRadioButton() {
        return descriptionRadioButton;
    }

    JRadioButton getPriorityRadioButton() {
        return priorityRadioButton;
    }

    JRadioButton getDateRadioButton() {
        return dateRadioButton;
    }

    ButtonGroup getGroupOfSelectors() {
        return groupOfSelectors;
    }
}
