/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.dal.ConnectionFactory;
import br.com.sgef.model.Linha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class LinhaDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //esse método para adicionar
    public void adicionar(Linha linha) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO linha (nomeLinha) VALUES(?)");
            stmt.setString(1, linha.getDescricao());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Linha Salvo com sucesso!");
        } catch (SQLException ex) {
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    //Método para pesquisar quando digita no campo de txtPesquisar
    public List<Linha> read(String Pesquisar){
 
        List<Linha> linha = new ArrayList<>();
        
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = ("select * from linha where nomeLinha like ?");
            pst = con.prepareStatement(sql);
            pst.setString(1, Pesquisar + "%");         
            
            rs = pst.executeQuery();

                while ( rs.next() ) {
                    Linha l = new Linha();
                    l.setId(rs.getInt(1));
                    l.setDescricao(rs.getNString(2));
                    
                    linha.add(l);
                }
            con.close();
  
        } catch (Exception e) {
             e.printStackTrace();
        }

        return linha;
   
    }
    
    //Método pega id ao clicar no registro da tabela e consulta os atributos na base
    public Linha pesquisa_por_id(Integer id){
        
        Linha linha = new Linha();
        
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM linha WHERE id = ?";
        try {
             pst = con.prepareStatement(sql);
             pst.setInt(1, id);
             rs = pst.executeQuery();
             while ( rs.next() ) {
                  for (int i = 1; i <= 8; i++) {
                      linha.setId(rs.getInt("id"));
                      linha.setDescricao(rs.getString("nomeLinha"));
                  } 
             }
             con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return linha;
    }
    
    //Método para alteerar o Fornecedor
    public void alterar(Linha l) {

        Connection con = ConnectionFactory.getConnection();
        
        String sql = "update linha set nomeLinha=? where id=?";
        try {
            pst = con.prepareStatement(sql);
          
            pst.setString(1, l.getDescricao());
            pst.setInt(2, l.getId());

            int adicionado = pst.executeUpdate();
            // a linha abaixo serve como entendimento da logica.
            //System.out.println(adicionado);
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados Alterado com Sucesso !!!");
            }
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Método para excluir registro ao clicar em excluir
    public void excluir(Linha linha) {

        Connection con = ConnectionFactory.getConnection();
        String sql = "delete from linha where id=?";
        try {
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, linha.getId());
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Removido com Sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Não Excluido !!!");
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado !!!");
            e.printStackTrace();

        }
    
    }
    
    
    
}
