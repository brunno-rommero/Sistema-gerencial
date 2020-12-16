/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.dal.ConnectionFactory;
import br.com.sgef.model.Linha;
import br.com.sgef.model.Marca;
import br.com.sgef.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */



public class ProdutoDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    //Método para pegar todas as marcas e colocar no combobox
    public List<Marca> pegarTodasMarca() {
        
        List<Marca> marcas = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        try {
            stmt = con.prepareStatement("select * from marca ORDER by nomeMarca");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId(rs.getInt("id"));
                marca.setMarca(rs.getString("nomeMarca"));
                marcas.add(marca);
            }
             
        }catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return marcas;
    }
    
    //método para pegar todas as linhas cadastradas e colocar no combobox
    public List<Linha> pegarTodasLinha() {
        
        List<Linha> linhas = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        try {
            stmt = con.prepareStatement("select * from linha ORDER by nomeLinha");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Linha linha = new Linha();
                linha.setId(rs.getInt("id"));
                linha.setDescricao(rs.getString("nomeLinha"));
                linhas.add(linha);
            }
             
        }catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return linhas;
    }
    
    //esse método para adicionar
    public void adicionar(Produto produto) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produto (descricao, id_marca, id_linha, estoque, "
                    + "pcompra, pvenda) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, produto.getDescricao());
            stmt.setInt(2, produto.getId_marca());
            stmt.setInt(3, produto.getId_linha());
            stmt.setInt(4, produto.getEstoque());
            stmt.setBigDecimal(5, produto.getPcompra());
            stmt.setBigDecimal(6, produto.getPvenda());


            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto Salvo com sucesso!");
        } catch (SQLException ex) {
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    //Método para pesquisar quando digita no campo de txtPesquisar
    public List<Produto> read(String Pesquisar){
 
        List<Produto> produto = new ArrayList<>();
        
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = ("SELECT p.id, p.descricao, p.estoque, p.pcompra, p.pvenda \n" +
                            "FROM produto p\n" +
                            "INNER JOIN marca m ON p.id_marca = m.id\n" +
                            "INNER JOIN linha l ON p.id_linha = l.id \n" +
                            "WHERE p.descricao LIKE ?");
            pst = con.prepareStatement(sql);
            pst.setString(1, Pesquisar + "%");         
            
            rs = pst.executeQuery();
            NumberFormat z = NumberFormat.getCurrencyInstance();
                while ( rs.next() ) {
                    Produto prod = new Produto();
                    prod.setId(rs.getInt(1));
                    prod.setDescricao(rs.getString(2));
                    prod.setEstoque((rs.getInt(3)));
                    prod.setPcompra(rs.getBigDecimal(4));
                    prod.setPvenda(rs.getBigDecimal(5));
                    
                    produto.add(prod);
                }
            con.close();
  
        } catch (Exception e) {
             e.printStackTrace();
        }

        return produto;
   
    }
    
    //Método para excluir registro ao clicar em excluir
    public void excluir(Produto produto) {

        Connection con = ConnectionFactory.getConnection();
        String sql = "delete from produto where id=?";
        try {
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, produto.getId());
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Produto Removido com Sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Produto não Excluido !!!");
            }
            
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo deu errado !!!");
            e.printStackTrace();

        }

    }
    
    //Método pega id ao clicar no registro da tabela e consulta os atributos na base
    public Produto pesquisa_por_id(Integer id){
        
        Produto produto = new Produto();
        Linha linha = new Linha();
        LinhaDAO daoLinha = new LinhaDAO();
        
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT p.id, p.descricao, p.id_marca, m.nomeMarca, p.id_linha, "+
                        "l.nomeLinha, p.estoque, p.pcompra, p.pvenda\n" +
                        "FROM produto p\n" +
                        "INNER JOIN marca m ON p.id_marca = m.id\n" +
                        "INNER JOIN linha l ON p.id_linha = l.id \n" +
                        "WHERE p.id = ?";
        try {
             pst = con.prepareStatement(sql);
             pst.setInt(1, id);
             rs = pst.executeQuery();
             
             NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
             
             while ( rs.next() ) {
                    for (int i = 1; i <= 6; i++) {
                      
                      produto.setDescricao(rs.getString("p.descricao"));
                      produto.setId_linha(rs.getInt("p.id_linha"));
                      produto.setId_marca(rs.getInt("p.id_marca"));
                      produto.setEstoque(Integer.parseInt(rs.getString("p.estoque")));
                      produto.setPcompra(rs.getBigDecimal("p.pcompra"));
                      produto.setPvenda(rs.getBigDecimal("p.pvenda"));
 
                    }
    
             }
             con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produto;
   
    }
    
    //Método para alteerar o Fornecedor
    public void alterar(Produto p) {

        Connection con = ConnectionFactory.getConnection();
        
        String sql = "update produto set descricao=?, id_marca=?, id_linha=?, estoque=?, pcompra=?, "
                   + "pvenda=? where id=?";
        try {
            pst = con.prepareStatement(sql);
          
            pst.setString(1, p.getDescricao());
            pst.setInt(2, p.getId_marca());
            pst.setInt(3, p.getId_linha());
            pst.setInt(4, p.getEstoque());
            pst.setBigDecimal(5, p.getPcompra());
            pst.setBigDecimal(6, p.getPvenda());
            pst.setInt(7, p.getId());
            
            System.out.println("Compra:" + p.getPcompra());
            

            int adicionado = pst.executeUpdate();
            // a linha abaixo serve como entendimento da logica.
            //System.out.println(adicionado);
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do Produto Alterado com Sucesso !!!");
            }
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}