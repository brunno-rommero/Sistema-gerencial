/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.telas;

import br.com.sgef.dao.LinhaDAO;
import br.com.sgef.model.Linha;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bruno
 */
public class TelaCadLinha extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadLinha
     */
    public TelaCadLinha() {
        initComponents();
        tblLinha.getColumnModel().getColumn(0).setMaxWidth(60);
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

        txtDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        btnDelete = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();
        txtCod = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLinha = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Linha");

        jLabel1.setText("Código");

        jLabel2.setText("Descrição");

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sgef/icones/saved.png"))); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        btnSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveKeyPressed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sgef/icones/alter.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        btnEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditKeyPressed(evt);
            }
        });

        btnClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sgef/icones/clean.png"))); // NOI18N
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });
        btnClean.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCleanKeyPressed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sgef/icones/delete.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Método de Pesquisa");

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        jToggleButton2.setText("Buscar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        txtCod.setEditable(false);
        txtCod.setEnabled(false);

        tblLinha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód", "Marca"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLinha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLinhaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLinha);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescricao)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClean)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(btnEdit)
                    .addComponent(btnClean)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Botao salvar
        Linha linha = new Linha();
        LinhaDAO dao = new LinhaDAO();

        if ((txtDescricao.getText().isEmpty())){

            JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios (*)");

        }else{

            linha.setDescricao(txtDescricao.getText());
            dao.adicionar(linha);
            txtCod.setText(null);
            txtDescricao.setText(null);

        }

        DefaultTableModel modelo = (DefaultTableModel) tblLinha.getModel();

        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        ((DefaultTableModel) tblLinha.getModel()).setRowCount(0);

        for (Linha l: dao.read(this.txtPesquisar.getText().toString())) {
            modelo.addRow(new Object[]{
                l.getId(),
                l.getDescricao()
            });

        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveKeyPressed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Método para alterar

        LinhaDAO dao = new LinhaDAO();
        Linha linha = new Linha();

        if(txtCod.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um registro para ser editado !");
        }
        else if ((txtDescricao.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios (*)");
        }else{
            linha.setId(Integer.parseInt(txtCod.getText()));
            linha.setDescricao(txtDescricao.getText());

            dao.alterar(linha);

            txtCod.setText(null);
            txtDescricao.setText(null);

            btnSave.setEnabled(true);

        }

        DefaultTableModel modelo = (DefaultTableModel) tblLinha.getModel();

        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        ((DefaultTableModel) tblLinha.getModel()).setRowCount(0);

        for (Linha l: dao.read(this.txtPesquisar.getText().toString())) {
            modelo.addRow(new Object[]{
                l.getId(),
                l.getDescricao()
            });

        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEditKeyPressed
        // ao clicar no botao editar vai alterar o registro

        LinhaDAO dao = new LinhaDAO();
        Linha linha = new Linha();

        if(txtCod.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um registro para ser editado !");
        }
        else if ((txtDescricao.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios (*)");
        }else{
            linha.setId(Integer.parseInt(txtCod.getText()));
            linha.setDescricao(txtDescricao.getText());

            dao.alterar(linha);

            txtCod.setText(null);
            txtDescricao.setText(null);

            btnSave.setEnabled(true);

        }

        DefaultTableModel modelo = (DefaultTableModel) tblLinha.getModel();

        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        ((DefaultTableModel) tblLinha.getModel()).setRowCount(0);

        for (Linha l: dao.read(this.txtPesquisar.getText().toString())) {
            modelo.addRow(new Object[]{
                l.getId(),
                l.getDescricao()
            });

        }

    }//GEN-LAST:event_btnEditKeyPressed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        // Limpar campos ao clicar no botao clean
        txtCod.setText(null);
        txtDescricao.setText(null);
        btnSave.setEnabled(true);

    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnCleanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCleanKeyPressed
        // TODO add your handling code here:
        //limpar();
    }//GEN-LAST:event_btnCleanKeyPressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //Excluir usuario por id
        // Seleciona o registro na tabela e ao clicar aqui exclui o fornecedor
        // Se nenhum registro tiver selecionado o sistema avisa o usuario

        LinhaDAO dao = new LinhaDAO();
        Linha linha = new Linha();

        if (txtCod.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para ser Excluido!");
        }else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            dialogButton = JOptionPane.showConfirmDialog (null, "Deseja Realmente Excluir?",
                "ATENÇÃO", dialogButton);
            if (dialogButton == JOptionPane.YES_OPTION) {
                linha.setId(Integer.parseInt(txtCod.getText()));
                dao.excluir(linha);
                //limpar campos
                txtCod.setText(null);
                txtDescricao.setText(null);
                btnSave.setEnabled(true);

            }

        }
        DefaultTableModel modelo = (DefaultTableModel) tblLinha.getModel();

        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        ((DefaultTableModel) tblLinha.getModel()).setRowCount(0);

        for (Linha l: dao.read(this.txtPesquisar.getText().toString())) {
            modelo.addRow(new Object[]{
                l.getId(),
                l.getDescricao()
            });

        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased

        
        LinhaDAO dao = new LinhaDAO();
        DefaultTableModel modelo = (DefaultTableModel) tblLinha.getModel();

        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        ((DefaultTableModel) tblLinha.getModel()).setRowCount(0);

        for (Linha l: dao.read(this.txtPesquisar.getText().toString())) {
            modelo.addRow(new Object[]{
                l.getId(),
                l.getDescricao()
            });

        }

    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // Popular Tabela

        LinhaDAO dao = new LinhaDAO();
        DefaultTableModel modelo = (DefaultTableModel) tblLinha.getModel();

        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        ((DefaultTableModel) tblLinha.getModel()).setRowCount(0);

        for (Linha l: dao.read(this.txtPesquisar.getText().toString())) {
            modelo.addRow(new Object[]{
                l.getId(),
                l.getDescricao()
            });

        }

    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void tblLinhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLinhaMouseClicked
        /*Pega o id do campo codigo e faz a consulta no banco de dados,
        após fazer a consulta, pega os atributos e seta para os campos
        do formulario conforme clica sobre o registro da tabela na tela*/

        LinhaDAO dao = new LinhaDAO();
        Linha linha = new Linha();

        int k = tblLinha.getSelectedRow();
        Object id = tblLinha.getValueAt(k, 0);
        txtCod.setText(id.toString());
        linha.setId(Integer.parseInt(id.toString()));

        //setar o restante dos campos
        int setar = tblLinha.getSelectedRow();
        txtDescricao.setText(dao.pesquisa_por_id((Integer) id).getDescricao());

        //botao salvar inativo
        btnSave.setEnabled(false);
    }//GEN-LAST:event_tblLinhaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JToggleButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton2;
    public javax.swing.JTable tblLinha;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDescricao;
    public javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
