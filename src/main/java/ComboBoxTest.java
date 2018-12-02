import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ComboBoxTest {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(new Dimension(600, 600));
        jFrame.setVisible(true);
        jFrame.setLayout(new FlowLayout());
        JComboBox<String> comboBox = new JComboBox<String>();

        comboBox.addItem("A");
        comboBox.addItem("B");
        comboBox.addItem("C");
        comboBox.addItem("D");
        jFrame.add(comboBox);
        JButton button = new JButton("Push");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = Objects.requireNonNull(comboBox.getSelectedItem()).toString();
                System.out.println(a);
            }
        });
        jFrame.add(button);
    }
}
