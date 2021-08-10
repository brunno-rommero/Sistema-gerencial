/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.model.Marca;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class MarcaComboModelDAO extends AbstractListModel implements ComboBoxModel{
    
    private List<Marca> listaMarca;
    private Marca marcaSelecionada;
    
    public MarcaComboModelDAO(){
        this.listaMarca = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return listaMarca.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.listaMarca.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if(anItem instanceof Marca){
            this.marcaSelecionada = (Marca) anItem;
            fireContentsChanged(this.listaMarca, 0, this.listaMarca.size());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.marcaSelecionada;
    }
    
    public void addMarcas(Marca marca){
        this.listaMarca.add(marca);
    }
    
    public void reset(){
        this.listaMarca.clear();
    } 
    
}
