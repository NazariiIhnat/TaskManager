package GUI.TaskModifyingComponents.SecondFrameComponents;

import GUI.MainGUIComponents.ColoredLabel;
import GUI.MainGUIComponents.GUICalendar;
import GUI.MainGUIComponents.TaskDescriptionTextArea;
import GUI.MainGUIComponents.TaskPriorityComboBox;

public class MainModifyingComponents {
    private static GUICalendar guiCalendar = new GUICalendar();
    private static TaskDescriptionTextArea taskDescriptionTextArea = new TaskDescriptionTextArea();
    private static TaskPriorityComboBox taskPriorityComboBox = new TaskPriorityComboBox();
    private static ColoredLabel coloredLabel = new ColoredLabel();

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

    static ColoredLabel getColoredLabel() {
        return coloredLabel;
    }
}
