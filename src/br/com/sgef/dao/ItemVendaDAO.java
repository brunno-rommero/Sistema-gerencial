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
import java.sql.SQLException;

/**
 *
 * @author Bruno
 */
public class ItemVendaDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void addItVenda(ItemVenda itV) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {

            stmt = con.prepareCall("{call addItVendas(?, ?, ?, ?, ?, ?, ?)}");
            stmt.setInt(1, itV.getIdVenda());
            stmt.setInt(2, itV.getIdProduto());
            stmt.setString(3, itV.getDescProd());
            stmt.setDouble(4, itV.getQuantidade());
            stmt.setDouble(5, itV.getValorUnit());
            stmt.setDouble(6, itV.getSubtotal());
            stmt.setDouble(7, itV.getTotal());

            stmt.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
        
    }
    
}
