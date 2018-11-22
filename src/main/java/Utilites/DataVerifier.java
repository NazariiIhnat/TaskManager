package Utilites;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DataVerifier {
    public final boolean isDate(String inputData) {
        try {
            new SimpleDateFormat("yyyy-MM-dd").parse(inputData); //checks if in format yyyy-MM-dd. If not - catched by ParseException.
            LocalDate.parse(inputData);
        } catch (ParseException | DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public final boolean isValidDate(String inputData) {
        try{
            LocalDate.parse(inputData);
            return true;
        } catch(DateTimeParseException e) {
            return false;
        }
    }

    public final boolean isPastDay(String inputData){
        return LocalDate.parse(inputData).isBefore(LocalDate.now());
    }

    public final boolean isEmptyInput(String inputData){
        String [] arrayOfInputDateWithoutSpaces = inputData.split(" ");
        return arrayOfInputDateWithoutSpaces.length == 0 || inputData.equals("");
    }

    public final boolean isPriorityLetter(String inputData) {
        if(inputData.toLowerCase().equals("a") || inputData.toLowerCase().equals("b")
                || inputData.toLowerCase().equals("c") || inputData.toLowerCase().equals("d"))
            return true;
        else {
            System.out.println("Choose one of priority letter: A, B, C, D.");
            return false;
        }
    }

    public final boolean isNumber(String inputData) {
        try{
            Integer.parseInt(inputData);
            return true;
        } catch (Exception e) {
            System.out.println("Task ID is integer. Try again.");
            return false;
        }
    }
}