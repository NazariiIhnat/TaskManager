package GUI.ActionListeners;

import GUI.TextFieldsObject.TextField;
import Utilites.DataVerifier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AddButtonActionListener {
    private DataVerifier dataVerifier = new DataVerifier();
    private ActionListener addButtonActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            verifyDate(TextField.getDateInputTextField().getText());
            verifyDescription(TextField.getDescriptionInputTextField().getText());
            verifyPriorityLetter(TextField.getPriorityInputTextField().getText());
        }
    };

    private void verifyDate(String date) {
        if(!dataVerifier.isDate(date)) {
            TextField.getDateInputTextField().setText("Write date in format yyyy-MM-dd");
        }
        else if(!dataVerifier.isValidDate(date))
            TextField.getDateInputTextField().setText(LocalDate.now() + " is invalid date");
        else  if (dataVerifier.isPastDay(date))
            TextField.getDateInputTextField().setText("You can't add tasks before " + LocalDate.now());
        else
            TextField.getDateInputTextField().setText("Success");
    }

    private void verifyDescription(String description) {
        if(dataVerifier.isEmptyInput(description))
            TextField.getDescriptionInputTextField().setText("Description couldn't be empty");
        else
            TextField.getDescriptionInputTextField().setText("Success");
    }

    private void verifyPriorityLetter(String priorityLetter) {
        if(dataVerifier.isEmptyInput(priorityLetter))
            TextField.getPriorityInputTextField().setText("Priority couldn't be empty");
        if(!dataVerifier.isPriorityLetter(priorityLetter))
            TextField.getPriorityInputTextField().setText("Put one of next priority letters: A, B, C, D");
        else
            TextField.getPriorityInputTextField().setText("Success");
    }

    public ActionListener getAddButtonActionListener() {
        return addButtonActionListener;
    }
}
