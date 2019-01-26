package GUI.TaskAddingComponents.SecondFrameComponents;

import GUI.MainValueReaders.*;

public class MainAddingComponents {
    private static GUICalendar guiCalendar = new GUICalendar();
    private static DescriptionTextArea descriptionTextArea = new DescriptionTextArea();
    private static PriorityComboBox priorityComboBox = new PriorityComboBox();
    private static ColoredLabel coloredLabel = new ColoredLabel();
    private static SecondFrame secondFrame = new SecondFrame("Add", descriptionTextArea, guiCalendar,
            priorityComboBox, "ADD", new TaskAddActionListener(), coloredLabel);

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

    static DescriptionTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    static PriorityComboBox getPriorityComboBox() {
        return priorityComboBox;
    }

    static ColoredLabel getColoredLabel() {
        return coloredLabel;
    }

    public static SecondFrame getSecondFrame() {
        return secondFrame;
    }
}
