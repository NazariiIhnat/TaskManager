package GUI.TaskAddingComponents.SecondFrameComponents;

import javax.swing.*;
import java.awt.*;
class TextField {
    private static JTextField descriptionTextField = new JTextField();

    TextField() {
        descriptionTextField.setPreferredSize(new Dimension(160, 20));
    }

    public void nullifyDescriptionTextField() {
        descriptionTextField.setText(null);
    }

    JTextField getDescriptionTextField() {
        return descriptionTextField;
    }
}
