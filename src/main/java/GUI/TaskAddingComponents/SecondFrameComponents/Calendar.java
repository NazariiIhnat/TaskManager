package GUI.TaskAddingComponents.SecondFrameComponents;

import Utilites.DateUtils;
import org.jdesktop.swingx.JXDatePicker;

class Calendar {
    private static JXDatePicker jxDatePicker = new JXDatePicker();

    static {
        //DateUtils.enableToChoosePastDays(jxDatePicker, false);
    }

    static JXDatePicker getJxDatePicker() {
        return jxDatePicker;
    }
}
