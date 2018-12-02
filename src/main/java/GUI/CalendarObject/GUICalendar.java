package GUI.CalendarObject;

import org.jdesktop.swingx.JXDatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GUICalendar {
    private static JXDatePicker calendar = new JXDatePicker();

    public GUICalendar() {
        calendar.getEditor().setEditable(false);
    }

    public String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getDate());
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

    public JXDatePicker getCalendar() {
        return calendar;
    }
}
