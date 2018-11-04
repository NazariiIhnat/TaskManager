package Utilites;

import java.text.DateFormat;
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
}