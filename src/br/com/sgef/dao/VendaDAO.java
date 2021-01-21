/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.dal.ConnectionFactory;
import br.com.sgef.model.Produto;
import br.com.sgef.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class VendaDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //esse método para adicionar
    public void adicionar(Venda venda) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO venda ( id_cliente, qtd_item, dataVenda, formaPag, " +
                                        "valorTotal)\n" +
                                        "VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, venda.getCliente());
            stmt.setDouble(2, venda.getQtd_item());
            stmt.setDate(3, venda.getDataVenda());
            stmt.setString(4, venda.getFormaPagamento());
            stmt.setDouble(5, venda.getValorTotal());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
        } catch (SQLException ex) {
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }


}
