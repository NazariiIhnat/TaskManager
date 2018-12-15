package GUI.TaskSearchingComponents.SecondFrameComponents;

import GUI.PrioritySelectorObject.PrioritySelector;

import javax.swing.*;
import java.awt.*;

class ComponentsPanels {
    private DataTypeSelector selectors = new DataTypeSelector();
    private PrioritySelector prioritySelector = new PrioritySelector();
    private ValueReader valueReader = new ValueReader();
    private JPanel selectorsPanel = new JPanel();
    private JPanel searchingTextFieldPanel = new JPanel();
    private JPanel okButtonPanel = new JPanel();
    private OkButton okButton = new OkButton();

    ComponentsPanels() {
        addSelectorsOnPanel();
        addValueReadersOnPanel();
        addOkButtonOnPanel();
    }

    private void addSelectorsOnPanel(){
        selectorsPanel.setLayout(new GridLayout(6, 1));
        selectorsPanel.add(selectors.getTodayTasksRadioButton());
        selectorsPanel.add(selectors.getAllRadioButton());
        selectorsPanel.add(selectors.getIdRadioButton());
        selectorsPanel.add(selectors.getDateRadioButton());
        selectorsPanel.add(selectors.getDescriptionRadioButton());
        selectorsPanel.add(selectors.getPriorityRadioButton());
    }

    private void addValueReadersOnPanel() {
        valueReader.nullifySearchingValueTextField();
        searchingTextFieldPanel.setLayout(new GridLayout(4, 1));
        searchingTextFieldPanel.add(valueReader.getSearchingValueTextField());
        searchingTextFieldPanel.add(prioritySelector.getPrioritySelector());
        searchingTextFieldPanel.add(Calendar.getJxDatePicker());
    }

    private void addOkButtonOnPanel() {
        okButtonPanel.setLayout(new FlowLayout());
        okButtonPanel.add(okButton.getOkButton());
    }

    JPanel getSelectorsPanel() {
        return selectorsPanel;
    }

    JPanel getSearchingTextFieldPanel() {
        return searchingTextFieldPanel;
    }

    JPanel getOkButtonPanel() {
        return okButtonPanel;
    }
}
