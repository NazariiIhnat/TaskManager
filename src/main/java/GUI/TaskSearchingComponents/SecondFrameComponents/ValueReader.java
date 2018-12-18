package GUI.TaskSearchingComponents.SecondFrameComponents;

import javax.swing.*;
import java.awt.*;

class ValueReader {
    private static JTextField searchingValueTextField = new JTextField();

    ValueReader() {
        searchingValueTextField.setPreferredSize(new Dimension(100, 20));
    }

    void nullifySearchingValueTextField() {
        searchingValueTextField.setText(null);
    }

    JTextField getSearchingValueTextField() {
        return searchingValueTextField;
    }
}
