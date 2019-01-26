package GUI.TaskUpdatingComponents.SecondFrameComponents;

import GUI.MainFrame.Frame;
import GUI.MainValueReaders.*;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainUpdatingComponents {
    private static GUICalendar guiCalendar = new GUICalendar();
    private static DescriptionTextArea descriptionTextArea = new DescriptionTextArea();
    private static PriorityComboBox priorityComboBox = new PriorityComboBox();
    private static ColoredLabel coloredLabel = new ColoredLabel();
    private static StatusUpdater statusUpdater = new StatusUpdater();
    private static SecondFrame secondFrame = new SecondFrame("Update", descriptionTextArea, guiCalendar,
            priorityComboBox, "SAVE", new TaskUpdateSaveActionListener(), coloredLabel, statusUpdater);

    static {
        setGUICalendarParameters();
        secondFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        secondFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
                Frame.alwaysOnTop(true);
                Frame.setEnabled(true);
                Frame.alwaysOnTop(false);
            }
        });
    }

    private static void setGUICalendarParameters() {
        getGuiCalendar().enableToChoosePastDays(false);
        getGuiCalendar().enableDateEdition(false);
        getGuiCalendar().enableSingleIntervalSelection(false);
    }

    public static GUICalendar getGuiCalendar() {
        return guiCalendar;
    }

    public static DescriptionTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public static PriorityComboBox getPriorityComboBox() {
        return priorityComboBox;
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
