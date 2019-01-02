package GUI.TaskModifyingComponents.SecondFrameComponents;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private static JFrame secondFrame = new JFrame("Update");
    private ComponentsPanels componentsPanels = new ComponentsPanels();

    public Frame() {
        secondFrame.setLayout(new GridBagLayout());
        secondFrame.setVisible(false);
        addDescriptionTextAreasPanelOnFrame();
        addCalendarAndPrioritySelectorPanelOnFrame();
        addSaveButtonsPanelOnFrame();
        addLabelsPanelOnFrame();
        secondFrame.pack();
    }

    private void addDescriptionTextAreasPanelOnFrame() {
        secondFrame.add(componentsPanels.getTextAreaPanel(), new GridBagConstraints(0, 0,
                1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));
    }

    private void addCalendarAndPrioritySelectorPanelOnFrame() {
        secondFrame.add(componentsPanels.getCalendarAndPrioritySelectorPanel(), new GridBagConstraints(0, 1,
                1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(1, 1, 1, 1), 0, 0));
    }

    private void addSaveButtonsPanelOnFrame() {
        secondFrame.add(componentsPanels.getSaveButtonPanel(), new GridBagConstraints(0, 2,
                1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(1, 1, 1, 1), 0, 0));
    }

    private void addLabelsPanelOnFrame() {
        secondFrame.add(componentsPanels.getLabelsPanel(), new GridBagConstraints(0, 3,
                1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(1, 1, 1, 1), 0, 0));
    }

    public JFrame getSecondFrame() {
        return secondFrame;
    }
}
