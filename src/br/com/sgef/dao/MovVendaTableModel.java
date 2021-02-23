/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;


import br.com.sgef.model.MovVenda;
import br.com.sgef.util.NumberRenderer;
import br.com.sgef.util.FormatRenderer;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.text.TableView.TableRow;

/**
 *
 * @author Bruno
 */
public class MovVendaTableModel extends AbstractTableModel{
    
    private List<MovVenda> dados = new ArrayList<>();
    private String[] colunas = {"Código", "Data", "Situação", "Forma pagamento", "Total"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return dados.get(linha).getIdVenda();
            case 1:
                return dados.get(linha).getDataVenda();
            case 2:
                return dados.get(linha).getSituacao();    
            case 3:
                return dados.get(linha).getFormPag();
            case 4:
                return dados.get(linha).getVlrTotal();
           
        }
        
        return null;
    }
    
    public void addRow(MovVenda Mvenda){
        this.dados.add(Mvenda);
        this.fireTableDataChanged();  
        
    }
    
    public void removeRow (int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    public void updateRow(){
        this.fireTableCellUpdated(0, 2);
    }
    
    public void setTableColumnModel(TableColumnModel columnModel){
        
        
        columnModel.getColumn(1).setCellRenderer(FormatRenderer.getDateRenderer());
        columnModel.getColumn(4).setCellRenderer(NumberRenderer.getCurrencyRenderer());
        
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(2).setPreferredWidth(80);
   
    }


}
