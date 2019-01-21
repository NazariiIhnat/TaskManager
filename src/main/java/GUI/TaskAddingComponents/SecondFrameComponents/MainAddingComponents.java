package GUI.TaskAddingComponents.SecondFrameComponents;

import GUI.MainGUIComponents.*;

public class MainAddingComponents {
    private static GUICalendar guiCalendar = new GUICalendar();
    private static TaskDescriptionTextArea taskDescriptionTextArea = new TaskDescriptionTextArea();
    private static TaskPriorityComboBox taskPriorityComboBox = new TaskPriorityComboBox();
    private static ColoredLabel coloredLabel = new ColoredLabel();
    private static SecondFrame secondFrame = new SecondFrame(taskDescriptionTextArea, guiCalendar, taskPriorityComboBox,
            "ADD", new TaskAddActionListener(), coloredLabel);

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

    static TaskDescriptionTextArea getTaskDescriptionTextArea() {
        return taskDescriptionTextArea;
    }

    static TaskPriorityComboBox getTaskPriorityComboBox() {
        return taskPriorityComboBox;
    }

    static ColoredLabel getColoredLabel() {
        return coloredLabel;
    }

    public static SecondFrame getSecondFrame() {
        return secondFrame;
    }
}
