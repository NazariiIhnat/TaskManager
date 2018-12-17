package Utilites;

import org.jdesktop.swingx.JXDatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String getDate(JXDatePicker calendar) {
        return simpleDateFormat.format(calendar.getDate());
    }

    public static String[] getRangeOfDates(JXDatePicker calendar) {
        String[] firstAndLastSelectedDates = new String[2];
        firstAndLastSelectedDates[0] = simpleDateFormat.format(calendar.getMonthView().getSelection().first());
        firstAndLastSelectedDates[1] = simpleDateFormat.format(calendar.getMonthView().getSelection().last());
        return firstAndLastSelectedDates;
    }

    public static void enableToChoosePastDays(JXDatePicker calendar, boolean choice) {
        Calendar cal = calendar.getMonthView().getCalendar();
        cal.setTime(new Date());
        if(!choice) {
            calendar.getMonthView().setLowerBound(cal.getTime());
        } else {
            calendar.getMonthView().setLowerBound(null);
        }
    }

    public static void enableDateEdition(JXDatePicker calendar, boolean flag) {
        calendar.getEditor().setEditable(flag);
    }

    public static void nullifyCalendar(JXDatePicker calendar) {
        calendar.setDate(null);
    }
}
