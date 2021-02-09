/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.dal.ConnectionFactory;
import br.com.sgef.model.MovVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class MovVendaDAO {
    
    
    //Método para pesquisar quando digita no campo de txtPesquisar
    public List<MovVenda> read(MovVenda venda){
 
        List<MovVenda> movVenda = new ArrayList<>();
        
        try {
            Connection con = ConnectionFactory.getConnection();
            
            if(venda.getFormPag() == "Todos"){
                String sql = ("SELECT id, dataVenda, formaPag, valorTotal FROM venda \n" +
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
                    mv.setFormPag(rs.getString(3));
                    mv.setVlrTotal(rs.getDouble(4));
                    
                    movVenda.add(mv);
                }
                
                
                
            }else{
                String sql = ("SELECT id, dataVenda, formaPag, valorTotal FROM venda \n" +
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
                    mv.setFormPag(rs.getString(3));
                    mv.setVlrTotal(rs.getDouble(4));
                    
                    movVenda.add(mv);
                }
                
            }
               
            con.close();
  
        } catch (Exception e) {
             e.printStackTrace();
        }

        return movVenda;
   
    }
    
    
    
}
