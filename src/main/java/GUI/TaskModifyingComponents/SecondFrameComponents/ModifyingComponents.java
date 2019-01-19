package GUI.TaskModifyingComponents.SecondFrameComponents;

import GUI.GUIComponents.GUICalendar;
import GUI.GUIComponents.TaskDescriptionTextArea;

public class ModifyingComponents {
    private static GUICalendar guiCalendar = new GUICalendar();
    private static TaskDescriptionTextArea taskDescriptionTextArea = new TaskDescriptionTextArea();

    static {
        setGUICalendarParameters();
    }

    private static void setGUICalendarParameters() {
        getGuiCalendar().enableToChoosePastDays(false);
        getGuiCalendar().enableDateEdition(false);
        getGuiCalendar().enableSingleIntervalSelection(false);
    }

    public static GUICalendar getGuiCalendar() {
        return guiCalendar;
    }

    public static TaskDescriptionTextArea getTaskDescriptionTextArea() {
        return taskDescriptionTextArea;
    }
}
