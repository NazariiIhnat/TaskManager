package GUI.TaskSearchingComponents.SecondFrameComponents;

import GUI.MainGUIComponents.GUICalendar;
import GUI.MainGUIComponents.TaskPriorityComboBox;

public class SearchingComponents {
    private static GUICalendar guiCalendar = new GUICalendar();
    private static TaskPriorityComboBox taskPriorityComboBox = new TaskPriorityComboBox();

    static {
        setGUICalendarParameters();
    }

    private static void setGUICalendarParameters() {
        guiCalendar.enableDateEdition(true);
        guiCalendar.enableToChoosePastDays(true);
        guiCalendar.enableSingleIntervalSelection(true);
    }

    public static GUICalendar getGUICalendar() {
        return guiCalendar;
    }

    public static TaskPriorityComboBox getTaskPriorityComboBox() {
        return taskPriorityComboBox;
    }
}
