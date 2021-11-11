package mobiliti.telas;

import java.sql.*;
import javax.swing.JOptionPane;
import mobiliti.connectiondb.ConnectionDB;

public class TelaCadastroBicicletas extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaCadastroBicicletas() {
        initComponents();
        conexao = ConnectionDB.conector();
    }

    //consultar cliente
    private void consultaBicicleta() {
        String sql = "select * from bicicleta where codigo = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCodBic.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtValorAluguel.setText(rs.getString(2));
                txtFabricante.setText(rs.getString(3));
                txtDataFab.setText(rs.getString(4));
                txtModelo.setText(rs.getString(5));
                txtCor.setText(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Bicicleta não encontrada no sistema");
                int cadastraCli = JOptionPane.showConfirmDialog(
                        null, "Deseja cadastrá-lo?", "Cadastro de Bicicletas", JOptionPane.YES_NO_OPTION);
                if (cadastraCli == JOptionPane.YES_OPTION) {
                    txtValorAluguel.setText(null);
                    txtFabricante.setText(null);
                    txtModelo.setText(null);
                    txtCor.setText(null);
                    txtDataFab.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //adicionar cliente
    private void adicionaBicicleta() {
        String sql = "insert into bicicleta(codigo, valorAluguel, fabricante, dataFabricacao, modelo, cor) values (?, ?, ?, ?, ?, ?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCodBic.getText());
            pst.setString(2, txtValorAluguel.getText());
            pst.setString(3, txtFabricante.getText());
            pst.setString(4, txtDataFab.getText());
            pst.setString(5, txtModelo.getText());
            pst.setString(6, txtCor.getText());

            if (txtCodBic.getText().isEmpty() || (txtValorAluguel.getText().isEmpty()
                    || (txtFabricante.getText().isEmpty() || (txtModelo.getText().isEmpty()
                    || (txtCor.getText().isEmpty() || (txtDataFab.getText().isEmpty())))))) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                int cadastrado = pst.executeUpdate();

                if (cadastrado > 0) {
                    JOptionPane.showMessageDialog(null, "Bicicleta adicionada com sucesso");
                    int cadastraNov = JOptionPane.showConfirmDialog(
                            null, "Deseja cadastrar outra bicicleta?", "Cadastro de Bicicletas", JOptionPane.YES_NO_OPTION);
                    if (cadastraNov == JOptionPane.YES_OPTION) {
                        txtCodBic.setText(null);
                        txtValorAluguel.setText(null);
                        txtFabricante.setText(null);
                        txtModelo.setText(null);
                        txtCor.setText(null);
                        txtDataFab.setText(null);
                    }
                    if (cadastraNov == JOptionPane.NO_OPTION) {
                        TelaCadastroBicicletas cadastraBic = new TelaCadastroBicicletas();
                        cadastraBic.setVisible(false);
                        this.dispose();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void editaBicicleta() {
        String sql = "update bicicleta set valorAluguel=?, fabricante=?, dataFabricacao=?, modelo=?, cor=? where codigo=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtValorAluguel.getText());
            pst.setString(2, txtFabricante.getText());
            pst.setString(3, txtDataFab.getText());
            pst.setString(4, txtModelo.getText());
            pst.setString(5, txtCor.getText());
            pst.setString(6, txtCodBic.getText());

            if (txtCodBic.getText().isEmpty() || (txtValorAluguel.getText().isEmpty()
                    || (txtFabricante.getText().isEmpty() || (txtModelo.getText().isEmpty()
                    || (txtCor.getText().isEmpty() || (txtDataFab.getText().isEmpty())))))) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                int cadastrado = pst.executeUpdate();

                if (cadastrado > 0) {
                    JOptionPane.showMessageDialog(null, "Bicicleta alterada com sucesso");
                    txtCodBic.setText(null);
                    txtValorAluguel.setText(null);
                    txtFabricante.setText(null);
                    txtModelo.setText(null);
                    txtCor.setText(null);
                    txtDataFab.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void deletaBicicleta() {
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esta bicicleta?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            String sql = "delete from bicicleta where codigo=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtCodBic.getText());
                int deletado = pst.executeUpdate();
                if (deletado > 0) {
                    JOptionPane.showMessageDialog(null, "Bicicleta removida com sucesso");
                    txtCodBic.setText(null);
                    txtValorAluguel.setText(null);
                    txtFabricante.setText(null);
                    txtModelo.setText(null);
                    txtCor.setText(null);
                    txtDataFab.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtValorAluguel = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtFabricante = new javax.swing.JTextField();
        txtDataFab = new javax.swing.JTextField();
        btnAdicionarCliente = new javax.swing.JButton();
        btnConsultarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnDeletarCliente = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCodBic = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Bicicletas");
        setPreferredSize(new java.awt.Dimension(800, 483));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("* Valor do Aluguel");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("* Fabricante");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("*Cor");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel9.setText("* Modelo");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel10.setText("* Data de Fabricação");

        btnAdicionarCliente.setBackground(new java.awt.Color(14, 84, 115));
        btnAdicionarCliente.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAdicionarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnAdicionarCliente.setText("Adicionar");
        btnAdicionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarClienteActionPerformed(evt);
            }
        });

        btnConsultarCliente.setBackground(new java.awt.Color(14, 84, 115));
        btnConsultarCliente.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnConsultarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultarCliente.setText("Consultar");
        btnConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setBackground(new java.awt.Color(14, 84, 115));
        btnEditarCliente.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnEditarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarCliente.setText("Editar");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        btnDeletarCliente.setBackground(new java.awt.Color(14, 84, 115));
        btnDeletarCliente.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnDeletarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletarCliente.setText("Deletar");
        btnDeletarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarClienteActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(14, 84, 115));
        jLabel12.setText("Para CONSULTAR, informe seu CPF e pressione o botão \"Consultar\"");

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("* Campos obrigatórios");

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(14, 84, 115));
        jLabel14.setText("Para EDITAR, pesquise-o, altere o campo desejado e pressione o botão \"Editar\"");

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(14, 84, 115));
        jLabel15.setText("Orientações - Cadastro de Bicicletas");

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(14, 84, 115));
        jLabel16.setText("Para DELETAR, pesquise-o, pressione \"Consultar\" e após pressione o botão \"Deletar\"");

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(14, 84, 115));
        jLabel17.setText("Para ADICIONAR, preencha os dados e pressione o botão \"Adicionar\"");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("* Código da Bicicleta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdicionarCliente)
                        .addGap(38, 38, 38)
                        .addComponent(btnConsultarCliente)
                        .addGap(38, 38, 38)
                        .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnDeletarCliente)
                        .addGap(128, 128, 128))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodBic))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFabricante))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtValorAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtDataFab)))
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel17))
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(149, 149, 149)))
                        .addGap(89, 89, 89))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdicionarCliente, btnConsultarCliente, btnDeletarCliente, btnEditarCliente});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodBic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txtValorAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtDataFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarCliente)
                    .addComponent(btnConsultarCliente)
                    .addComponent(btnEditarCliente)
                    .addComponent(btnDeletarCliente))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdicionarCliente, btnConsultarCliente, btnDeletarCliente, btnEditarCliente});

        setBounds(0, 0, 799, 488);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarClienteActionPerformed
        consultaBicicleta();
    }//GEN-LAST:event_btnConsultarClienteActionPerformed

    private void btnAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarClienteActionPerformed
        adicionaBicicleta();
    }//GEN-LAST:event_btnAdicionarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        editaBicicleta();
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnDeletarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarClienteActionPerformed
        deletaBicicleta();
    }//GEN-LAST:event_btnDeletarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarCliente;
    private javax.swing.JButton btnConsultarCliente;
    private javax.swing.JButton btnDeletarCliente;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCodBic;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtDataFab;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtValorAluguel;
    // End of variables declaration//GEN-END:variables
}
