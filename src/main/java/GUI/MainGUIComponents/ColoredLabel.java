package GUI.MainGUIComponents;

import javax.swing.*;
import java.awt.*;

public class ColoredLabel extends JLabel {

    public ColoredLabel() {
        super.setText("\n");
    }

    public void setColoredText(String text, Color color){
        super.setText(text);
        super.setForeground(color);
    }

    public void nullifyColoredLabel() {
        super.setText(" ");
        super.setForeground(Color.black);
    }
}
