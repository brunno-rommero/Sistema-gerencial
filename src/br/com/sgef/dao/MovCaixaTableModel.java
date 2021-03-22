/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.model.MovCaixa;
import br.com.sgef.util.FormatRenderer;
import br.com.sgef.util.NumberRenderer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Bruno
 */
public class MovCaixaTableModel extends AbstractTableModel{
    
    private List<MovCaixa> dados = new ArrayList<>();
    private String[] colunas = {"Código", "Caixa", "Venda", "Usuário", "Data", "Tipo", "Origem", "Form Pag", "Valor"};

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
                return dados.get(linha).getMovCaixa();
            case 1:
                return dados.get(linha).getId_caixa();
            case 2:
                return dados.get(linha).getId_venda();
            case 3:
                return dados.get(linha).getIdUser();    
            case 4:
                return dados.get(linha).getDataMov();
            case 5:
                return dados.get(linha).getTipo();
            case 6:
                return dados.get(linha).getOrigemMov();
            case 7:
                return dados.get(linha).getFormPag();
            case 8:
                return dados.get(linha).getValor();
        }
        
        return null;
    }
    
    public void addRow(MovCaixa mCx){
        this.dados.add(mCx);
        this.fireTableDataChanged();
    }
    
    public void removeRow (int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void setTableColumnModel(TableColumnModel columnModel){
        
        
        //columnModel.getColumn(2).setCellRenderer(NumberRenderer.getNumberRenderer(0));
        columnModel.getColumn(4).setCellRenderer(FormatRenderer.getDateRenderer());
        columnModel.getColumn(8).setCellRenderer(NumberRenderer.getCurrencyRenderer());
        
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(120);
        columnModel.getColumn(6).setPreferredWidth(150);
        columnModel.getColumn(7).setPreferredWidth(180);
        columnModel.getColumn(8).setPreferredWidth(150);
        
    }
    
    public String CalculaTotal() {
        
        Double soma = 0.0;
        for ( int i = 0; i < this.getRowCount(); i++){
            soma += Double.parseDouble( this.getValueAt(i, 8).toString());
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
