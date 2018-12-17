package GUI.TaskSearchingComponents.SecondFrameComponents;

import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.calendar.DateSelectionModel;

class Calendar {
    private static JXDatePicker jxDatePicker = new JXDatePicker();

    static {
        JXMonthView monthView = Calendar.jxDatePicker.getMonthView();
        monthView.setSelectionMode(DateSelectionModel.SelectionMode.MULTIPLE_INTERVAL_SELECTION);
    }

    static JXDatePicker getJxDatePicker() {
        return jxDatePicker;
    }
}
