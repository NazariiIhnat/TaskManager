package GUI.TaskSearchingComponents;

import GUI.TaskSearchingComponents.SecondFrameComponents.SecondFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchButton {
    private JButton searchButton = new JButton("Search");
    private SecondFrame secondSecondFrame = new SecondFrame();

    public SearchButton() {
        ActionListener searchButtonActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondSecondFrame.getSecondFrame().setVisible(true);
            }
        };
        searchButton.addActionListener(searchButtonActionListener);
        }

    public JButton getSearchButton() {
        return searchButton;
    }
}
