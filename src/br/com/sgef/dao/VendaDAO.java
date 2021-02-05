/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.dal.ConnectionFactory;
import br.com.sgef.model.ItemVenda;
import br.com.sgef.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

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

            stmt = con.prepareCall("{call addVenda(?, ?, ?, ?, ?, ?)}"); // ?, ?, ?, ? stored procedure addVenda adc itens tbm
            stmt.setInt(1, venda.getCliente());
            stmt.setInt(2, venda.getUsuario());
            stmt.setDouble(3, venda.getQtd_item());
            stmt.setDate(4, venda.getDataVenda());
            stmt.setString(5, venda.getFormaPagamento());
            stmt.setDouble(6, venda.getValorTotal());
            

            stmt.execute();

            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public int pegaIdVenda(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        Venda venda = new Venda();
        int Cod = 0;
        
        try {
            stmt = con.prepareStatement("SELECT AUTO_INCREMENT FROM information_schema.tables\n" +
                                        "WHERE TABLE_NAME = 'venda' AND table_schema = 'sist'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                venda.setId(rs.getInt("AUTO_INCREMENT"));  
                Cod = venda.getId();
            }
            
            
        }catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return Cod;
        
    }
    
    public void abrirListaProd(int venda){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja imprimir lista de produtos ?", "Atenção", JOptionPane.YES_NO_OPTION);
         if (confirma == JOptionPane.YES_OPTION) {
            try {
                Map parameters = new HashMap(); 
                parameters.put("IdVenda", venda);
                JasperPrint print = JasperFillManager.fillReport("C:/Users/Bruno/Desktop/BKP/Documentos/NetBeansProjects/SGEF/Relatorios/ListaVenda.jasper", parameters, con);
                JasperViewer.viewReport(print, false);
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
         }
        
    }


}
