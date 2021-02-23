/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.dal.ConnectionFactory;
import br.com.sgef.model.ItemVenda;
import br.com.sgef.model.MovVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class MovVendaDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //Método para pesquisar quando digita no campo de txtPesquisar
    public List<MovVenda> read(MovVenda venda){
 
        List<MovVenda> movVenda = new ArrayList<>();
        
        try {
            Connection con = ConnectionFactory.getConnection();
            
            if((venda.getFormPag() == "Todos") && (venda.getUsuario() == 0)){
                
                String sql = ("SELECT id, dataVenda, situacao, formaPag, valorTotal FROM venda \n" +
                              "WHERE dataVenda BETWEEN ? AND ?");
                            
                PreparedStatement pst = con.prepareStatement(sql); 
                pst.setDate(1, venda.getDataInicial()); 
                pst.setDate(2, venda.getDatafinal()); 
                ResultSet rs = pst.executeQuery();
                
                while ( rs.next() ) {
                    MovVenda mv = new MovVenda();
                    mv.setIdVenda(rs.getInt(1));
                    mv.setDataVenda(rs.getDate(2));
                    mv.setSituacao(rs.getString(3));
                    mv.setFormPag(rs.getString(4));
                    mv.setVlrTotal(rs.getDouble(5));
                    
                    movVenda.add(mv);
                }
                
                
            }
            
            
            if(venda.getFormPag() == "Todos"){
                String sql = ("SELECT id, dataVenda, situacao, formaPag, valorTotal FROM venda \n" +
                            "WHERE id_usuario = ? AND\n" +
                            "dataVenda BETWEEN ? AND ?");
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, venda.getUsuario());  
                pst.setDate(2, venda.getDataInicial()); 
                pst.setDate(3, venda.getDatafinal()); 
                ResultSet rs = pst.executeQuery();
                
                while ( rs.next() ) {
                    MovVenda mv = new MovVenda();
                    mv.setIdVenda(rs.getInt(1));
                    mv.setDataVenda(rs.getDate(2));
                    mv.setSituacao(rs.getString(3));
                    mv.setFormPag(rs.getString(4));
                    mv.setVlrTotal(rs.getDouble(5));
                    
                    movVenda.add(mv);
                }
                
                
                
            }
            if(venda.getUsuario() == 0){
                String sql = ("SELECT id, dataVenda, situacao, formaPag, valorTotal FROM venda \n" +
                            "WHERE formaPag = ? AND\n" +
                            "dataVenda BETWEEN ? AND ?");
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, venda.getFormPag());  
                pst.setDate(2, venda.getDataInicial()); 
                pst.setDate(3, venda.getDatafinal()); 
                ResultSet rs = pst.executeQuery();
                
                while ( rs.next() ) {
                    MovVenda mv = new MovVenda();
                    mv.setIdVenda(rs.getInt(1));
                    mv.setDataVenda(rs.getDate(2));
                    mv.setSituacao(rs.getString(3));
                    mv.setFormPag(rs.getString(4));
                    mv.setVlrTotal(rs.getDouble(5));
                    
                    movVenda.add(mv);
                }
                
                
                
            }
            
            
            else{
                String sql = ("SELECT id, dataVenda, situacao, formaPag, valorTotal FROM venda \n" +
                                "WHERE id_usuario = ? AND\n" +
                                "formaPag = ? AND\n" +
                                "dataVenda BETWEEN ? AND ?");
            
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, venda.getUsuario());  
                pst.setString(2, venda.getFormPag()); 
                pst.setDate(3, venda.getDataInicial()); 
                pst.setDate(4, venda.getDatafinal()); 
                ResultSet rs = pst.executeQuery();
                
                 while ( rs.next() ) {
                    MovVenda mv = new MovVenda();
                    mv.setIdVenda(rs.getInt(1));
                    mv.setDataVenda(rs.getDate(2));
                    mv.setSituacao(rs.getString(3));
                    mv.setFormPag(rs.getString(4));
                    mv.setVlrTotal(rs.getDouble(5));
                    
                    movVenda.add(mv);
                }
                
            }
               
            con.close();
  
        } catch (Exception e) {
             e.printStackTrace();
        }

        return movVenda;
   
    }
    
    //ao clicar em cancelar no mov venda cancela venda
    public void cancelaVenda(int codVenda){
        
        Connection con = ConnectionFactory.getConnection();
        
        String sql = "{CALL cancVenda(?)}";
                     
        if(codVenda == 0){
            JOptionPane.showMessageDialog(null, "Selecione uma venda para Cancelar.");   
        }
        try {
            pst = con.prepareStatement(sql);
             
            pst.setInt(1, codVenda);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venda Cancelada com Sucesso!");
             
             
             
        } catch (Exception e) {
        }
  
    }
    
    //ao clicar em cancelar no mov venda Estorna os produtos para o estoque
    public void cancelaProdutos(int codVenda){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "SELECT id_produto, quantidade FROM itvenda WHERE id_venda = ?";
                     
        JOptionPane.showMessageDialog(null, "Os produtos da venda será estornado para o Estoque !!!");
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, codVenda);
            pst.executeQuery();
            ResultSet rs = pst.executeQuery();
            while ( rs.next() ) {
                try {
                    stmt = con.prepareCall("{call entradaEstoque(?, ?)}");
                    stmt.setInt(1, rs.getInt("id_produto"));
                    stmt.setInt(2, rs.getInt("quantidade"));
                    stmt.execute(); 
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
