package GUI.TaskModifyingComponents.SecondFrameComponents;

import GUI.GUIComponents.GUICalendar;

public class ModifyingComponents {
    private static GUICalendar guiCalendar = new GUICalendar();

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
}
