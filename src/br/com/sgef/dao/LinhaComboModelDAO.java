/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.model.Linha;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class LinhaComboModelDAO extends AbstractListModel implements ComboBoxModel{
    
    private List<Linha> listaLinha;
    private Linha linhaSelecionada;
    
    public LinhaComboModelDAO(){
        this.listaLinha = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return listaLinha.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.listaLinha.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if(anItem instanceof Linha){
            this.linhaSelecionada = (Linha) anItem;
            fireContentsChanged(this.listaLinha, 0, this.listaLinha.size());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.linhaSelecionada;
    }
    
    public void addLinhas(Linha linha){
        this.listaLinha.add(linha);
    }
    
    public void reset(){
        this.listaLinha.clear();
    } 
    
}
