/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VTableModel;

import Model.TapLuat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Truong-kyle
 */
public class TapLuatTableModel extends AbstractTableModel {

    private ArrayList<TapLuat> tapLuats;

    private final String[] columnNames = new String[]{
        "Mã Luật", "Nội dung"
    };

    public void setModel(ArrayList<TapLuat> tapLuats) {
        this.tapLuats = tapLuats;
    }

    public TapLuatTableModel(ArrayList<TapLuat> tapLuats) {
        this.tapLuats = tapLuats;
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
        return tapLuats.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            TapLuat row = tapLuats.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return row.getRuleID();
                case 1:
                    return row.getContent();
            }
        } catch (Exception e) {
        }

        return null;
    }
}
