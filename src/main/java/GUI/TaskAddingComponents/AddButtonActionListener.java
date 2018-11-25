package GUI.TaskAddingComponents;

import GUI.TextFieldsObject.TextField;
import TaskObject.Task;
import Utilites.DataVerifier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;

class AddButtonActionListener {
    private boolean isCorrectDate = false;
    private boolean isCorrectDescription = false;
    private boolean isCorrectPriority = false;
    private DataVerifier dataVerifier = new DataVerifier();
    private ActionListener addButtonActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            verifyDate(TextField.getDateInputTextField().getText());
            verifyDescription(TextField.getDescriptionInputTextField().getText());
            verifyPriorityLetter(TextField.getPriorityInputTextField().getText());
            if(isCorrectDate && isCorrectDescription && isCorrectPriority)
            try {
                createNewTaskObject();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    };

    private void verifyDate(String date) {
        if(!dataVerifier.isDate(date)) {
            TextField.getDateInputTextField().setText("Write date in format yyyy-MM-dd");
            isCorrectDate = false;
        }
        else if(!dataVerifier.isValidDate(date)) {
            TextField.getDateInputTextField().setText(LocalDate.now() + " is invalid date");
            isCorrectDate = false;
        }
        else  if (dataVerifier.isPastDay(date)) {
            TextField.getDateInputTextField().setText("You can't add tasks before " + LocalDate.now());
            isCorrectDate = false;
        }
        else
            isCorrectDate = true;
    }

    private void verifyDescription(String description) {
        if(dataVerifier.isEmptyInput(description)) {
            TextField.getDescriptionInputTextField().setText("Description couldn't be empty");
            isCorrectDescription = false;
        }
        else
            isCorrectDescription = true;
    }

    private void verifyPriorityLetter(String priorityLetter) {
        if(dataVerifier.isEmptyInput(priorityLetter)) {
            TextField.getPriorityInputTextField().setText("Priority couldn't be empty");
            isCorrectPriority = false;
        }
        if(!dataVerifier.isPriorityLetter(priorityLetter)) {
            TextField.getPriorityInputTextField().setText("Put one of next priority letters: A, B, C, D");
            isCorrectPriority = false;
        }
        else
            isCorrectPriority = true;
    }

    ActionListener getAddButtonActionListener() {
        return addButtonActionListener;
    }


    //task adding to DB in constructor so that method is also adding task to DB
    private void createNewTaskObject() throws SQLException {
        new Task(TextField.getDateInputTextField().getText(),
                 TextField.getDescriptionInputTextField().getText(),
                 TextField.getPriorityInputTextField().getText().toUpperCase());
    }
}
