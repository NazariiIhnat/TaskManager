package Utilites;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

class DataVerifier {
    boolean isDate(String inputData) {
        try {
            new SimpleDateFormat("yyyy-MM-dd").parse(inputData); //checks if in format yyyy-MM-dd
            LocalDate.parse(inputData);  //checks if is valid date
            return true;
        } catch (ParseException e) {
            System.out.println("Date format error. Write in format yyyy-MM-dd.");
            return false;
        }
        catch (DateTimeParseException e) {
            System.out.println("Invalid date " + inputData + ".");
            return false;
        }
    }

    boolean isEmptyDescription(String inputData){
        String [] arrayOfInputDateWithoutSpaces = inputData.split(" ");
        if (arrayOfInputDateWithoutSpaces.length == 0 || inputData.equals("")) {
            System.out.println("Task description can not be empty.");
            return true;
        }
        else return false;
    }

    boolean isPriorityLetter(String inputData) {
        if(inputData.toLowerCase().equals("a") || inputData.toLowerCase().equals("b")
                || inputData.toLowerCase().equals("c") || inputData.toLowerCase().equals("d"))
            return true;
        else {
            System.out.println("Choose one of priority letter: A, B, C, D.");
            return false;
        }
    }
}