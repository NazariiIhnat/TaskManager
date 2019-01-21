package GUI.TaskModifyingComponents.SecondFrameComponents;

import GUI.MainGUIComponents.*;

public class MainUpdatingComponents {
    private static GUICalendar guiCalendar = new GUICalendar();
    private static TaskDescriptionTextArea taskDescriptionTextArea = new TaskDescriptionTextArea();
    private static TaskPriorityComboBox taskPriorityComboBox = new TaskPriorityComboBox();
    private static ColoredLabel coloredLabel = new ColoredLabel();
    private static StatusUpdater statusUpdater = new StatusUpdater();
    private static SecondFrame secondFrame = new SecondFrame(taskDescriptionTextArea, guiCalendar, taskPriorityComboBox,
            "SAVE", new TaskUpdateActionListener(), coloredLabel, statusUpdater);

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

    public static StatusUpdater getStatusUpdater() {
        return statusUpdater;
    }

    public static SecondFrame getSecondFrame() {
        return secondFrame;
    }
}
