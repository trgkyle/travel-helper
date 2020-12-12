/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VTableModel;

import Model.TapLoaiSuKien;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Truong-kyle
 */
public class TapLoaiSuKienTableModel extends AbstractTableModel {

    private ArrayList<TapLoaiSuKien> tapSuKiens;

    private final String[] columnNames = new String[]{
        "Mã sự kiện", "Nội dung"
    };

    public void setModel(ArrayList<TapLoaiSuKien> tapSuKiens) {
        this.tapSuKiens = tapSuKiens;
    }

    public TapLoaiSuKienTableModel(ArrayList<TapLoaiSuKien> tapSuKiens) {
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
            TapLoaiSuKien row = tapSuKiens.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return row.getEventTypeID();
                case 1:
                    return row.getName();
            }
        } catch (Exception e) {
        }

        return null;
    }
}
