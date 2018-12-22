package Utilites;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextAreaUtils {

    private static final int ROW_MAX_LENGTH = 15;

    public static void setTextMaxLength(JTextArea textArea, int maxLength) {
        addTextAreasKeyListener(textArea);
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                disableTextAreaEditingWhenTextLengthIsMax(textArea, maxLength);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                disableTextAreaEditingWhenTextLengthIsMax(textArea, maxLength);
            }
        });
    }

    private static void disableTextAreaEditingWhenTextLengthIsMax(JTextArea textArea, int maxLength) {
        if(textArea.getText().length() > maxLength || isMaxRows(textArea.getLineCount())) {
            textArea.setEditable(false);
            deleteOverLengthText(textArea, maxLength);
        }
    }

    private static void addTextAreasKeyListener(JTextArea textArea) {
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                    textArea.setEditable(true);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private static void deleteOverLengthText(JTextArea textArea, int maxLength){
        Runnable deleteOverLengthTextThread = new Runnable() {
            @Override
            public void run() {
                String inputtedText = textArea.getText();
                try {
                    textArea.setText(inputtedText.substring(0, maxLength));
                } catch (StringIndexOutOfBoundsException e) {
                    textArea.setEditable(false);
                }
            }
        };
        SwingUtilities.invokeLater(deleteOverLengthTextThread);
    }

    private static boolean isMaxRows(int rowsCount) {
        return rowsCount > ROW_MAX_LENGTH;
    }
}
