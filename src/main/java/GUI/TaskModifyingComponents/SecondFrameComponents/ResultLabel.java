package GUI.TaskModifyingComponents.SecondFrameComponents;

import javax.swing.*;
import java.awt.*;

class ResultLabel {
    private static JLabel label = new JLabel(" ");

    JLabel getLabel() {
        return label;
    }

    static void setMessage(String text, Color color) {
        label.setText(text);
        label.setForeground(color);
    }
}
