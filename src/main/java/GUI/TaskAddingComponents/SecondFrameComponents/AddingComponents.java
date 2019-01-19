package GUI.TaskAddingComponents.SecondFrameComponents;

import GUI.GUIComponents.GUICalendar;
import GUI.GUIComponents.TaskDescriptionTextArea;

public class AddingComponents {
    private static GUICalendar guiCalendar = new GUICalendar();
    private static TaskDescriptionTextArea taskDescriptionTextArea = new TaskDescriptionTextArea();

    static {
        setGUICalendarsParameters();
    }

    private static void setGUICalendarsParameters() {
        guiCalendar.enableToChoosePastDays(false);
        guiCalendar.enableSingleIntervalSelection(false);
        guiCalendar.enableDateEdition(false);
    }

    public static GUICalendar getGuiCalendar() {
        return guiCalendar;
    }

    public static TaskDescriptionTextArea getTaskDescriptionTextArea() {
        return taskDescriptionTextArea;
    }
}
