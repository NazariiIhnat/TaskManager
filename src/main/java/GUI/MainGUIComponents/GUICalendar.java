package GUI.GUIComponents;

import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.calendar.DateSelectionModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GUICalendar extends JXDatePicker {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void enableToChoosePastDays(boolean flag) {
        Calendar cal = super.getMonthView().getCalendar();
        cal.setTime(new Date());
        if(!flag) {
            super.getMonthView().setLowerBound(cal.getTime());
        } else {
            super.getMonthView().setLowerBound(null);
        }
    }

    public void enableDateEdition(boolean flag) {
        super.getEditor().setEditable(flag);
    }

    public void enableSingleIntervalSelection(boolean flag) {
        JXMonthView monthView = super.getMonthView();
        if(flag)
            monthView.setSelectionMode(DateSelectionModel.SelectionMode.SINGLE_INTERVAL_SELECTION);
        else
            monthView.setSelectionMode(DateSelectionModel.SelectionMode.SINGLE_SELECTION);
    }

    public String getStringDate() {
        return simpleDateFormat.format(super.getDate());
    }

    public String[] getRangeOfDates() {
        String[] firstAndLastSelectedDates = new String[2];
        firstAndLastSelectedDates[0] = simpleDateFormat.format(super.getMonthView().getSelection().first());
        firstAndLastSelectedDates[1] = simpleDateFormat.format(super.getMonthView().getSelection().last());
        return firstAndLastSelectedDates;
    }

    public void nullifyCalendar() {
        super.setDate(null);
    }
}
