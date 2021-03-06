/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.telas;


import br.com.sgef.dao.ProdutoDAO;
import br.com.sgef.model.Produto;
import br.com.sgef.util.SoNumeros;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bruno
 */
public class TelaConsultaProd extends javax.swing.JInternalFrame {    
    /**
     * Creates new form TelaConsultaProd
     */
    
    
    private TelaVenda telaVenda;
    public TelaConsultaProd(TelaVenda aThis) {
        initComponents(); 
        
        this.telaVenda = aThis;
        
        
        if(jbCod.isSelected()){
            jbDesc.setSelected(false);
            txtPesquisar.setDocument(new SoNumeros());
            txtPesquisar.requestFocus();
            
        }else{
            jbCod.setSelected(false);
            txtPesquisar.setDocument(new JTextField().getDocument());
            txtPesquisar.requestFocus();
        }
 
    }
    





    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();
        jbCod = new javax.swing.JCheckBox();
        jbDesc = new javax.swing.JCheckBox();

        setClosable(true);
        setTitle("Consulta Produto");

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód", "Descrição", "Preço Compra", "Estoque", "Preço Venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProduto);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Método de Pesquisa");

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sgef/icones/verificado (1).png"))); // NOI18N
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        jbCod.setText("Código");
        jbCod.setFocusPainted(false);
        jbCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCodActionPerformed(evt);
            }
        });

        jbDesc.setSelected(true);
        jbDesc.setText("Descrição");
        jbDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDescActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCod)
                        .addGap(18, 18, 18)
                        .addComponent(jbDesc))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(25, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbCod)
                            .addComponent(jbDesc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 696, 380);
    }// </editor-fold>//GEN-END:initComponents

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked

    }//GEN-LAST:event_tblProdutoMouseClicked

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        //ao digitar no campo de pesquisa ou apertar enter faz a consulta no banco utilizando like
        
        ProdutoDAO dao = new ProdutoDAO();
        
        DefaultTableModel modelo = (DefaultTableModel) tblProduto.getModel();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        ((DefaultTableModel) tblProduto.getModel()).setRowCount(0);
            if(jbDesc.isSelected()){
                for (Produto p: dao.read(this.txtPesquisar.getText().toString())) {
                    String valorCompras = nf.format(p.getPcompra());
                    String valorVendas = nf.format(p.getPvenda());
                    modelo.addRow(new Object[]{
                        p.getId(),
                        p.getDescricao(),
                        valorCompras,
                        p.getEstoque(),
                        valorVendas
                    });

                }

        }
  
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // ao clicar no botao buscar faz a consulta com o parametro passar no txtPesquisar
        ProdutoDAO dao = new ProdutoDAO();

        DefaultTableModel modelo = (DefaultTableModel) tblProduto.getModel();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        ((DefaultTableModel) tblProduto.getModel()).setRowCount(0);
        if(jbCod.isSelected()){
           
            if (txtPesquisar.getText().isEmpty()) {
                
                JOptionPane.showMessageDialog(null, "Digite o Código do Produto");
                
            }else{
            
                for (Produto p: dao.read_int(Integer.parseInt(this.txtPesquisar.getText()))) {
                    String valorCompras = nf.format(p.getPcompra());
                    String valorVendas = nf.format(p.getPvenda());
                    modelo.addRow(new Object[]{
                        p.getId(),
                        p.getDescricao(),
                        valorCompras,
                        p.getEstoque(),
                        valorVendas
                    });

                }
            }    
            
        }
        if(jbDesc.isSelected()){
            
            for (Produto p: dao.read(this.txtPesquisar.getText().toString())) {
                String valorCompras = nf.format(p.getPcompra());
                String valorVendas = nf.format(p.getPvenda());
                modelo.addRow(new Object[]{
                    p.getId(),
                    p.getDescricao(),
                    valorCompras,
                    p.getEstoque(),
                    valorVendas
                });

            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        // TODO add your handling code here:
      
        try {
            int codProd = 0;
            codProd = (int) tblProduto.getValueAt(tblProduto.getSelectedRow(), 0);
            telaVenda.txtCod.setText(tblProduto.getValueAt(tblProduto.getSelectedRow(), 0).toString());
            //fecha tela de consulta ao clicar no botao select
            this.doDefaultCloseAction();
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Nenhum Registro Selecionado.");
        }

    }//GEN-LAST:event_btnSelectActionPerformed

    private void jbCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCodActionPerformed
        // TODO add your handling code here:
        if(jbCod.isSelected()){
            jbDesc.setSelected(false);
            txtPesquisar.setDocument(new SoNumeros());
            txtPesquisar.setText("0");
            
        }
        
    }//GEN-LAST:event_jbCodActionPerformed

    private void jbDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDescActionPerformed
        // TODO add your handling code here:
        if(jbDesc.isSelected()){
            jbCod.setSelected(false);
            txtPesquisar.setDocument(new JTextField().getDocument());

        }
    }//GEN-LAST:event_jbDescActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnSelect;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JCheckBox jbCod;
    private javax.swing.JCheckBox jbDesc;
    public javax.swing.JTable tblProduto;
    public javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
