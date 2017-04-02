/*
 * Created by JFormDesigner on Tue Mar 28 14:58:28 PDT 2017
 */

package com.k4ch0w.pwnback;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;

/**
 * @author unknown
 */
public class PwnBackTable extends AbstractTableModel {

    private final PwnBackMediator mediator;
    private final int columnCount = 2;
    JTable logTable = new JTable(this);

    public PwnBackTable(PwnBackMediator mediator) {
        this.mediator = mediator;
    }

    public JTable getLogTable() {
        return logTable;
    }

    public void notifyUpdate() {
        int row = mediator.getLog().size();
        fireTableRowsInserted(row, row);
    }

    @Override
    public int getRowCount() {
        return mediator.getLog().size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Path";
            case 1:
                return "Found at";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PwnBackTableEntry logEntry = mediator.getLog().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return logEntry.getPath();
            case 1:
                return logEntry.getUrlFoundAt();
            default:
                return "";
        }
    }

}