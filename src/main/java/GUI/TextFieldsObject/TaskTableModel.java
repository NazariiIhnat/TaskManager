package GUI.TextFieldsObject;

import TaskObject.Task;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TaskTableModel extends AbstractTableModel {
    private ArrayList<Task> listOfTasksObjects = new ArrayList<>();

    @Override
    public int getRowCount() {
        return listOfTasksObjects.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task task = listOfTasksObjects.get(rowIndex);
        switch (columnIndex){
            case 0: return task.getId();
            case 1: return task.getDate();
            case 2: return task.getTaskPriority();
            case 3: return task.getTaskPriority();
        }
        return null;
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0: return "id";
            case 1: return "description";
            case 2: return "date";
            case 3: return "priority";
        }
        return "unknown column";
    }
}
