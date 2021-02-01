/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.model.ItemVenda;
import br.com.sgef.util.NumberRenderer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Bruno
 */
public class VendaTableModel extends AbstractTableModel{
    
    private List<ItemVenda> dados = new ArrayList<>();
    private String[] colunas = {"Código", "Descrição", "QTD", "Valor Unit.", "Subtotal"};

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
                return dados.get(linha).getIdProduto();
            case 1:
                return dados.get(linha).getDescProd();
            case 2:
                return dados.get(linha).getQuantidade();
            case 3:
                return dados.get(linha).getValorUnit();
            case 4:
                return dados.get(linha).getSubtotal();
        }
        
        return null;
    }
    
    public void addRow(ItemVenda itV){
        this.dados.add(itV);
        this.fireTableDataChanged();
    }
    
    public void removeRow (int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void setTableColumnModel(TableColumnModel columnModel){
        
        
        //columnModel.getColumn(2).setCellRenderer(NumberRenderer.getNumberRenderer(0));
        columnModel.getColumn(3).setCellRenderer(NumberRenderer.getCurrencyRenderer());
        columnModel.getColumn(4).setCellRenderer(NumberRenderer.getCurrencyRenderer());
        
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(350);
        
    }
    
    public String CalculaTotal() {
        
        Double soma = 0.0;
        for ( int i = 0; i < this.getRowCount(); i++){
            soma += Double.parseDouble( this.getValueAt(i, 4).toString());
        }
       
        return soma.toString();
    }
    public String CalculaQtd() {
        
       Double soma = 0.0;
        for ( int i = 0; i < this.getRowCount(); i++){
            soma += Double.parseDouble( this.getValueAt(i, 2).toString());
        }
       
        return soma.toString();
    }
    
    
}
