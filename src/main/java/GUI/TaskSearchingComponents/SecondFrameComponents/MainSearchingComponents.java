package GUI.TaskSearchingComponents.SecondFrameComponents;

import GUI.MainValueReaders.GUICalendar;
import GUI.MainValueReaders.PriorityComboBox;

public class MainSearchingComponents {
    private static GUICalendar guiCalendar = new GUICalendar();
    private static PriorityComboBox priorityComboBox = new PriorityComboBox();

    static {
        setGUICalendarParameters();
    }

    private static void setGUICalendarParameters() {
        guiCalendar.enableDateEdition(false);
        guiCalendar.enableToChoosePastDays(true);
        guiCalendar.enableSingleIntervalSelection(true);
    }

    public static GUICalendar getGUICalendar() {
        return guiCalendar;
    }

    public static PriorityComboBox getPriorityComboBox() {
        return priorityComboBox;
    }
}
