/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.telas;

import br.com.sgef.dao.ClienteDAO;
import br.com.sgef.dao.ItemVendaDAO;
import br.com.sgef.util.NumeroDocument;
import br.com.sgef.dao.ProdutoDAO;
import br.com.sgef.dao.VendaDAO;
import br.com.sgef.dao.VendaTableModel;
import br.com.sgef.model.ItemVenda;
import br.com.sgef.model.Produto;
import br.com.sgef.model.Venda;
import br.com.sgef.util.SoNumeros;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;



/**
 *
 * @author Bruno
 */
public class TelaVenda extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaVenda
     */
    
    VendaTableModel tableModel = new VendaTableModel();
    
    public TelaVenda() {
        initComponents();

        txtCod.setDocument(new SoNumeros());
        txtQtd.setDocument(new SoNumeros());
        txtQtd.setText("1");
        txtCodCli.setDocument(new SoNumeros());
        // as linhas abaixo coloca mascara monetária
        txtVunit.setHorizontalAlignment(txtVunit.RIGHT);
        txtVunit.setDocument(new NumeroDocument(9,2));
        
        txtTotal.setText("0,00");

        tblVenda.setModel(tableModel);
        tableModel.setTableColumnModel(tblVenda.getColumnModel());
        
        VendaDAO vdao = new VendaDAO();
        txtVenda.setText(String.valueOf(vdao.pegaIdVenda()));

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

        txtCod = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDescProd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JTextField();
        txtVunit = new javax.swing.JTextField();
        txtSubt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenda = new javax.swing.JTable();
        cboFormaPag = new javax.swing.JComboBox();
        txtCodCli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtVenda = new javax.swing.JTextField();
        Venda = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Tela Venda");

        txtCod.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodFocusLost(evt);
            }
        });
        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodKeyPressed(evt);
            }
        });

        jLabel1.setText("Código");

        txtDescProd.setEditable(false);

        jLabel2.setText("Descrição do Produto");

        jLabel3.setText("Qtd");

        jLabel4.setText("Valor unit.");

        jLabel5.setText("SubTotal");

        txtQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdActionPerformed(evt);
            }
        });
        txtQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQtdKeyPressed(evt);
            }
        });

        txtVunit.setEditable(false);

        txtSubt.setEditable(false);
        txtSubt.setToolTipText("");
        txtSubt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSubtFocusLost(evt);
            }
        });
        txtSubt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSubtKeyPressed(evt);
            }
        });

        tblVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód", "Descrição", "Quantidade", "Valor unit", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblVendaFocusGained(evt);
            }
        });
        tblVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendaMouseClicked(evt);
            }
        });
        tblVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblVendaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblVenda);

        cboFormaPag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Cartão", "Cheque" }));
        cboFormaPag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFormaPagActionPerformed(evt);
            }
        });

        txtCodCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodCliKeyPressed(evt);
            }
        });

        jLabel6.setText("Cód Cliente");

        txtCliente.setEditable(false);

        jLabel7.setText("Forma de Pagamento");

        btnFinalizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        txtTotal.setEditable(false);
        txtTotal.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Total :");

        txtVenda.setEditable(false);

        Venda.setText("Venda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Venda)
                                .addGap(0, 40, Short.MAX_VALUE))
                            .addComponent(txtVenda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescProd, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtVunit, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSubt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(cboFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(Venda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVunit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodFocusLost

    private void txtQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdActionPerformed
        // TODO add your handling code here:  
    }//GEN-LAST:event_txtQtdActionPerformed

    
    private void txtCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyPressed
        // TODO add your handling code here:
        
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){ 
        
            if(txtCod.getText().isEmpty()){
                
                //abrir consulta de cliente
                TelaConsultaProd consultaProd = new TelaConsultaProd(this);
                
                getParent().add(consultaProd);
                consultaProd.setVisible(true);
                consultaProd.txtPesquisar.grabFocus();
                consultaProd.setPosicao();
                
                
            }else{
                
                ProdutoDAO dao = new ProdutoDAO();
        
                Integer id = Integer.parseInt(txtCod.getText());

                txtDescProd.setText(dao.pesquisa_por_id((Integer) id).getDescricao());
                txtVunit.setText(dao.pesquisa_por_id((Integer) id).getPvenda().toString());
                
                Double vUnit = Double.parseDouble(txtVunit.getText().replace(".", "") .replace(",", "."));
                Double qtd = Double.parseDouble(txtQtd.getText().replace(".", "").replace(",", "."));
                
                Double subtotal =  qtd * vUnit;
                DecimalFormat df = new DecimalFormat("#,##0.00");
                txtSubt.setText(String.valueOf(df.format(subtotal)));
                
                txtQtd.requestFocus();
                
            }
                   
        }
        
    }//GEN-LAST:event_txtCodKeyPressed

    private void txtQtdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtdKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){ 
            Double vUnit = Double.parseDouble(txtVunit.getText().replace(".", "").replace(",", "."));
            int qtd = Integer.parseInt(txtQtd.getText());

            DecimalFormat df = new DecimalFormat("#,##0.00");
            
            Double subtotal =  qtd * vUnit;
            txtSubt.setText(String.valueOf(df.format(subtotal)));
            txtSubt.requestFocus();
            txtSubt.setBackground(Color.GREEN);
            
         }
    }//GEN-LAST:event_txtQtdKeyPressed

    private void txtSubtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubtKeyPressed
        // TODO add your handling code here:
        ItemVenda itV = new ItemVenda();
        
        Produto prod = new Produto();
        ProdutoDAO pdao = new ProdutoDAO();
        prod.setId(Integer.parseInt(txtCod.getText()));
        prod.setDescricao(txtDescProd.getText());
        
        int id = Integer.parseInt(txtCod.getText());
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //dao.pesquisa_por_id((Integer) id).getPvenda().toString()
            
            itV.setIdProduto(id);
            itV.setDescProd(prod.getDescricao());
            itV.setQuantidade(Integer.parseInt(txtQtd.getText()));
            //itV.setValorUnit(Double.parseDouble(txtVunit.getText().replace(".", "").replace(",", ".")));
            itV.setValorUnit(Double.parseDouble(pdao.pesquisa_por_id((Integer) id).getPvenda().toString()));
            itV.setSubtotal(Double.parseDouble(txtSubt.getText().replace(".", "").replace(",", ".")));
            
            //fazer condição se ja existe o produto na jtable e apenas somar a quantidade
            for(int linha=0; linha<tableModel.getRowCount();linha++){
                int valorColuna= (Integer) tableModel.getValueAt(linha, 0);
                if(valorColuna == prod.getId()){
                    
                    int soma;
                    
                    int quantnova = Integer.parseInt(txtQtd.getText());
                    int lancada = Integer.parseInt(tableModel.getValueAt(linha, 2).toString());
                    soma = lancada + quantnova;
                    itV.setQuantidade(soma);
                    itV.setSubtotal(soma * itV.getValorUnit());
                    tableModel.removeRow(linha);                    
                    
                }
               
            }
            
            tableModel.addRow(itV);
            
            txtCod.setText(null);
            txtDescProd.setText(null);
            txtQtd.setText("1");
            txtVunit.setText(null);
            txtSubt.setText(null);
            txtCod.requestFocus();
            txtSubt.setBackground(null);
            
            NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
            Double total = Double.parseDouble(tableModel.CalculaTotal().toString());
            txtTotal.setText(nf.format(total));
            
        }
 
    }//GEN-LAST:event_txtSubtKeyPressed

    private void txtSubtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSubtFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSubtFocusLost

    private void tblVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendaMouseClicked
        // TODO add your handling code here:  
        
    }//GEN-LAST:event_tblVendaMouseClicked

    private void tblVendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblVendaFocusGained
        // TODO add your handling code here:  
    }//GEN-LAST:event_tblVendaFocusGained

    private void tblVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVendaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_DELETE){
            
            int dialogButton = JOptionPane.YES_NO_OPTION;
            dialogButton = JOptionPane.showConfirmDialog (null, "Deseja Realmente Excluir o Produto da Venda?",
                    "ATENÇÃO", dialogButton);
            if (dialogButton == JOptionPane.YES_OPTION) {
                //((DefaultTableModel) tblVenda.getModel()).removeRow(tblVenda.getSelectedRow());
                if(tblVenda.getSelectedRow() != -1){
                    tableModel.removeRow(tblVenda.getSelectedRow());

                    //calcula o txt Total
                    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
                    Double total = Double.parseDouble(tableModel.CalculaTotal().toString());
                    txtTotal.setText(nf.format(total));
                }

            }

        }
    }//GEN-LAST:event_tblVendaKeyPressed

    private void txtCodCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodCliKeyPressed
        // TODO add your handling code here:
        
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
             
             if(txtCodCli.getText().isEmpty()){
                 
                 //abrir tela de consulta de cliente
                TelaConsultaClient consultaCli = new TelaConsultaClient();
                getParent().add(consultaCli);
                consultaCli.setVisible(true);
                consultaCli.txtPesquisar.grabFocus();
                consultaCli.setPosicao();      
            }else{ 
                ClienteDAO dao = new ClienteDAO();

                Integer id = Integer.parseInt(txtCodCli.getText());   
                txtCliente.setText(dao.pesquisa_por_id((Integer) id).getNome()); 
                cboFormaPag.requestFocus();
            }
   
         }
   
    }//GEN-LAST:event_txtCodCliKeyPressed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
        VendaDAO dao = new VendaDAO();
        Venda venda = new Venda();
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        Double total = Double.parseDouble(tableModel.CalculaTotal());
        
        if(total == 0.00){
            JOptionPane.showMessageDialog(null, "Venda Sem Produtos !!!");
        }
        else{
            venda.setCliente(Integer.parseInt(txtCodCli.getText()));
            venda.setUsuario(Integer.parseInt(System.getProperty("codigo")));
            venda.setQtd_item(Double.parseDouble(tableModel.CalculaQtd()));
            venda.setDataVenda(java.sql.Date.valueOf(formatador.format(data)));
            venda.setFormaPagamento((String) cboFormaPag.getSelectedItem());
            venda.setValorTotal(total);

            dao.adicionar(venda);
            
        
            ItemVenda itV = new ItemVenda();
            ItemVendaDAO itVdao = new ItemVendaDAO();

            //fazer condição se ja existe o produto na jtable e apenas somar a quantidade
            for(int linha=0; linha<tableModel.getRowCount();linha++){
                int valorColuna = (Integer) tableModel.getValueAt(linha, 0);

                itV.setIdVenda(Integer.parseInt(txtVenda.getText()));
                itV.setIdProduto(valorColuna);
                itV.setDescProd(tableModel.getValueAt(linha, 1).toString());
                itV.setQuantidade(Integer.parseInt(tableModel.getValueAt(linha, 2).toString()));
                itV.setValorUnit(Double.parseDouble(tableModel.getValueAt(linha, 3).toString()));
                itV.setSubtotal(Double.parseDouble(tableModel.getValueAt(linha, 4).toString()));
                itV.setTotal(Double.parseDouble(tableModel.CalculaTotal()));

                itVdao.addItVenda(itV);
                itVdao.baixaEstoque(itV);

            }

            int l=0;
            while(tableModel.getRowCount()>l){
                tableModel.removeRow(l);
            }
            dao.abrirListaProd(Integer.parseInt(txtVenda.getText()));
        
        }
        
        txtVenda.setText(String.valueOf(dao.pegaIdVenda()));
        txtTotal.setText("0,00");
        txtCodCli.setText(null);
        txtCliente.setText(null);

    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void cboFormaPagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFormaPagActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboFormaPagActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Venda;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JComboBox cboFormaPag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVenda;
    private javax.swing.JTextField txtCliente;
    public javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtCodCli;
    private javax.swing.JTextField txtDescProd;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtSubt;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVenda;
    private javax.swing.JTextField txtVunit;
    // End of variables declaration//GEN-END:variables
}
