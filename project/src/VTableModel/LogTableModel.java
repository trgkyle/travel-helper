/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VTableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Truong-kyle
 */
public class LogTableModel extends AbstractTableModel {

    private ArrayList<String> tapLog;

    private final String[] columnNames = new String[]{
        "Log"
    };

    public void setModel(ArrayList<String> tapLog) {
        this.tapLog = tapLog;
    }

    public LogTableModel(ArrayList<String> tapLog) {
        this.tapLog = tapLog;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return tapLog.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            String row = tapLog.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return row;
            }
        } catch (Exception e) {
        }

        return null;
    }
}
