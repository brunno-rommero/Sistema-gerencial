/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.dal.ConnectionFactory;
import br.com.sgef.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author BrunoRomeroAlencar
 */
public class FornecedorDAO {
    
        Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

    //esse método esta em usso
    public void adicionar(Fornecedor f) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO fornecedor (fornecedor, cidade, uf, telefone, endereco, bairro, numero)VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, f.getFornecedor());
            stmt.setString(2, f.getCidade());
            stmt.setString(3, f.getUf());
            stmt.setString(4, f.getTelefone());
            stmt.setString(5, f.getEndereco());
            stmt.setString(6, f.getBairro());
            stmt.setString(7, f.getNumero());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Fornecedor Salvo com sucesso!");
        } catch (SQLException ex) {
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    //Método para pesquisar quando digita no campo de txtPesquisar
    public List<Fornecedor> read(String Pesquisar){
 
        List<Fornecedor> fornecedor = new ArrayList<>();
        
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = ("select * from fornecedor where fornecedor like ?");
            pst = con.prepareStatement(sql);
            pst.setString(1, Pesquisar + "%");         
            
            rs = pst.executeQuery();

                while ( rs.next() ) {
                    Fornecedor forn = new Fornecedor();
                    forn.setId(rs.getInt(1));
                    forn.setFornecedor(rs.getNString(2));
                    forn.setCidade(rs.getNString(3));
                    forn.setUf(rs.getNString(4));
                    forn.setTelefone(rs.getNString(5));
                    forn.setEndereco(rs.getNString(6));
                    forn.setBairro(rs.getNString(7));
                    forn.setNumero(rs.getNString(8));
                    fornecedor.add(forn);
                }
            con.close();
  
        } catch (Exception e) {
             e.printStackTrace();
        }

        return fornecedor;
   
    }
    
    //Método para alteerar o Fornecedor
    public void alterar(Fornecedor f) {

        Connection con = ConnectionFactory.getConnection();
        
        String sql = "update fornecedor set fornecedor=?, cidade=?, uf=?, telefone=?, endereco=?, "
                   + "bairro=?, numero=? where id=?";
        try {
            pst = con.prepareStatement(sql);
          
            pst.setString(1, f.getFornecedor());
            pst.setString(2, f.getCidade());
            pst.setString(3, f.getUf());
            pst.setString(4, f.getTelefone());
            pst.setString(5, f.getEndereco());
            pst.setString(6, f.getBairro());
            pst.setString(7, f.getNumero());
            pst.setInt(8, f.getId());
            

            int adicionado = pst.executeUpdate();
            // a linha abaixo serve como entendimento da logica.
            //System.out.println(adicionado);
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do Fornecedor Alterado com Sucesso !!!");
            }
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Método pega id ao clicar no registro da tabela e consulta os atributos na base
    public Fornecedor pesquisa_por_id(Integer id){
        
        Fornecedor fornecedor = new Fornecedor();
        
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM fornecedor WHERE id = ?";
        try {
             pst = con.prepareStatement(sql);
             pst.setInt(1, id);
             rs = pst.executeQuery();
             while ( rs.next() ) {
                  for (int i = 1; i <= 8; i++) {
                      fornecedor.setFornecedor(rs.getString("fornecedor"));
                      fornecedor.setCidade(rs.getString("cidade"));
                      fornecedor.setUf(rs.getString("uf"));
                      fornecedor.setTelefone(rs.getString("telefone"));
                      fornecedor.setEndereco(rs.getString("endereco"));
                      fornecedor.setBairro(rs.getString("bairro"));
                      fornecedor.setNumero(rs.getString("numero"));
                  }
                 
             }
  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fornecedor;
   
    }
    
    //Método para excluir registro ao clicar em excluir
    public void excluir(Fornecedor fornecedor) {

        Connection con = ConnectionFactory.getConnection();
        String sql = "delete from fornecedor where id=?";
        try {
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, fornecedor.getId());
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Fornecedor Removido com Sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Fornecedor não Excluido !!!");
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado !!!");
            e.printStackTrace();

        }
    }
}