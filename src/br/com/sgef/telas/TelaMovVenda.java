/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.telas;

import br.com.sgef.dao.MovVendaDAO;
import br.com.sgef.dao.MovVendaTableModel;
import br.com.sgef.dao.UserDAO;
import br.com.sgef.dao.UserComboModelDAO;
import br.com.sgef.dao.VendaDAO;
import br.com.sgef.model.MovVenda;
import br.com.sgef.model.User;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;




/**
 *
 * @author Bruno
 */
public class TelaMovVenda extends javax.swing.JInternalFrame {

    private UserComboModelDAO userComboModel;
    MovVendaTableModel tableModel = new MovVendaTableModel();
    /**
     * Creates new form TelaMovVenda
     */
    public TelaMovVenda() {
        initComponents();
        
        //tblMovVenda.setModel(tableModel);
        //tableModel.setTableColumnModel(tblMovVenda.getColumnModel());

        userComboModel = new UserComboModelDAO();
        
        UserDAO Udao = new UserDAO();
        
        
        for (User u : Udao.pegarTodosUsers()) {
            userComboModel.addUsers(u);
            cboUser.setModel(userComboModel); 
        }
        cboUser.setSelectedIndex(0);
        tblMovVenda.setModel(tableModel);
        tableModel.setTableColumnModel(tblMovVenda.getColumnModel());     
        
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

        jLabel1 = new javax.swing.JLabel();
        cboFormaPag = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMovVenda = new javax.swing.JTable();
        btnRelListaProd = new javax.swing.JButton();
        RelLista = new javax.swing.JButton();
        cboUser = new javax.swing.JComboBox();
        txtDataInic = new javax.swing.JFormattedTextField();
        txtDataFin = new javax.swing.JFormattedTextField();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Movimento de vendas");

        jLabel1.setText("Usuário");

        cboFormaPag.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Cartão", "Cheque", "Todos" }));

        jLabel2.setText("Form. Pagamento");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Data Inicial");

        jLabel4.setText("Data Final");

        tblMovVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data", "Situação", "Forma Pag", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMovVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMovVendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMovVenda);

        btnRelListaProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRelListaProd.setText("Lista Prod.");
        btnRelListaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelListaProdActionPerformed(evt);
            }
        });

        RelLista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RelLista.setText("Rel. Lista");
        RelLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelListaActionPerformed(evt);
            }
        });

        cboUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboUserActionPerformed(evt);
            }
        });

        try {
            txtDataInic.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataInic.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDataInicFocusGained(evt);
            }
        });
        txtDataInic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDataInicKeyPressed(evt);
            }
        });

        try {
            txtDataFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataFinActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnRelListaProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RelLista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(127, 127, 127))
                            .addComponent(cboUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addComponent(cboFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtDataInic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDataFin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(txtDataFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataInic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboFormaPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRelListaProd)
                    .addComponent(RelLista)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataFinActionPerformed

    private void txtDataInicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataInicKeyPressed
        // TODO add your handling code here:   
    }//GEN-LAST:event_txtDataInicKeyPressed

    private void txtDataInicFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataInicFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtDataInicFocusGained

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        
        MovVendaDAO dao = new MovVendaDAO();
        MovVenda movVenda = new MovVenda();
        
        User u = (User)userComboModel.getSelectedItem();
        
        String dataInicial = txtDataInic.getText().replaceAll("/", "-");
        String[] s = dataInicial.split("-");
        String novaDataI = s[2]+"-"+s[1]+"-"+s[0];
        
        String dataFinal = txtDataFin.getText().replaceAll("/", "-");
        String[] sf = dataFinal.split("-");
        String novaDataF = sf[2]+"-"+sf[1]+"-"+sf[0];
       
        int l=0;
        while(tableModel.getRowCount()>l){
            tableModel.removeRow(l);
        }
        
        movVenda.setUsuario(u.getId());
        movVenda.setFormPag(cboFormaPag.getSelectedItem().toString());
        movVenda.setDataInicial(Date.valueOf(novaDataI));
        movVenda.setDatafinal(Date.valueOf(novaDataF));
        
        for (MovVenda mv: dao.read(movVenda)) {
            tableModel.addRow(mv);


            
            tblMovVenda.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){ 
                @Override 
                public Component getTableCellRendererComponent(JTable table, Object value, 
                boolean isSelected, boolean hasFocus, int row, int col) { 
                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col); 
                   String situacao = (String) tblMovVenda.getModel().getValueAt(row, 2);
                    if ("CANCELADA".equals(situacao)) { 
                        setBackground(Color.RED); 
                        setForeground(Color.WHITE);  
                    } else { 
                        setBackground(table.getBackground());
                        setForeground(table.getForeground());  
                    } 
                    return this; 
                } 
            });
            
        }
 
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cboUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboUserActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_cboUserActionPerformed

    private void tblMovVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMovVendaMouseClicked
        // TODO add your handling code here:
        System.setProperty("codvenda", tblMovVenda.getValueAt(tblMovVenda.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tblMovVendaMouseClicked

    private void btnRelListaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelListaProdActionPerformed
        // TODO add your handling code here:
        VendaDAO dao = new VendaDAO();
        dao.abrirListaProd(Integer.parseInt(System.getProperty("codvenda")));
        
    }//GEN-LAST:event_btnRelListaProdActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        MovVendaDAO dao = new MovVendaDAO();
        //Estorna os produtos para o Estoque

        
        String situacao = tblMovVenda.getValueAt(tblMovVenda.getSelectedRow(), 2).toString();
        //JOptionPane.showMessageDialog(null, situacao);
        
        switch(situacao){
            case "CANCELADA":
            JOptionPane.showMessageDialog(null, "A venda ja esta CANCELADA"); 
            break;
            
            case "ATIVA": 
            dao.cancelaProdutos((int) tblMovVenda.getValueAt(tblMovVenda.getSelectedRow(), 0));
            //Cancela a venda
            dao.cancelaVenda((int) tblMovVenda.getValueAt(tblMovVenda.getSelectedRow(), 0));   
            btnBuscarActionPerformed(evt);
            break;
        }   
             
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void RelListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelListaActionPerformed
        // TODO add your handling code here:
        MovVendaDAO dao = new MovVendaDAO();
        
        User u = (User)userComboModel.getSelectedItem();
        
        String dataInicial = txtDataInic.getText().replaceAll("/", "-");
        String[] s = dataInicial.split("-");
        String novaDataI = s[2]+"-"+s[1]+"-"+s[0];
        
        String dataFinal = txtDataFin.getText().replaceAll("/", "-");
        String[] sf = dataFinal.split("-");
        String novaDataF = sf[2]+"-"+sf[1]+"-"+sf[0];
        
        dao.abrirListaVenda(u.getId(), cboFormaPag.getSelectedItem().toString(), novaDataI, novaDataF);

        
    }//GEN-LAST:event_RelListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RelLista;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRelListaProd;
    private javax.swing.JComboBox cboFormaPag;
    public javax.swing.JComboBox cboUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblMovVenda;
    private javax.swing.JFormattedTextField txtDataFin;
    private javax.swing.JFormattedTextField txtDataInic;
    // End of variables declaration//GEN-END:variables
}
