package GUI.TaskAddingComponents.SecondFrameComponents;

import org.jdesktop.swingx.JXDatePicker;

class Calendar {
    private static JXDatePicker jxDatePicker = new JXDatePicker();

    static JXDatePicker getJxDatePicker() {
        return jxDatePicker;
    }
}
