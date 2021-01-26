/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.dal.ConnectionFactory;
import br.com.sgef.model.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Bruno
 */
public class ItemVendaDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void addItVenda(ItemVenda itVenda) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        
        
        
    }
    
}
