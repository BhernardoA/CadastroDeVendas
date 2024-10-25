/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens;

/**
 *
 * @author marco
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        
        jBCadastrarCliente.setOpaque(false);    
        jBCadastrarCliente.setContentAreaFilled(false);
        jBCadastrarCliente.setBorderPainted(false);

	jBCadastrarVenda.setOpaque(false);   
        jBCadastrarVenda.setContentAreaFilled(false);
        jBCadastrarVenda.setBorderPainted(false);
          
        jBListaDeVendas.setOpaque(false);  
        jBListaDeVendas.setContentAreaFilled(false);
        jBListaDeVendas.setBorderPainted(false);
        
        jBListaDeClientes.setOpaque(false);  
        jBListaDeClientes.setContentAreaFilled(false);
        jBListaDeClientes.setBorderPainted(false);

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBCadastrarCliente = new javax.swing.JButton();
        jBCadastrarVenda = new javax.swing.JButton();
        jBListaDeVendas = new javax.swing.JButton();
        jBListaDeClientes = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBCadastrarCliente.setBackground(new java.awt.Color(204, 204, 204));
        jBCadastrarCliente.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jBCadastrarCliente.setForeground(new java.awt.Color(0, 0, 0));
        jBCadastrarCliente.setText("Cadastrar Cliente");
        jBCadastrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jBCadastrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 220, 90));

        jBCadastrarVenda.setBackground(new java.awt.Color(204, 204, 204));
        jBCadastrarVenda.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jBCadastrarVenda.setForeground(new java.awt.Color(0, 0, 0));
        jBCadastrarVenda.setText("Cadastrar venda");
        jBCadastrarVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBCadastrarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarVendaActionPerformed(evt);
            }
        });
        getContentPane().add(jBCadastrarVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 220, 90));

        jBListaDeVendas.setBackground(new java.awt.Color(204, 204, 204));
        jBListaDeVendas.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jBListaDeVendas.setForeground(new java.awt.Color(0, 0, 0));
        jBListaDeVendas.setText("Lista de vendas");
        jBListaDeVendas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBListaDeVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListaDeVendasActionPerformed(evt);
            }
        });
        getContentPane().add(jBListaDeVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 200, 110));

        jBListaDeClientes.setBackground(new java.awt.Color(204, 204, 204));
        jBListaDeClientes.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jBListaDeClientes.setForeground(new java.awt.Color(0, 0, 0));
        jBListaDeClientes.setText("Lista de clientes");
        jBListaDeClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBListaDeClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBListaDeClientesActionPerformed(evt);
            }
        });
        getContentPane().add(jBListaDeClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 200, 110));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Ferro-velho Reciclagem L.M. Fernandes LTDA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 780, 170));

        jLabel1.setBackground(new java.awt.Color(102, 0, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 102));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarClienteActionPerformed
        // TODO add your handling code here:
        ScreenCadastrarCliente screenCC = new ScreenCadastrarCliente();
        screenCC.setVisible(true);
    }//GEN-LAST:event_jBCadastrarClienteActionPerformed

    private void jBCadastrarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarVendaActionPerformed
        // TODO add your handling code here:
        ScreenCadastrarVenda screenCV = new ScreenCadastrarVenda();
        screenCV.setVisible(true);

    }//GEN-LAST:event_jBCadastrarVendaActionPerformed

    private void jBListaDeVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListaDeVendasActionPerformed
        // TODO add your handling code here:
        ScreenListaDeVendas screenLV = new ScreenListaDeVendas();
        screenLV.setVisible(true);
    }//GEN-LAST:event_jBListaDeVendasActionPerformed

    private void jBListaDeClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBListaDeClientesActionPerformed
        // TODO add your handling code here:
        ScreenListaDeClientes screenLC = new ScreenListaDeClientes();
        screenLC.setVisible(true);

    }//GEN-LAST:event_jBListaDeClientesActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrarCliente;
    private javax.swing.JButton jBCadastrarVenda;
    private javax.swing.JButton jBListaDeClientes;
    private javax.swing.JButton jBListaDeVendas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
