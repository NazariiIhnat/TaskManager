package GUI.TextFieldsObject;

import java.awt.*;

public class TextField {

    private static java.awt.TextField dateInputTextArea = new java.awt.TextField();
    private static java.awt.TextField descriptionInputTExtArea = new java.awt.TextField();
    private static java.awt.TextField priorityInputTextArea = new java.awt.TextField();

    private static java.awt.TextField serchByPriorityTextField = new  java.awt.TextField("Put here");

    public TextField() {
        dateInputTextArea.setPreferredSize(new Dimension(150, 25));
        descriptionInputTExtArea.setPreferredSize(new Dimension(150, 25));
        priorityInputTextArea.setPreferredSize(new Dimension(150, 25));
        serchByPriorityTextField.setPreferredSize(new Dimension(150, 25));
    }

    public static java.awt.TextField getDateInputTextField() {
        return dateInputTextArea;
    }

    public static java.awt.TextField getDescriptionInputTextField() {
        return descriptionInputTExtArea;
    }

    public static java.awt.TextField getPriorityInputTextField() {
        return priorityInputTextArea;
    }

    public static java.awt.TextField getSerchByPriorityTextField() {
        return serchByPriorityTextField;
    }
}
