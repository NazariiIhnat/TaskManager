package GUI.TaskModifyingComponents.SecondFrameComponents;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private JFrame secondFrame = new JFrame("Modify");
    private ComponentsPanels componentsPanels = new ComponentsPanels();

    public Frame() {
        secondFrame.setLayout(new GridBagLayout());
        secondFrame.setVisible(false);
        addDescriptionTextAreasPanelOnFrame();
        addCalendarAndPrioritySelectorPanelOnFrame();
        addSaveButtonsPanelOnFrame();
        secondFrame.pack();
    }

    private void addDescriptionTextAreasPanelOnFrame() {
        secondFrame.add(componentsPanels.getTextAreaPanel(), new GridBagConstraints(0, 0,
                1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(10, 10, 10, 10), 0, 0));
    }

    private void addCalendarAndPrioritySelectorPanelOnFrame() {
        secondFrame.add(componentsPanels.getCalendarAndPrioritySelectorPanel(), new GridBagConstraints(0, 1,
                1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(10, 10, 10, 10), 0, 0));
    }

    private void addSaveButtonsPanelOnFrame() {
        secondFrame.add(componentsPanels.getSaveButtonPanel(), new GridBagConstraints(0, 2,
                1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(10, 10, 10, 10), 0, 0));
    }

    public JFrame getSecondFrame() {
        return secondFrame;
    }
}
