package GUI.TaskSearchingComponents.SecondFrameComponents;

import GUI.MainGUIComponents.GUICalendar;

public class ModifyingComponents {
    private static GUICalendar guiCalendar = new GUICalendar();

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
}
