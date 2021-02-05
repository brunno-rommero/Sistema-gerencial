/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class UserComboModelDAO extends AbstractListModel implements ComboBoxModel{
    
    private List<User> listaUser;
    private User  userSelecionada;
    
    public UserComboModelDAO(){
        this.listaUser = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return listaUser.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.listaUser.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if(anItem instanceof User){
            this.userSelecionada = (User) anItem;
            fireContentsChanged(this.listaUser, 0, this.listaUser.size());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.userSelecionada;
    }
    
    public void addUsers(User user){
        this.listaUser.add(user);
    }
    
    public void reset(){
        this.listaUser.clear();
    } 
    
}
