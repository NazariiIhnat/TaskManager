package GUI.TaskSearchingComponents;

import GUI.TaskSearchingComponents.SecondFrameComponents.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchButton {
    private JButton searchButton = new JButton("Search");
    private Frame secondFrame = new Frame();

    public SearchButton() {
        ActionListener searchButtonActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondFrame.getSecondFrame().setVisible(true);
            }
        };
        searchButton.addActionListener(searchButtonActionListener);
        }

    public JButton getSearchButton() {
        return searchButton;
    }
}
