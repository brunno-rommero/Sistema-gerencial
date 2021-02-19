/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.dal.ConnectionFactory;
import br.com.sgef.model.Cliente;
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
public class ClienteDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //esse método para adicionar
    public void adicionar(Cliente cliente) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nome, cidade, uf, telefone, endereco, bairro, numero)VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCidade());
            stmt.setString(3, cliente.getUf());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEndereco());
            stmt.setString(6, cliente.getBairro());
            stmt.setString(7, cliente.getNumero());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente Salvo com sucesso!");
        } catch (SQLException ex) {
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    //Método para pesquisar quando digita no campo de txtPesquisar
    public List<Cliente> read(String Pesquisar){
 
        List<Cliente> cliente = new ArrayList<>();
        
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = ("select * from cliente where nome like ?");
            pst = con.prepareStatement(sql);
            pst.setString(1, Pesquisar + "%");         
            
            rs = pst.executeQuery();

                while ( rs.next() ) {
                    Cliente cli = new Cliente();
                    cli.setId(rs.getInt(1));
                    cli.setNome(rs.getNString(2));
                    cli.setCidade(rs.getNString(3));
                    cli.setUf(rs.getNString(4));
                    cli.setTelefone(rs.getNString(5));
                    cli.setEndereco(rs.getNString(6));
                    cli.setBairro(rs.getNString(7));
                    cli.setNumero(rs.getNString(8));
                    cliente.add(cli);
                }
            con.close();
  
        } catch (Exception e) {
             e.printStackTrace();
        }

        return cliente;
   
    }
    
    public List<Cliente> read_int(String Pesquisar){
 
        List<Cliente> cliente = new ArrayList<>();
        
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = ("select * from cliente where id like ?");
            pst = con.prepareStatement(sql);
            pst.setString(1, Pesquisar + "%");         
            
            rs = pst.executeQuery();

                while ( rs.next() ) {
                    Cliente cli = new Cliente();
                    cli.setId(rs.getInt(1));
                    cli.setNome(rs.getNString(2));
                    cli.setCidade(rs.getNString(3));
                    cli.setUf(rs.getNString(4));
                    cli.setTelefone(rs.getNString(5));
                    cli.setEndereco(rs.getNString(6));
                    cli.setBairro(rs.getNString(7));
                    cli.setNumero(rs.getNString(8));
                    cliente.add(cli);
                }
            con.close();
  
        } catch (Exception e) {
             e.printStackTrace();
        }

        return cliente;
   
    }
    
    
    
    
    //Método pega id ao clicar no registro da tabela e consulta os atributos na base
    public Cliente pesquisa_por_id(Integer id){
        
        Cliente cliente = new Cliente();
        
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try {
             pst = con.prepareStatement(sql);
             pst.setInt(1, id);
             rs = pst.executeQuery();
             while ( rs.next() ) {
                  for (int i = 1; i <= 8; i++) {
                      cliente.setNome(rs.getString("nome"));
                      cliente.setCidade(rs.getString("cidade"));
                      cliente.setUf(rs.getString("uf"));
                      cliente.setTelefone(rs.getString("telefone"));
                      cliente.setEndereco(rs.getString("endereco"));
                      cliente.setBairro(rs.getString("bairro"));
                      cliente.setNumero(rs.getString("numero"));
                  }
                 
             }
  
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
   
    }
    
    //Método para alteerar o Fornecedor
    public void alterar(Cliente c) {

        Connection con = ConnectionFactory.getConnection();
        
        String sql = "update cliente set nome=?, cidade=?, uf=?, telefone=?, endereco=?, "
                   + "bairro=?, numero=? where id=?";
        try {
            pst = con.prepareStatement(sql);
          
            pst.setString(1, c.getNome());
            pst.setString(2, c.getCidade());
            pst.setString(3, c.getUf());
            pst.setString(4, c.getTelefone());
            pst.setString(5, c.getEndereco());
            pst.setString(6, c.getBairro());
            pst.setString(7, c.getNumero());
            pst.setInt(8, c.getId());
            

            int adicionado = pst.executeUpdate();
            // a linha abaixo serve como entendimento da logica.
            //System.out.println(adicionado);
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do Cliente Alterado com Sucesso !!!");
            }
            
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Método para excluir registro ao clicar em excluir
    public void excluir(Cliente cliente) {

        Connection con = ConnectionFactory.getConnection();
        String sql = "delete from cliente where id=?";
        try {
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getId());
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Cliente Removido com Sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não Excluido !!!");
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado !!!");
            e.printStackTrace();
        }
    
    }
    
}
