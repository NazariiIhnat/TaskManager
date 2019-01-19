package GUI.TaskAddingComponents.SecondFrameComponents;

import GUI.GUIComponents.GUICalendar;

public class AddingComponents {
    private static GUICalendar guiCalendar = new GUICalendar();

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
}
