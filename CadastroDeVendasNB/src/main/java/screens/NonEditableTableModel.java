/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

/**
 *
 * @author marco
 */

import javax.swing.table.DefaultTableModel;

public class NonEditableTableModel extends DefaultTableModel {
    
    private boolean editable = false;

    
    public NonEditableTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return editable;  // retorna true ou false com base no estado do campo editable
    }

    public void setCellEditable(boolean editable) {
        this.editable = editable;  // define se a tabela pode ou não ser editada
        fireTableDataChanged();  // informa à JTable que o modelo foi atualizado
    }
    

    
    
    
    
    
}