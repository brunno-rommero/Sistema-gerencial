/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.dal.ConnectionFactory;
import br.com.sgef.model.User;
import br.com.sgef.telas.TelaCadUser;
import br.com.sgef.telas.TelaLogin;
import br.com.sgef.telas.TelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Bruno
 */
public class UserDAO {
    
    Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/*
	 * esse médoto busca o usuário por id é passado o id por parametro feito a busca
	 * no sql colocado o resultado no rs e setado para cada atributo do objeto user
	 * Lembrar de fazer quando o nome passado por parametro for igual ao do DB, vai
	 * precisar para fazer login
	 */
        
    public List<String> pegarTodosUser(User user) {
            List<String> listaUser = new ArrayList<String>();
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            try {
                stmt = con.prepareStatement("select * from user ORDER by nome");
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                        user.setId(rs.getInt(1));
                        user.setNome(rs.getString(2));
                        user.setUsuario(rs.getString(3));
                        user.setSenha(rs.getString(4));
                        listaUser.add(user.getUsuario());

                }

            } catch (Exception e) {
                    System.out.println(e);
            } finally {
                    ConnectionFactory.closeConnection(con, stmt);
            }
            return listaUser;

    }
        
        //============================================================
        
    public void pesquisar_usuario(String Pesquisar) {


        TelaCadUser telaCadUser = new TelaCadUser();  
        Connection con = ConnectionFactory.getConnection();
        //PreparedStatement stmt = null;
        String sql = ("select id as Cód, nome as Nome, usuario as Login, senha as Senha, perfilUser as Perfil from user where nome like ?");

        try {

            pst = con.prepareStatement(sql);

            //JOptionPane.showMessageDialog(null, Pesquisar);
            //passando o conteudo da caixa de texto para o --> ?
            //atemcao ao porcentagem % que é a continuação do SQL
            pst.setString(1, Pesquisar + "%");         

            rs = pst.executeQuery();

            if(rs.next()){
            rs.previous();
                while ( rs.next() ) {

                    User user = new User();
                    user.setId(rs.getInt("Cód"));
                    user.setNome(rs.getString("Nome"));
                    user.setUsuario(rs.getString("Login"));
                    user.setSenha(rs.getString("Senha"));
                    user.setperfilUser(rs.getString("Perfil"));

                }

            }else{
                JOptionPane.showMessageDialog(null, "Nenhum usuário encontrado !");
            }


            //tblUser.getColumnModel().getColumn(0).setMaxWidth(40);




        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
            //JOptionPane.showMessageDialog(null, Pesquisar);

        }


    }
        
    public List<User> read(String Pesquisar){
        
        TelaCadUser telaCadUser = new TelaCadUser();
        List<User> users = new ArrayList<>();
        
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = ("select id as Cód, nome as Nome, usuario as Login, senha as Senha, perfilUser as Perfil from user where nome like ?");
            pst = con.prepareStatement(sql);
            pst.setString(1, Pesquisar + "%");         
            
            rs = pst.executeQuery();

                while ( rs.next() ) {
                    User user = new User();
                    user.setId(rs.getInt("Cód"));
                    user.setNome(rs.getString("Nome"));
                    user.setUsuario(rs.getString("Login"));
                    user.setSenha(rs.getString("Senha"));
                    user.setperfilUser(rs.getString("Perfil"));
                    users.add(user);
                }
            con.close();
  
        } catch (Exception e) {
             e.printStackTrace();
        }

        return users;
   
    }
    
    public void adicionar(User u) {
        
        Connection con = ConnectionFactory.getConnection();
        TelaCadUser telaCadUser = new TelaCadUser();
        User user = new User();
        
        String sql = ("insert into user (nome, usuario, senha, perfilUser) values(?,?,?,?)");
        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, u.getNome());
            pst.setString(2, u.getUsuario());
            pst.setString(3, u.getSenha());
            pst.setString(4, u.getperilUser());
            // Capturar o Texto do Combobox "obs converter para String
            //pst.setString(4, telaCadUser.comboboxPerfilUser.getSelectedItem().toString());
            // validação dos campos obrigatórios
            
            if ((u.getNome().isEmpty()) || (u.getUsuario().isEmpty()) || (u.getSenha().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios (*)");
                
            } else {

                // a linha abaixo atualiza a tabela de Usuarios com os dados do Formulário
                // a estrutura abaixo é usada para confirmar a inserção de dados na tabel
                int adicionado = pst.executeUpdate();
                // a linha abaixo serve como entendimento da logica.
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário Adicionado com Sucesso !!!");
   
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void alterar(User u) {

        Connection con = ConnectionFactory.getConnection();
        
        String sql = "update user set nome=?, usuario=?, senha=?, perfilUser=? where id=?";
        try {
            pst = con.prepareStatement(sql);
          
            pst.setString(1, u.getNome());
            pst.setString(2, u.getUsuario());
            pst.setString(3, u.getSenha());
            // Capiturando dados combobox
            pst.setString(4, u.getperilUser());
            pst.setInt(5, u.getId());
            if ((u.getNome().isEmpty()) || (u.getUsuario().isEmpty()) || (u.getSenha().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios (*)");

            } else {

                // a linha abaixo atualiza a tabela de Usuarios com os dados do Formulário
                // a estrutura abaixo é usada para confirmar a alteração de dados na tabel
                int adicionado = pst.executeUpdate();
                // a linha abaixo serve como entendimento da logica.
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do Usuário Alterado com Sucesso !!!");
                }
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void excluir(User u) {
        Connection con = ConnectionFactory.getConnection();

        String sql = "delete from user where id=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, u.getId());
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Usuário Removido com Sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não Excluido !!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não é Possivel Excluir Usuário que ja efetuou Venda.");
            // Aqui se ocorrer exception de user ja esta amarrado com alguma outra operação nao 
            //deixa excluir
        }
    } 
    
      //Método para pegar todas as marcas e colocar no combobox
    public List<User> pegarTodosUsers() {
        
        List<User> users = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null; 
        
        try {
            stmt = con.prepareStatement("select * from user ORDER by nome");
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {
               User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsuario(rs.getString("usuario"));
                users.add(user);
            }
            User user = new User();
            user.setUsuario("Todos");
            users.add(user);
            
        
        }catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return users;
    }
    
    public void logarr(User user){
        
        String sql = "select*from user where usuario=? and senha=?";
        
        try {
            
            pst = conexao.prepareStatement(sql);
            
            pst.setInt(1, user.getId());
            pst.setString(2, user.getUsuario());
            pst.setString(3, user.getSenha());
            
            rs = pst.executeQuery();
            if(rs.next()){
                //obtem o perfil de usuario
                String perfil = rs.getString(5);
                //System.out.println(perfil);
                //A estrutura abaixo faz o tratamento do perfil de usuario
                if(perfil.equals("Administrador")){
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                TelaPrincipal.cadMenUser.setEnabled(true);
                
                TelaLogin login = new TelaLogin();
                
                login.dispose();
                conexao.close();
                }
                else{
                
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                TelaLogin login = new TelaLogin();
                login.dispose();
                conexao.close();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuario ou Senha Inválildo");
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Usuario ou Senha Inválildo");
        }

    }
     
}
