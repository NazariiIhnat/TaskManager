package GUI.TaskSearchingComponents.SecondFrameComponents;

import javax.swing.*;
import java.awt.*;

public class SecondFrame {
    private JFrame secondFrame = new JFrame("Search");

    public SecondFrame() {
        secondFrame.setVisible(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        secondFrame.setLocation(dim.width/4-secondFrame.getSize().width/4,
                dim.height/5-secondFrame.getSize().height/5);
        secondFrame.setLayout(new GridBagLayout());
        ComponentsPanels componentsPanels = new ComponentsPanels();
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
