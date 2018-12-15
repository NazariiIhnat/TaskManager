package GUI.TaskSearchingComponents.SecondFrameComponents;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private JFrame secondFrame = new JFrame();
    private ComponentsPanels componentsPanels = new ComponentsPanels();

    public Frame() {
        secondFrame.setName("Search");
        secondFrame.setVisible(false);
        secondFrame.setLayout(new GridBagLayout());
        secondFrame.add(componentsPanels.getSelectorsPanel(), new GridBagConstraints(0, 0, 1,
                1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
        secondFrame.add(componentsPanels.getSearchingTextFieldPanel(), new GridBagConstraints(1, 0, 1,
                1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(1, 1, 1, 1), 0, 0));
        secondFrame.add(componentsPanels.getOkButtonPanel(), new GridBagConstraints(0, 1, 2,
                2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(1, 1, 1, 1), 0, 0));
        secondFrame.pack();
    }

    public JFrame getSecondFrame() {
        return secondFrame;
    }
}
