package GUI.CalendarObject;

import org.jdesktop.swingx.JXDatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GUICalendar {
    private static JXDatePicker calendar;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public GUICalendar() {
        calendar = new JXDatePicker();
        calendar.setVisible(true);
    }

    public static String getDate() {
        return simpleDateFormat.format(calendar.getDate());
    }

    public void enableToChoosePastDays(boolean choice) {
        Calendar cal = calendar.getMonthView().getCalendar();
        cal.setTime(new Date());
        if(!choice) {
            calendar.getMonthView().setLowerBound(cal.getTime());
        } else {
            calendar.getMonthView().setLowerBound(null);
        }
    }

    public void enableDateEdition(boolean flag) {
        calendar.getEditor().setEditable(flag);
    }

    public JXDatePicker getCalendar() {
        return calendar;
    }

    public void nullifyCalendar() {
        calendar.setDate(null);
    }
}
