package Utilites;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DataVerifier {
    public static boolean isDateFormat(String inputData) {
        try {
            new SimpleDateFormat("yyyy-MM-dd").parse(inputData); //checks if in format yyyy-MM-dd. If not - catched by ParseException.
            LocalDate.parse(inputData);
        } catch (ParseException | DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidDate(String inputData) {
        try{
            LocalDate.parse(inputData);
            return true;
        } catch(DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isEmptyInput(String inputData){
        return inputData.trim().equals("");
    }

    public static boolean isPriorityLetter(String inputData) {
        return inputData.toLowerCase().equals("a") || inputData.toLowerCase().equals("b")
                || inputData.toLowerCase().equals("c") || inputData.toLowerCase().equals("d");
    }

    public static boolean isNumber(String inputData) {
        try{
            Integer.parseInt(inputData);
            return true;
        } catch (Exception e) {
            System.out.println("Task ID is integer. Try again.");
            return false;
        }
    }
}