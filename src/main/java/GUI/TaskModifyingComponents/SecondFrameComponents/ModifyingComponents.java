package GUI.TaskModifyingComponents.SecondFrameComponents;

import GUI.MainGUIComponents.GUICalendar;
import GUI.MainGUIComponents.TaskDescriptionTextArea;
import GUI.MainGUIComponents.TaskPriorityComboBox;

public class ModifyingComponents {
    private static GUICalendar guiCalendar = new GUICalendar();
    private static TaskDescriptionTextArea taskDescriptionTextArea = new TaskDescriptionTextArea();
    private static TaskPriorityComboBox taskPriorityComboBox = new TaskPriorityComboBox();

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

    public static TaskPriorityComboBox getTaskPriorityComboBox() {
        return taskPriorityComboBox;
    }
}
