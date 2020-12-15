/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VTableModel;

import Model.TapSuKien;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Truong-kyle
 */
public class TapSuKienSelectedTableModel extends AbstractTableModel {

    private ArrayList<TapSuKien> tapSuKiens;

    private final String[] columnNames = new String[]{
        "Sự kiện","Loại sự kiện"
    };

    public void setModel(ArrayList<TapSuKien> tapSuKiens) {
        this.tapSuKiens = tapSuKiens;
    }

    public TapSuKienSelectedTableModel(ArrayList<TapSuKien> tapSuKiens) {
        this.tapSuKiens = tapSuKiens;
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
        return tapSuKiens.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            TapSuKien row = tapSuKiens.get(rowIndex);

            switch (columnIndex) {
//                case 0:
//                    return (char) (64 + row.getEventTypeID()) + "" + row.getEventID();
                case 0:
                    return row.getValue();
                case 1:
                    return row.getEventTypeName();
            }
        } catch (Exception e) {
        }

        return null;
    }
}
