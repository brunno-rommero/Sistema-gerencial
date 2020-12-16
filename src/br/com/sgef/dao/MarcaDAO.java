/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.dal.ConnectionFactory;
import br.com.sgef.model.Marca;
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
public class MarcaDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //esse método para adicionar
    public void adicionar(Marca marca) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO marca (nomeMarca)VALUES(?)");
            stmt.setString(1, marca.getMarca());
            

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Marca Salvo com sucesso!");
        } catch (SQLException ex) {
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    //Método para pesquisar quando digita no campo de txtPesquisar
    public List<Marca> read(String Pesquisar){
 
        List<Marca> marca = new ArrayList<>();
        
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = ("select * from marca where nomeMarca like ?");
            pst = con.prepareStatement(sql);
            pst.setString(1, Pesquisar + "%");         
            
            rs = pst.executeQuery();

                while ( rs.next() ) {
                    Marca m = new Marca();
                    m.setId(rs.getInt(1));
                    m.setMarca(rs.getNString(2));
                    
                    marca.add(m);
                }
            con.close();
  
        } catch (Exception e) {
             e.printStackTrace();
        }

        return marca;
   
    }
    
    //Método pega id ao clicar no registro da tabela e consulta os atributos na base
    public Marca pesquisa_por_id(Integer id){
        
        Marca marca = new Marca();
        
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM marca WHERE id = ?";
        try {
             pst = con.prepareStatement(sql);
             pst.setInt(1, id);
             rs = pst.executeQuery();
             while ( rs.next() ) {
                  for (int i = 1; i <= 8; i++) {
                      marca.setId(rs.getInt("id"));
                      marca.setMarca(rs.getString("nomeMarca"));
                  } 
             }
             con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return marca;
    }
    
    //Método para alteerar o Fornecedor
    public void alterar(Marca m) {

        Connection con = ConnectionFactory.getConnection();
        
        String sql = "update marca set nomeMarca=? where id=?";
        try {
            pst = con.prepareStatement(sql);
          
            pst.setString(1, m.getMarca());
            pst.setInt(2, m.getId());

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
    public void excluir(Marca marca) {

        Connection con = ConnectionFactory.getConnection();
        String sql = "delete from marca where id=?";
        try {
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, marca.getId());
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
