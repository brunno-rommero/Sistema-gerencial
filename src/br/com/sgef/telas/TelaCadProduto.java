/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgef.telas;

import br.com.sgef.dao.LinhaComboModelDAO;
import br.com.sgef.dao.LinhaDAO;
import br.com.sgef.dao.MarcaComboModelDAO;
import br.com.sgef.dao.MarcaDAO;
import br.com.sgef.dao.ProdutoDAO;
import br.com.sgef.model.Linha;
import br.com.sgef.model.Marca;
import br.com.sgef.model.Produto;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Bruno
 */


public class TelaCadProduto extends javax.swing.JInternalFrame {
    
    private LinhaComboModelDAO linhaComboModel;
    private MarcaComboModelDAO marcaComboModel;
    
    /**
     * Creates new form TelaCadProduto
     */
    public TelaCadProduto() {
        initComponents();
        
        linhaComboModel = new LinhaComboModelDAO();
        marcaComboModel = new MarcaComboModelDAO();
       
        ProdutoDAO dao = new ProdutoDAO();
        Marca marca = new Marca();
        Linha linha = new Linha();
        
        for (Marca m : dao.pegarTodasMarca()) {
            marcaComboModel.addMarcas(m);
            comboMarca.setModel(marcaComboModel); 
        }
        for (Linha l : dao.pegarTodasLinha()) {
            linhaComboModel.addLinhas(l);
            ComboLinha.setModel(linhaComboModel); 
        }
        
        tblProduto.getColumnModel().getColumn(0).setMaxWidth(40);

   
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
        txtDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboMarca = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ComboLinha = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEstoque = new javax.swing.JTextField();
        txtCompra = new javax.swing.JFormattedTextField();
        txtvend = new javax.swing.JFormattedTextField();
        btnExcluir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Produto");

        txtCod.setEditable(false);
        txtCod.setEnabled(false);

        jLabel1.setText("Código");

        jLabel2.setText("Descrição");

        comboMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMarcaActionPerformed(evt);
            }
        });

        jLabel3.setText("Marca*");

        jLabel4.setText("Linha*");

        jLabel5.setText("Estoque");

        jLabel6.setText("P. de Compra");

        jLabel7.setText("P. de Venda");

        txtCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCompraFocusLost(evt);
            }
        });

        txtvend.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtvendFocusLost(evt);
            }
        });
        txtvend.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtvendKeyPressed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sgef/icones/delete.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sgef/icones/clean.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sgef/icones/alter.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sgef/icones/saved.png"))); // NOI18N
        btnSave.setPreferredSize(new java.awt.Dimension(80, 80));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jButton1.setText("+");

        jButton4.setText("+");

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

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód", "Descrição", "Preço Venda", "Estoque", "Preço Compra"
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDescricao)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ComboLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1))
                                    .addComponent(jLabel4))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEstoque)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(txtvend, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtvend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // Seleciona o registro na tabela e ao clicar aqui exclui o fornecedor
        // Se nenhum registro tiver selecionado o sistema avisa o usuario
        
        
        Produto produto = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        
        
        if (txtCod.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um registro para ser Excluido!");
        }else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            dialogButton = JOptionPane.showConfirmDialog (null, "Deseja Realmente Excluir o Produto?",
                    "ATENÇÃO", dialogButton);
            if (dialogButton == JOptionPane.YES_OPTION) {
                produto.setId(Integer.parseInt(txtCod.getText()));
                dao.excluir(produto);
                //limpar campos
                txtCod.setText(null);
                txtCompra.setText(null);
                txtDescricao.setText(null);
                ComboLinha.setSelectedIndex(1);
                comboMarca.setSelectedIndex(1);
                txtEstoque.setText(null);
                txtvend.setText(null);
                btnSave.setEnabled(true);

            }
        }
        
        
        DefaultTableModel modelo = (DefaultTableModel) tblProduto.getModel();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        ((DefaultTableModel) tblProduto.getModel()).setRowCount(0);
        
        for (Produto p: dao.read(this.txtPesquisar.getText().toString())) {
            String valorCompras = nf.format(p.getPcompra());
            String valorVendas = nf.format(p.getPvenda());
            modelo.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                valorVendas,
                p.getEstoque(),
                valorCompras
            });

        }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Limpar campos ao clicar no botao clean
        
        txtCod.setText(null);
        txtCompra.setText(null);
        txtDescricao.setText(null);
        ComboLinha.setSelectedIndex(1);
        comboMarca.setSelectedIndex(1);
        txtEstoque.setText(null);
        txtvend.setText(null);
        btnSave.setEnabled(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Método Para alterar 
        
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        Marca marca = (Marca) marcaComboModel.getSelectedItem();
        Linha linha = (Linha) linhaComboModel.getSelectedItem();
        MarcaDAO marcadao = new MarcaDAO();
        LinhaDAO linhadao = new LinhaDAO();

        String valorSemFormatarVenda = txtvend.getText();
        String valorVenda = valorSemFormatarVenda.replace(",", ".").replace("R$", "").replace(" ", "");
        
        String valorSemFormatarCompra = txtCompra.getText();
        String valorCompra = valorSemFormatarCompra.replace(",", ".").replace("R$", "").replace(" ", "");
        //BigDecimal valorCompra = new BigDecimal (valorSemFormatarCompra.replace(",", ".").replace("R$", "").replace(" ", ""));
       
        JOptionPane.showMessageDialog(null, "Valor Compra:" + valorCompra);
        
        if(txtCod.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione um registro para ser editado !");
        }
        else if ((ComboLinha.getSelectedItem() == null) && (comboMarca.getSelectedItem() == null)){
            
            int idProduto = Integer.parseInt(txtCod.getText());
            linha.setId(linhadao.pesquisa_por_id(dao.pesquisa_por_id((Integer) idProduto).getId_linha()).getId());
            marca.setId(marcadao.pesquisa_por_id(dao.pesquisa_por_id((Integer) idProduto).getId_marca()).getId());
            
        }
        
        else if ((txtDescricao.getText().isEmpty()) || (txtCompra.getText().isEmpty()) ||
                (txtvend.getText().isEmpty())|| (txtEstoque.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios (*)");   
        }else{
            produto.setId(Integer.parseInt(txtCod.getText()));
            produto.setDescricao(txtDescricao.getText());
            produto.setEstoque(Integer.parseInt(txtEstoque.getText()));
            produto.setPvenda(new BigDecimal(valorVenda));
            produto.setPcompra(new BigDecimal (valorCompra));
            produto.setId_linha(linha.getId());
            produto.setId_marca(marca.getId());
            

            dao.alterar(produto);
            
            txtCod.setText(null);
            txtDescricao.setText(null);
            txtEstoque.setText(null);
            txtCompra.setText(null);
            txtvend.setText(null);
            btnSave.setEnabled(true);

        }
        
        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        DefaultTableModel modelo = (DefaultTableModel) tblProduto.getModel();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        ((DefaultTableModel) tblProduto.getModel()).setRowCount(0);
        
        for (Produto p: dao.read(this.txtPesquisar.getText().toString())) {
            String valorCompras = nf.format(p.getPcompra());
            String valorVendas = nf.format(p.getPvenda());
            modelo.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                valorVendas,
                p.getEstoque(),
                valorCompras
            });

        } 

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Botao salvar - ao clicar valida os campos e se estiver tudo ok salva no DB
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        Marca marca = (Marca) marcaComboModel.getSelectedItem();
        Linha linha = (Linha) linhaComboModel.getSelectedItem();
        
        
        String valorSemFormatarVenda = txtvend.getText();
        String valorVenda = valorSemFormatarVenda.replace(",", ".").replace("R$", "").replace(" ", "");
        
        
        String valorSemFormatarCompra = txtCompra.getText();
        String valorCompra = valorSemFormatarCompra.replace(",", ".").replace("R$", "").replace(" ", "");
        
        
        if ((txtDescricao.getText().isEmpty()) || (txtEstoque.getText().isEmpty()) || (linhaComboModel.getSelectedItem() == null) ||
            (marcaComboModel.getSelectedItem() == null) || (txtCompra.getText().isEmpty()) || 
            (txtvend.getText().isEmpty())){
               
            JOptionPane.showMessageDialog(null, "Preencha Todos os Campos Obrigatórios (*)");
                
        }else{

            produto.setDescricao(txtDescricao.getText());
            produto.setEstoque(Integer.parseInt(txtEstoque.getText()));
            produto.setPcompra(new BigDecimal(valorCompra));
            produto.setPvenda(new BigDecimal(valorVenda));
            produto.setId_linha(linha.getId());
            produto.setId_marca(marca.getId());


            dao.adicionar(produto);
            
            txtCod.setText(null);
            txtCompra.setText(null);
            txtDescricao.setText(null);
            ComboLinha.setSelectedIndex(1);
            comboMarca.setSelectedIndex(1);
            txtEstoque.setText(null);
            txtvend.setText(null);
            
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tblProduto.getModel();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        ((DefaultTableModel) tblProduto.getModel()).setRowCount(0);
        
        for (Produto p: dao.read(this.txtPesquisar.getText().toString())) {
            String valorCompras = nf.format(p.getPcompra());
            String valorVendas = nf.format(p.getPvenda());
            modelo.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                valorVendas,
                p.getEstoque(),
                valorCompras
            });

        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void comboMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMarcaActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        //ao digitar no campo de pesquisa ou apertar enter faz a consulta no banco utilizando like
        ProdutoDAO dao = new ProdutoDAO();
        
        DefaultTableModel modelo = (DefaultTableModel) tblProduto.getModel();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        ((DefaultTableModel) tblProduto.getModel()).setRowCount(0);
        
        for (Produto p: dao.read(this.txtPesquisar.getText().toString())) {
            String valorCompra = nf.format(p.getPcompra());
            String valorVenda = nf.format(p.getPvenda());
            modelo.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                valorVenda,
                p.getEstoque(),
                valorCompra.trim()
            });

        }

    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // ao clicar no botao buscar faz a consulta com o parametro passar no txtPesquisar
        
        ProdutoDAO dao = new ProdutoDAO();
        
        DefaultTableModel modelo = (DefaultTableModel) tblProduto.getModel();
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        
        
        //a linha abaixo limpa a tabela antes de colocar o resultado da pesquisa
        ((DefaultTableModel) tblProduto.getModel()).setRowCount(0);

        for (Produto p: dao.read(this.txtPesquisar.getText().toString())) {
            String valorCompra = nf.format(p.getPcompra());
            String valorVenda = nf.format(p.getPvenda());
            modelo.addRow(new Object[]{
                p.getId(),
                p.getDescricao(),
                valorVenda,
                p.getEstoque(),
                valorCompra
            });

        }
       
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
        /*Pega o id do campo codigo e faz a consulta no banco de dados,
        após fazer a consulta, pega os atributos do fornecedor e seta para os campos
        do formulario conforme clica sobre o registro da tabela na tela*/

        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = new Produto();
        LinhaDAO linhadao = new LinhaDAO();
        MarcaDAO marcadao = new MarcaDAO();
        

        int k = tblProduto.getSelectedRow();
        Object id = tblProduto.getValueAt(k, 0);
        txtCod.setText(id.toString());
        produto.setId(Integer.parseInt(id.toString()));

        //setar o restante dos campos
        int setar = tblProduto.getSelectedRow();
        txtDescricao.setText(dao.pesquisa_por_id((Integer) id).getDescricao());
        txtEstoque.setText(String.valueOf(dao.pesquisa_por_id((Integer) id).getEstoque()));
        txtvend.setText(dao.pesquisa_por_id((Integer) id).getPvenda().toString());
        txtCompra.setText(dao.pesquisa_por_id((Integer) id).getPcompra().toString());
        linhaComboModel.setSelectedItem(linhadao.pesquisa_por_id(dao.pesquisa_por_id((Integer) id).getId_linha()));
        marcaComboModel.setSelectedItem(marcadao.pesquisa_por_id(dao.pesquisa_por_id((Integer) id).getId_marca()));
        
        //botao salvar inativo
        btnSave.setEnabled(false);

    }//GEN-LAST:event_tblProdutoMouseClicked

    private void txtvendKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvendKeyPressed
        // TODO add your handling code here:

        
    }//GEN-LAST:event_txtvendKeyPressed

    private void txtvendFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtvendFocusLost
        // TODO add your handling code here:       
        /*
        String valorSemFormatar = txtvend.getText();
        String vsf = valorSemFormatar.replace("R$", "").replace(",", ".").replace(" ", "");
        BigDecimal valor = new BigDecimal(vsf);
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorFormatado = nf.format(valor);
        txtvend.setText(valorFormatado);
        */
    }//GEN-LAST:event_txtvendFocusLost

    private void txtCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCompraFocusLost
        // TODO add your handling code here:
       /*
        String valorSemFormatar = txtCompra.getText();
        String vsf = valorSemFormatar.replace("R$", "").replace(",", ".").replace(" ", "");
        BigDecimal valor = new BigDecimal(vsf);
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorFormatado = nf.format(valor);
        txtCompra.setText(valorFormatado);
        */
    }//GEN-LAST:event_txtCompraFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox ComboLinha;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSave;
    public javax.swing.JComboBox comboMarca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tblProduto;
    private javax.swing.JTextField txtCod;
    private javax.swing.JFormattedTextField txtCompra;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JFormattedTextField txtvend;
    // End of variables declaration//GEN-END:variables
}
