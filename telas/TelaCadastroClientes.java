package mobiliti.telas;

import java.sql.*;
import javax.swing.JOptionPane;
import mobiliti.connectiondb.ConnectionDB;

public class TelaCadastroClientes extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaCadastroClientes() {
        initComponents();
        conexao = ConnectionDB.conector();
    }

    //consultar cliente
    private void consultaCliente() {
        String sql = "select * from cliente where cpfCliente = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCpfCliente.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtNomeCliente.setText(rs.getString(2));
                txtEndCliente.setText(rs.getString(3));
                txtNumCasaCliente.setText(rs.getString(4));
                txtCepCliente.setText(rs.getString(5));
                txtBairroCliente.setText(rs.getString(6));
                txtCidadeCliente.setText(rs.getString(7));
                txtTelCliente.setText(rs.getString(8));
                txtDataNascCliente.setText(rs.getString(9));
                txtEmailCliente.setText(rs.getString(10));
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado no sistema");
                int cadastraCli = JOptionPane.showConfirmDialog(
                        null, "Deseja cadastrá-lo?", "Cadastro de Clientes", JOptionPane.YES_NO_OPTION);
                if (cadastraCli == JOptionPane.YES_OPTION) {
                    txtNomeCliente.setText(null);
                    txtEndCliente.setText(null);
                    txtNumCasaCliente.setText(null);
                    txtCepCliente.setText(null);
                    txtBairroCliente.setText(null);
                    txtCidadeCliente.setText(null);
                    txtTelCliente.setText(null);
                    txtDataNascCliente.setText(null);
                    txtEmailCliente.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //adicionar cliente
    private void adicionaCliente() {
        String sql = "insert into cliente(cpfCliente, nome, rua, numero, cep, bairro, cidade,"
                + "telefone, dataNasc, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCpfCliente.getText());
            pst.setString(2, txtNomeCliente.getText());
            pst.setString(3, txtEndCliente.getText());
            pst.setString(4, txtNumCasaCliente.getText());
            pst.setString(5, txtCepCliente.getText());
            pst.setString(6, txtBairroCliente.getText());
            pst.setString(7, txtCidadeCliente.getText());
            pst.setString(8, txtTelCliente.getText());
            pst.setString(9, txtDataNascCliente.getText());
            pst.setString(10, txtEmailCliente.getText());

            if (txtCpfCliente.getText().isEmpty() || (txtNomeCliente.getText().isEmpty()
                    || (txtTelCliente.getText().isEmpty() || (txtEmailCliente.getText().isEmpty())))) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                int cadastrado = pst.executeUpdate();

                if (cadastrado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
                    int cadastraNov = JOptionPane.showConfirmDialog(
                            null, "Deseja cadastrar outro cliente?", "Cadastro de Clientes", JOptionPane.YES_NO_OPTION);
                    if (cadastraNov == JOptionPane.YES_OPTION) {
                        txtCpfCliente.setText(null);
                        txtNomeCliente.setText(null);
                        txtEndCliente.setText(null);
                        txtNumCasaCliente.setText(null);
                        txtCepCliente.setText(null);
                        txtBairroCliente.setText(null);
                        txtCidadeCliente.setText(null);
                        txtTelCliente.setText(null);
                        txtDataNascCliente.setText(null);
                        txtEmailCliente.setText(null);
                    }
                    if (cadastraNov == JOptionPane.NO_OPTION) {
                        TelaCadastroClientes cadastraCli = new TelaCadastroClientes();
                        cadastraCli.setVisible(false);
                        this.dispose();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void editaCliente() {
        String sql = "update cliente set nome=?, rua=?, numero=?, cep=?, bairro=?, cidade=?, telefone=?, dataNasc=?, email=?"
                + "where cpfCliente=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeCliente.getText());
            pst.setString(2, txtEndCliente.getText());
            pst.setString(3, txtNumCasaCliente.getText());
            pst.setString(4, txtCepCliente.getText());
            pst.setString(5, txtBairroCliente.getText());
            pst.setString(6, txtCidadeCliente.getText());
            pst.setString(7, txtTelCliente.getText());
            pst.setString(8, txtDataNascCliente.getText());
            pst.setString(9, txtEmailCliente.getText());
            pst.setString(10, txtCpfCliente.getText());

            if (txtCpfCliente.getText().isEmpty() || (txtNomeCliente.getText().isEmpty()
                    || (txtTelCliente.getText().isEmpty() || (txtEmailCliente.getText().isEmpty())))) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {
                int cadastrado = pst.executeUpdate();

                if (cadastrado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
                    txtCpfCliente.setText(null);
                    txtNomeCliente.setText(null);
                    txtEndCliente.setText(null);
                    txtNumCasaCliente.setText(null);
                    txtCepCliente.setText(null);
                    txtBairroCliente.setText(null);
                    txtCidadeCliente.setText(null);
                    txtTelCliente.setText(null);
                    txtDataNascCliente.setText(null);
                    txtEmailCliente.setText(null);

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void deletaCliente() {
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este cliente?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            String sql = "delete from cliente where cpfCliente=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtCpfCliente.getText());
                int deletado = pst.executeUpdate();
                if (deletado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
                    txtCpfCliente.setText(null);
                    txtNomeCliente.setText(null);
                    txtEndCliente.setText(null);
                    txtNumCasaCliente.setText(null);
                    txtCepCliente.setText(null);
                    txtBairroCliente.setText(null);
                    txtCidadeCliente.setText(null);
                    txtTelCliente.setText(null);
                    txtDataNascCliente.setText(null);
                    txtEmailCliente.setText(null);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        txtCepCliente = new javax.swing.JTextField();
        txtNumCasaCliente = new javax.swing.JTextField();
        txtEmailCliente = new javax.swing.JTextField();
        txtEndCliente = new javax.swing.JTextField();
        txtCpfCliente = new javax.swing.JTextField();
        txtDataNascCliente = new javax.swing.JTextField();
        txtBairroCliente = new javax.swing.JTextField();
        txtCidadeCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTelCliente = new javax.swing.JTextField();
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Clientes");
        setPreferredSize(new java.awt.Dimension(800, 483));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("* Nome");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Data de Nascimento");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Endereço");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("CEP");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setText("Cidade");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel7.setText("* CPF");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel8.setText("* Telefone");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel9.setText("Número");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel10.setText("Bairro");

        txtDataNascCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataNascClienteActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel11.setText("* E-mail");

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
        jLabel15.setText("Orientações - Cadastro de Clientes");

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(14, 84, 115));
        jLabel16.setText("Para DELETAR, pesquise-o, pressione \"Consultar\" e após pressione o botão \"Deletar\"");

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(14, 84, 115));
        jLabel17.setText("Para ADICIONAR, preencha os dados e pressione o botão \"Adicionar\"");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 101, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAdicionarCliente)
                                .addGap(38, 38, 38)
                                .addComponent(btnConsultarCliente)
                                .addGap(38, 38, 38)
                                .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnDeletarCliente)
                                .addGap(138, 138, 138))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel17))
                                .addGap(153, 153, 153))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtBairroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNumCasaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCepCliente))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelCliente))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDataNascCliente))
                                    .addComponent(txtNomeCliente)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCidadeCliente)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(247, 247, 247))
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
                        .addContainerGap()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(txtDataNascCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEndCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCidadeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtBairroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtNumCasaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtCepCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionarCliente)
                    .addComponent(btnConsultarCliente)
                    .addComponent(btnEditarCliente)
                    .addComponent(btnDeletarCliente))
                .addGap(25, 25, 25))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdicionarCliente, btnConsultarCliente, btnDeletarCliente, btnEditarCliente});

        setBounds(0, 0, 799, 488);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDataNascClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataNascClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataNascClienteActionPerformed

    private void btnConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarClienteActionPerformed
        consultaCliente();
    }//GEN-LAST:event_btnConsultarClienteActionPerformed

    private void btnAdicionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarClienteActionPerformed
        adicionaCliente();
    }//GEN-LAST:event_btnAdicionarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        editaCliente();
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnDeletarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarClienteActionPerformed
        deletaCliente();
    }//GEN-LAST:event_btnDeletarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarCliente;
    private javax.swing.JButton btnConsultarCliente;
    private javax.swing.JButton btnDeletarCliente;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBairroCliente;
    private javax.swing.JTextField txtCepCliente;
    private javax.swing.JTextField txtCidadeCliente;
    private javax.swing.JTextField txtCpfCliente;
    private javax.swing.JTextField txtDataNascCliente;
    private javax.swing.JTextField txtEmailCliente;
    private javax.swing.JTextField txtEndCliente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNumCasaCliente;
    private javax.swing.JTextField txtTelCliente;
    // End of variables declaration//GEN-END:variables
}
