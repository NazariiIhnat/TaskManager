package Utilites;

import org.jdesktop.swingx.JXDatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static String getDate(JXDatePicker calendar) {
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getDate());
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
