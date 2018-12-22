package GUI.TaskModifyingComponents.SecondFrameComponents;

import org.jdesktop.swingx.JXDatePicker;

public class Calendar {
    private static JXDatePicker calendar = new JXDatePicker();

    public Calendar() {
        Utilites.DateUtils.enableToChoosePastDays(calendar, false);
        calendar.getEditor().setEditable(false);
    }

    public JXDatePicker getCalendar() {
        return calendar;
    }
}
