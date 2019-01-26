package GUI.TaskTableObject;

import Database.TaskManagement.TasksSearcher;
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
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task task = listOfTasks.get(rowIndex);
        switch (columnIndex){
            case 0: return task.getId();
            case 1: return task.getDate();
            case 2: return task.getDescription();
            case 3: return task.getTaskPriority();
            case 4: return task.getStatus();
        }
        return null;
    }

    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0: return "id";
            case 1: return "date";
            case 2: return "description";
            case 3: return "priority";
            case 4: return "status";
        }
        return null;
    }
}
