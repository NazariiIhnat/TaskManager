package GUI.MainGUIComponents;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TaskDescriptionTextArea extends JTextArea {
    private static final int MAX_ROW_LENGTH = 15;
    private static final int MAX_CHAR_COUNT = 300;
    private JScrollPane scrollPane;

    public TaskDescriptionTextArea() {
        scrollPane = new JScrollPane(this);
        setTextAndRowsMaxLength();
        setTaskDescriptionTextAreaParameters();
    }

    private void setTextAndRowsMaxLength() {
        addTextAreasKeyListener();
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                disableTextAreaEditingWhenTextLengthIsMax();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                disableTextAreaEditingWhenTextLengthIsMax();
            }
        });
    }

    private void disableTextAreaEditingWhenTextLengthIsMax() {
        if(getText().length() > MAX_CHAR_COUNT || isMaxRows(getLineCount())) {
            setEditable(false);
            deleteOverLengthText();
        }
    }

    private void addTextAreasKeyListener() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                    setEditable(true);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private void deleteOverLengthText(){
        Runnable deleteOverLengthTextThread = new Runnable() {
            @Override
            public void run() {
                String inputtedText = getText();
                try {
                    setText(inputtedText.substring(0, MAX_CHAR_COUNT));
                } catch (StringIndexOutOfBoundsException e) {
                    setEditable(false);
                }
            }
        };
        SwingUtilities.invokeLater(deleteOverLengthTextThread);
    }

    private boolean isMaxRows(int rowsCount) {
        return rowsCount > MAX_ROW_LENGTH;
    }

    private void setTaskDescriptionTextAreaParameters() {
        setPreferredSize(new Dimension(300, 246));
        setLineWrap(true);
        setWrapStyleWord(true);
        scrollPane.setPreferredSize(new Dimension(300, 110));
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setAutoscrolls(true);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}
