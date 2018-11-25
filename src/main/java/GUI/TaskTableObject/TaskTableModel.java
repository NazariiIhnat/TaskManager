package GUI.TaskTableObject;

import TaskManagement.TasksSearcher;
import TaskObject.Task;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TaskTableModel extends AbstractTableModel {
    private ArrayList<Task> listOfTasks;

    TaskTableModel() {
        listOfTasks = TasksSearcher.getListOfFoundedTaskObjects();
    }

    @Override
    public int getRowCount() {
        return listOfTasks.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task task = listOfTasks.get(rowIndex);
        switch (columnIndex){
            case 0: return task.getId();
            case 1: return task.getDate();
            case 2: return task.getDescription();
            case 3: return task.getTaskPriority();
        }
        fireTableCellUpdated(rowIndex, columnIndex);
        return null;
    }

    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0: return "id";
            case 1: return "date";
            case 2: return "description";
            case 3: return "priority";
        }
        return null;
    }
}
