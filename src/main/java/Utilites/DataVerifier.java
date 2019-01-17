package Utilites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataVerifier {

    public static boolean isNotFulFilledTask(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate taskDate = LocalDate.parse(date, dateTimeFormatter);
        return taskDate.isBefore(LocalDate.now());
    }

    public static boolean isEmptyInput(String inputData){
        return inputData.trim().equals("");
    }
}