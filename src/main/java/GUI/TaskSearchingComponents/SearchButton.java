package GUI.TaskSearchingComponents;

import javax.swing.*;

public class SearchButton {
    private JButton searchButton = new JButton("Search");
    private SearchButtonActionListener searchButtonActionListener = new SearchButtonActionListener();

    public SearchButton() {
        searchButton.addActionListener(searchButtonActionListener.getSearchButtonActionListener());
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}
