
package mobiliti.telas;

import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deskPrincipal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Motocicleta = new javax.swing.JMenu();
        CadastraClientes = new javax.swing.JMenuItem();
        CadastroBicicletas = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        options = new javax.swing.JMenu();
        OptionSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MobiliTI");
        setResizable(false);

        deskPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        deskPrincipal.setPreferredSize(new java.awt.Dimension(800, 483));

        javax.swing.GroupLayout deskPrincipalLayout = new javax.swing.GroupLayout(deskPrincipal);
        deskPrincipal.setLayout(deskPrincipalLayout);
        deskPrincipalLayout.setHorizontalGroup(
            deskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        deskPrincipalLayout.setVerticalGroup(
            deskPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        Motocicleta.setText("Cadastro");

        CadastraClientes.setText("Clientes");
        CadastraClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastraClientesActionPerformed(evt);
            }
        });
        Motocicleta.add(CadastraClientes);

        CadastroBicicletas.setText("Bicicletas");
        CadastroBicicletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroBicicletasActionPerformed(evt);
            }
        });
        Motocicleta.add(CadastroBicicletas);

        jMenuBar1.add(Motocicleta);

        jMenu3.setText("Aluguel");

        jMenuItem3.setText("Retirar Bicicleta");
        jMenu3.add(jMenuItem3);

        jMenuItem5.setText("Devolver Bicicleta");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Relatórios");

        jMenuItem4.setText("Relatório de Aluguéis");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        options.setText("Opções");
        options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsActionPerformed(evt);
            }
        });

        OptionSair.setText("Sair");
        OptionSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionSairActionPerformed(evt);
            }
        });
        options.add(OptionSair);

        jMenuBar1.add(options);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deskPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(deskPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(816, 543));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CadastraClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastraClientesActionPerformed
        TelaCadastroClientes cliente = new TelaCadastroClientes();
        cliente.setVisible(true);
        deskPrincipal.add(cliente);
    }//GEN-LAST:event_CadastraClientesActionPerformed

    private void CadastroBicicletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroBicicletasActionPerformed
        TelaCadastroBicicletas bicicleta = new TelaCadastroBicicletas();
        bicicleta.setVisible(true);
        deskPrincipal.add(bicicleta);
    }//GEN-LAST:event_CadastroBicicletasActionPerformed

    private void optionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsActionPerformed
        // TODO add your handling code here:
 
    }//GEN-LAST:event_optionsActionPerformed

    private void OptionSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionSairActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair do sistema?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_OptionSairActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CadastraClientes;
    private javax.swing.JMenuItem CadastroBicicletas;
    private javax.swing.JMenu Motocicleta;
    private javax.swing.JMenuItem OptionSair;
    private javax.swing.JDesktopPane deskPrincipal;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu options;
    // End of variables declaration//GEN-END:variables
}
