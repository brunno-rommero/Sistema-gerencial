/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.dao;

import br.com.sgef.dal.ConnectionFactory;
import br.com.sgef.model.Caixa;
import br.com.sgef.model.MovCaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class MovCaixaDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void addMovCaixa(MovCaixa mcx) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareCall("{call entradaMovCaixa(?, ?, ?, ?, ?, ?, ?, ?)}");
            stmt.setInt(1, mcx.getId_caixa());
            stmt.setInt(2, mcx.getId_venda());
            stmt.setDate(3, mcx.getDataMov());
            stmt.setString(4, mcx.getTipo());
            stmt.setString(5, mcx.getOrigemMov());
            stmt.setString(6, mcx.getFormPag());
            stmt.setDouble(7, mcx.getValor());
            stmt.setInt(8, mcx.getIdUser());

            stmt.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
   
    }
    
    public int pegaIdCaixa(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        Caixa caixa = new Caixa();
        int Cod = 0;
        
        try {
            stmt = con.prepareStatement("SELECT AUTO_INCREMENT FROM information_schema.tables\n" +
                                        "WHERE TABLE_NAME = 'caixa' AND table_schema = 'sist'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                caixa.setIdCaixa(rs.getInt("AUTO_INCREMENT"));  
                Cod = caixa.getIdCaixa();
            }
            
            
        }catch (Exception e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return Cod;
        
    }
    
    public MovCaixa saidaMovCaixa(int venda) {
        
        MovCaixa mcx = new MovCaixa();
        try {
            
            Connection con = ConnectionFactory.getConnection();
            String sql = ("select * from movcaixa where id_venda=?");
            pst = con.prepareStatement(sql);
            pst.setInt(1, venda);

            rs = pst.executeQuery();
            while ( rs.next() ) {
                mcx.setMovCaixa(rs.getInt(1));
                mcx.setId_caixa(rs.getInt(2));
                mcx.setId_venda(rs.getInt(3));
                mcx.setIdUser(rs.getInt(4));
                mcx.setDataMov(rs.getDate(5));
                mcx.setTipo(rs.getString(6));
                mcx.setOrigemMov(rs.getString(7));
                mcx.setFormPag(rs.getString(8));
                mcx.setValor(rs.getDouble(9) * -1);
            }    
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        
        } finally {
            ConnectionFactory.closeConnection(conexao);
        }
        return  mcx;
    }
    
    public List<MovCaixa> read(String data, int idUser){
        
        List<MovCaixa> movCaixa = new ArrayList<>();
        
        try {
            String sql;
            Connection con = ConnectionFactory.getConnection();
            ResultSet rs;
            
            if(idUser != 0){
                sql = ("SELECT * FROM movcaixa \n" +
                            "WHERE dataMov = ? and idUser=?");
                PreparedStatement pst = con.prepareStatement(sql); 
                pst.setString(1, data);
                pst.setInt(2, idUser);
                rs = pst.executeQuery();  
            }else{
                sql = ("SELECT * FROM movcaixa \n" +
                            "WHERE dataMov = ?");
                PreparedStatement pst = con.prepareStatement(sql); 
                pst.setString(1, data);
                rs = pst.executeQuery();
            }
                            
            

            while ( rs.next() ) {
                MovCaixa mcx = new MovCaixa();
                mcx.setMovCaixa(rs.getInt(1));
                mcx.setId_caixa(rs.getInt(2));
                mcx.setId_venda(rs.getInt(3));
                mcx.setDataMov(rs.getDate(4));
                mcx.setTipo(rs.getString(5));
                mcx.setOrigemMov(rs.getString(6));
                mcx.setFormPag(rs.getString(7));
                mcx.setValor(rs.getDouble(8));
                mcx.setIdUser(rs.getInt(9));
                movCaixa.add(mcx);
                        
            }
            
            
        } catch (Exception e) {
            
        }
        return movCaixa;
        
    }

}
